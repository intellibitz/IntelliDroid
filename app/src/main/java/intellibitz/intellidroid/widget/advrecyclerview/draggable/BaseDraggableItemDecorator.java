

package intellibitz.intellidroid.widget.advrecyclerview.draggable;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

abstract class BaseDraggableItemDecorator extends RecyclerView.ItemDecoration {

    private static final int RETURN_TO_DEFAULT_POS_ANIMATE_THRESHOLD_DP = 2;
    private static final int RETURN_TO_DEFAULT_POS_ANIMATE_THRESHOLD_MSEC = 20;
    protected final RecyclerView mRecyclerView;
    private final int mReturnToDefaultPositionAnimateThreshold;
    protected RecyclerView.ViewHolder mDraggingItemViewHolder;
    private int mReturnToDefaultPositionDuration = 200;
    private Interpolator mReturnToDefaultPositionInterpolator;

    public BaseDraggableItemDecorator(RecyclerView recyclerView, RecyclerView.ViewHolder draggingItemViewHolder) {
        mRecyclerView = recyclerView;
        mDraggingItemViewHolder = draggingItemViewHolder;

        final float displayDensity = recyclerView.getResources().getDisplayMetrics().density;
        mReturnToDefaultPositionAnimateThreshold = (int) (RETURN_TO_DEFAULT_POS_ANIMATE_THRESHOLD_DP * displayDensity + 0.5f);
    }

    protected static void setItemTranslation(RecyclerView rv, RecyclerView.ViewHolder holder, float x, float y) {
        final RecyclerView.ItemAnimator itemAnimator = rv.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimation(holder);
        }
        ViewCompat.setTranslationX(holder.itemView, x);
        ViewCompat.setTranslationY(holder.itemView, y);
    }

    private static boolean supportsViewPropertyAnimation() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public void setReturnToDefaultPositionAnimationDuration(int duration) {
        mReturnToDefaultPositionDuration = duration;
    }

    public void setReturnToDefaultPositionAnimationInterpolator(Interpolator interpolator) {
        mReturnToDefaultPositionInterpolator = interpolator;
    }

    protected void moveToDefaultPosition(View targetView, boolean animate) {
        final int curTranslationX = (int) (ViewCompat.getTranslationX(targetView));
        final int curTranslationY = (int) (ViewCompat.getTranslationY(targetView));
        final int halfItemWidth = targetView.getWidth() / 2;
        final int halfItemHeight = targetView.getHeight() / 2;
        final float translationProportionX = (halfItemWidth > 0) ? Math.abs((float) curTranslationX / halfItemWidth) : 0;
        final float translationProportionY = (halfItemHeight > 0) ? Math.abs((float) curTranslationY / halfItemHeight) : 0;
        final float tx = 1.0f - Math.min(translationProportionX, 1.0f);
        final float ty = 1.0f - Math.min(translationProportionY, 1.0f);
        final int animDurationX = (int) (mReturnToDefaultPositionDuration * (1.0f - (tx * tx)) + 0.5f);
        final int animDurationY = (int) (mReturnToDefaultPositionDuration * (1.0f - (ty * ty)) + 0.5f);
        final int animDuration = Math.max(animDurationX, animDurationY);
        final int maxAbsTranslation = Math.max(Math.abs(curTranslationX), Math.abs(curTranslationY));

        if (supportsViewPropertyAnimation() && animate &&
                (animDuration > RETURN_TO_DEFAULT_POS_ANIMATE_THRESHOLD_MSEC) &&
                (maxAbsTranslation > mReturnToDefaultPositionAnimateThreshold)) {
            final ViewPropertyAnimatorCompat animator = ViewCompat.animate(targetView);
            animator.cancel();
            animator.setDuration(animDuration);
            animator.setInterpolator(mReturnToDefaultPositionInterpolator);
            animator.translationX(0.0f);
            animator.translationY(0.0f);
            animator.setListener(new ViewPropertyAnimatorListener() {
                @Override
                public void onAnimationStart(View view) {
                }

                @Override
                public void onAnimationEnd(View view) {
                    animator.setListener(null);
                    ViewCompat.setTranslationX(view, 0);
                    ViewCompat.setTranslationY(view, 0);

                    // invalidate explicitly to refresh other decorations
                    if (view.getParent() instanceof RecyclerView) {
                        ViewCompat.postInvalidateOnAnimation((RecyclerView) view.getParent());
                    }
                }

                @Override
                public void onAnimationCancel(View view) {
                }
            });
            animator.start();
        } else {
            ViewCompat.setTranslationX(targetView, 0);
            ViewCompat.setTranslationY(targetView, 0);
        }
    }
}
