

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.annotation;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.swipeable.SwipeableItemConstants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef(flag = false, value = {
        SwipeableItemConstants.DRAWABLE_SWIPE_NEUTRAL_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_LEFT_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_UP_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_RIGHT_BACKGROUND,
        SwipeableItemConstants.DRAWABLE_SWIPE_DOWN_BACKGROUND,
})
@Retention(RetentionPolicy.SOURCE)
public @interface SwipeableItemDrawableTypes {
}
