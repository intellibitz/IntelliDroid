

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.expandable;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.ItemDraggableRange;

public class ChildPositionItemDraggableRange extends ItemDraggableRange {
    public ChildPositionItemDraggableRange(int start, int end) {
        super(start, end);
    }

    protected String getClassName() {
        return "ChildPositionItemDraggableRange";
    }
}
