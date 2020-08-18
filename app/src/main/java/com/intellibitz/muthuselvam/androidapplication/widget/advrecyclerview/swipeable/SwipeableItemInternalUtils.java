

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.action.SwipeResultAction;

import androidx.recyclerview.widget.RecyclerView;

public class SwipeableItemInternalUtils {
    private SwipeableItemInternalUtils() {
    }

    @SuppressWarnings("unchecked")
    public static SwipeResultAction invokeOnSwipeItem(
            BaseSwipeableItemAdapter<?> adapter, RecyclerView.ViewHolder holder, int position, int result) {
        return ((SwipeableItemAdapter) adapter).onSwipeItem(holder, position, result);
    }
}
