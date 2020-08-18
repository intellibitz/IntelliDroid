

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.annotation.DraggableItemStateFlags;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Interface which provides required information for dragging item.
 * <p/>
 * Implement this interface on your sub-class of the {@link RecyclerView.ViewHolder}.
 */
public interface DraggableItemViewHolder {
    /**
     * Gets the state flags value for dragging item
     *
     * @return Bitwise OR of these flags;
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_DRAGGING}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_IS_ACTIVE}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_IS_IN_RANGE}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_IS_UPDATED}
     */
    @DraggableItemStateFlags
    int getDragStateFlags();

    /**
     * Sets the state flags value for dragging item
     *
     * @param flags Bitwise OR of these flags;
     *              - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_DRAGGING}
     *              - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_IS_ACTIVE}
     *              - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_IS_IN_RANGE}
     *              - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants#STATE_FLAG_IS_UPDATED}
     */
    void setDragStateFlags(@DraggableItemStateFlags int flags);
}
