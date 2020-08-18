

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.annotation;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.DraggableItemConstants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef(flag = true, value = {
        DraggableItemConstants.STATE_FLAG_DRAGGING,
        DraggableItemConstants.STATE_FLAG_IS_ACTIVE,
        DraggableItemConstants.STATE_FLAG_IS_IN_RANGE,
        DraggableItemConstants.STATE_FLAG_IS_UPDATED,
})
@Retention(RetentionPolicy.SOURCE)
public @interface DraggableItemStateFlags {
}
