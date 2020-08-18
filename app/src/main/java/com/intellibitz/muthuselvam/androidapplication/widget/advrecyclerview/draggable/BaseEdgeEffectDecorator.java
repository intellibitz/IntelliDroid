

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable;

import android.graphics.Canvas;

import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.widget.RecyclerView;

abstract class BaseEdgeEffectDecorator extends RecyclerView.ItemDecoration {
    protected static final int EDGE_LEFT = 0;
    protected static final int EDGE_TOP = 1;
    protected static final int EDGE_RIGHT = 2;
    protected static final int EDGE_BOTTOM = 3;
    private RecyclerView mRecyclerView;
    private EdgeEffectCompat mGlow1;
    private EdgeEffectCompat mGlow2;
    private boolean mStarted;
    private int mGlow1Dir;
    private int mGlow2Dir;

    public BaseEdgeEffectDecorator(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    private static boolean drawGlow(Canvas c, RecyclerView parent, int dir, EdgeEffectCompat edge) {
        if (edge.isFinished()) {
            return false;
        }

        final int restore = c.save();
        final boolean clipToPadding = getClipToPadding(parent);

        switch (dir) {
            case EDGE_TOP:
                if (clipToPadding) {
                    c.translate(parent.getPaddingLeft(), parent.getPaddingTop());
                }
                break;
            case EDGE_BOTTOM:
                c.rotate(180);
                if (clipToPadding) {
                    c.translate(-parent.getWidth() + parent.getPaddingRight(), -parent.getHeight() + parent.getPaddingBottom());
                } else {
                    c.translate(-parent.getWidth(), -parent.getHeight());
                }
                break;
            case EDGE_LEFT:
                c.rotate(-90);
                if (clipToPadding) {
                    c.translate(-parent.getHeight() + parent.getPaddingTop(), parent.getPaddingLeft());
                } else {
                    c.translate(-parent.getHeight(), 0);
                }
                break;
            case EDGE_RIGHT:
                c.rotate(90);
                if (clipToPadding) {
                    c.translate(parent.getPaddingTop(), -parent.getWidth() + parent.getPaddingRight());
                } else {
                    c.translate(0, -parent.getWidth());
                }
                break;
        }

        boolean needsInvalidate = edge.draw(c);

        c.restoreToCount(restore);

        return needsInvalidate;
    }

    private static void updateGlowSize(RecyclerView rv, EdgeEffectCompat glow, int dir) {
        int width = rv.getMeasuredWidth();
        int height = rv.getMeasuredHeight();

        if (getClipToPadding(rv)) {
            width -= rv.getPaddingLeft() + rv.getPaddingRight();
            height -= rv.getPaddingTop() + rv.getPaddingBottom();
        }

        width = Math.max(0, width);
        height = Math.max(0, height);

        if (dir == EDGE_LEFT || dir == EDGE_RIGHT) {
            int t = width;
            //noinspection SuspiciousNameCombination
            width = height;
            height = t;
        }

        glow.setSize(width, height);
    }

    private static boolean getClipToPadding(RecyclerView rv) {
        return rv.getLayoutManager().getClipToPadding();
    }

    protected abstract int getEdgeDirection(int no);

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        boolean needsInvalidate = false;

        if (mGlow1 != null) {
            needsInvalidate |= drawGlow(c, parent, mGlow1Dir, mGlow1);
        }

        if (mGlow2 != null) {
            needsInvalidate |= drawGlow(c, parent, mGlow2Dir, mGlow2);
        }

        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(parent);
        }
    }

    public void start() {
        if (mStarted) {
            return;
        }
        mGlow1Dir = getEdgeDirection(0);
        mGlow2Dir = getEdgeDirection(1);
        mRecyclerView.addItemDecoration(this);
        mStarted = true;
    }

    public void finish() {
        if (mStarted) {
            mRecyclerView.removeItemDecoration(this);
        }
        releaseBothGlows();
        mRecyclerView = null;
        mStarted = false;
    }

    public void pullFirstEdge(float deltaDistance) {
        ensureGlow1(mRecyclerView);

        if (mGlow1.onPull(deltaDistance, 0.5f)) {
            ViewCompat.postInvalidateOnAnimation(mRecyclerView);
        }
    }

    public void pullSecondEdge(float deltaDistance) {
        ensureGlow2(mRecyclerView);

        if (mGlow2.onPull(deltaDistance, 0.5f)) {
            ViewCompat.postInvalidateOnAnimation(mRecyclerView);
        }
    }

    public void releaseBothGlows() {
        boolean needsInvalidate = false;

        if (mGlow1 != null) {
            //noinspection ConstantConditions
            needsInvalidate |= mGlow1.onRelease();
        }

        if (mGlow2 != null) {
            needsInvalidate |= mGlow2.onRelease();
        }

        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(mRecyclerView);
        }
    }

    private void ensureGlow1(RecyclerView rv) {
        if (mGlow1 == null) {
            mGlow1 = new EdgeEffectCompat(rv.getContext());
        }

        updateGlowSize(rv, mGlow1, mGlow1Dir);
    }

    private void ensureGlow2(RecyclerView rv) {
        if (mGlow2 == null) {
            mGlow2 = new EdgeEffectCompat(rv.getContext());
        }
        updateGlowSize(rv, mGlow2, mGlow2Dir);
    }

    public void reorderToTop() {
        if (mStarted) {
            mRecyclerView.removeItemDecoration(this);
            mRecyclerView.addItemDecoration(this);
        }
    }
}
