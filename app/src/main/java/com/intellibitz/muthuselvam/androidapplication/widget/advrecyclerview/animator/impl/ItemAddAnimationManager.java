

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.animator.impl;

import android.util.Log;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.animator.BaseItemAnimator;

import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemAddAnimationManager extends BaseItemAnimationManager<com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.animator.impl.AddAnimationInfo> {
    private static final String TAG = "ARVItemAddAnimMgr";

    public ItemAddAnimationManager(BaseItemAnimator itemAnimator) {
        super(itemAnimator);
    }

    @Override
    public long getDuration() {
        return mItemAnimator.getAddDuration();
    }

    @Override
    public void setDuration(long duration) {
        mItemAnimator.setAddDuration(duration);
    }

    @Override
    public void dispatchStarting(com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.animator.impl.AddAnimationInfo info, RecyclerView.ViewHolder item) {
        if (debugLogEnabled()) {
            Log.d(TAG, "dispatchAddStarting(" + item + ")");
        }
        mItemAnimator.dispatchAddStarting(item);
    }

    @Override
    public void dispatchFinished(com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.animator.impl.AddAnimationInfo info, RecyclerView.ViewHolder item) {
        if (debugLogEnabled()) {
            Log.d(TAG, "dispatchAddFinished(" + item + ")");
        }
        mItemAnimator.dispatchAddFinished(item);
    }

    @Override
    protected boolean endNotStartedAnimation(AddAnimationInfo info, RecyclerView.ViewHolder item) {
        if ((info.holder != null) && ((item == null) || (info.holder == item))) {
            onAnimationEndedBeforeStarted(info, info.holder);
            dispatchFinished(info, info.holder);
            info.clear(info.holder);
            return true;
        } else {
            return false;
        }
    }

    public abstract boolean addPendingAnimation(RecyclerView.ViewHolder item);
}
