

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.annotation.SwipeableItemDrawableTypes;
import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.annotation.SwipeableItemReactions;

import androidx.recyclerview.widget.RecyclerView;

public interface BaseSwipeableItemAdapter<T extends RecyclerView.ViewHolder> {

    /**
     * Called when user is attempt to swipe the item.
     *
     * @param holder   The ViewHolder which is associated to item user is attempt to start swiping.
     * @param position The position of the item within the adapter's data set.
     * @param x        Touched X position. Relative from the itemView's top-left.
     * @param y        Touched Y position. Relative from the itemView's top-left.
     * @return Reaction type. Bitwise OR of these flags;
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_LEFT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_LEFT_WITH_RUBBER_BAND_EFFECT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_SWIPE_LEFT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_UP}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_UP_WITH_RUBBER_BAND_EFFECT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_SWIPE_UP}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_RIGHT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_RIGHT_WITH_RUBBER_BAND_EFFECT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_SWIPE_RIGHT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_DOWN}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_NOT_SWIPE_DOWN_WITH_RUBBER_BAND_EFFECT}
     * - {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#REACTION_CAN_SWIPE_DOWN}
     */
    @SwipeableItemReactions
    int onGetSwipeReactionType(T holder, int position, int x, int y);

    /**
     * Called when sets background of the swiping item.
     *
     * @param holder   The ViewHolder which is associated to the swiping item.
     * @param position The position of the item within the adapter's data set.
     * @param type     Background type. One of the
     *                 {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_NEUTRAL_BACKGROUND},
     *                 {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_LEFT_BACKGROUND},
     *                 {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_UP_BACKGROUND},
     *                 {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_RIGHT_BACKGROUND} or
     *                 {@link SwipeableItemConstants#DRAWABLE_SWIPE_DOWN_BACKGROUND}.
     */
    void onSetSwipeBackground(T holder, int position, @SwipeableItemDrawableTypes int type);
}
