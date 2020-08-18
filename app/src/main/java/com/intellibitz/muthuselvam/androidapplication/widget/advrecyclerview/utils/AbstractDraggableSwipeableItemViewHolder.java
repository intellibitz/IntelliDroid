

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.utils;

import android.view.View;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.annotation.DraggableItemStateFlags;

public abstract class AbstractDraggableSwipeableItemViewHolder extends AbstractSwipeableItemViewHolder implements DraggableItemViewHolder {
    @DraggableItemStateFlags
    private int mDragStateFlags;

    public AbstractDraggableSwipeableItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    @DraggableItemStateFlags
    public int getDragStateFlags() {
        return mDragStateFlags;
    }

    @Override
    public void setDragStateFlags(@DraggableItemStateFlags int flags) {
        mDragStateFlags = flags;
    }
}
