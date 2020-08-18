

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.expandable;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.annotation.SwipeableItemDrawableTypes;
import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.annotation.SwipeableItemReactions;

import androidx.recyclerview.widget.RecyclerView;

public interface BaseExpandableSwipeableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    /**
     * Called when user is attempt to swipe the group item.
     *
     * @param holder        The ViewHolder which is associated to item user is attempt to start swiping.
     * @param groupPosition Group position.
     * @param x             Touched X position. Relative from the itemView's top-left.
     * @param y             Touched Y position. Relative from the itemView's top-left.
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
    int onGetGroupItemSwipeReactionType(GVH holder, int groupPosition, int x, int y);

    /**
     * Called when user is attempt to swipe the child item.
     *
     * @param holder        The ViewHolder which is associated to item user is attempt to start swiping.
     * @param groupPosition Group position.
     * @param childPosition Child position.
     * @param x             Touched X position. Relative from the itemView's top-left.
     * @param y             Touched Y position. Relative from the itemView's top-left.
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
    int onGetChildItemSwipeReactionType(CVH holder, int groupPosition, int childPosition, int x, int y);

    /**
     * Called when sets background of the swiping group item.
     *
     * @param holder        The ViewHolder which is associated to the swiping item.
     * @param groupPosition Group position.
     * @param type          Background type. One of the
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_NEUTRAL_BACKGROUND},
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_LEFT_BACKGROUND},
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_UP_BACKGROUND},
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_RIGHT_BACKGROUND} or
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_DOWN_BACKGROUND}.
     */
    void onSetGroupItemSwipeBackground(GVH holder, int groupPosition, @SwipeableItemDrawableTypes int type);


    /**
     * Called when sets background of the swiping child item.
     *
     * @param holder        The ViewHolder which is associated to the swiping item.
     * @param groupPosition Group position.
     * @param childPosition Child position.
     * @param type          Background type. One of the
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_NEUTRAL_BACKGROUND},
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_LEFT_BACKGROUND},
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_UP_BACKGROUND},
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_RIGHT_BACKGROUND} or
     *                      {@link com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants#DRAWABLE_SWIPE_DOWN_BACKGROUND}.
     */
    void onSetChildItemSwipeBackground(CVH holder, int groupPosition, int childPosition, @SwipeableItemDrawableTypes int type);
}
