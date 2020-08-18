

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.action;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager;

public abstract class SwipeResultActionRemoveItem extends SwipeResultAction {
    public SwipeResultActionRemoveItem() {
        super(RecyclerViewSwipeManager.AFTER_SWIPE_REACTION_REMOVE_ITEM);
    }
}
