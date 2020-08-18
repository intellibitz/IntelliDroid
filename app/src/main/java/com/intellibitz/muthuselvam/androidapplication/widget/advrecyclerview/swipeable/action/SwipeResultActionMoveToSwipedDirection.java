

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.action;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager;

public abstract class SwipeResultActionMoveToSwipedDirection extends SwipeResultAction {
    public SwipeResultActionMoveToSwipedDirection() {
        super(RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION);
    }
}
