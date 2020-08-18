

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.annotation;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef(flag = true, value = {
        SwipeableItemConstants.AFTER_SWIPE_REACTION_DEFAULT,
        SwipeableItemConstants.AFTER_SWIPE_REACTION_MOVE_TO_SWIPED_DIRECTION,
        SwipeableItemConstants.AFTER_SWIPE_REACTION_REMOVE_ITEM,
})
@Retention(RetentionPolicy.SOURCE)
public @interface SwipeableItemAfterReactions {
}
