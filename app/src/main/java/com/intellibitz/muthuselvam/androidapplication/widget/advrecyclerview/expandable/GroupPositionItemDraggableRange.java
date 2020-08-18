

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.expandable;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.ItemDraggableRange;

public class GroupPositionItemDraggableRange extends ItemDraggableRange {
    public GroupPositionItemDraggableRange(int start, int end) {
        super(start, end);
    }

    protected String getClassName() {
        return "GroupPositionItemDraggableRange";
    }
}
