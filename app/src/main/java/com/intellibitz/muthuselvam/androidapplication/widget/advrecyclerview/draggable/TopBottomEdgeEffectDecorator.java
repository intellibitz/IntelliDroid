

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable;

import androidx.recyclerview.widget.RecyclerView;

class TopBottomEdgeEffectDecorator extends com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.draggable.BaseEdgeEffectDecorator {
    public TopBottomEdgeEffectDecorator(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    protected int getEdgeDirection(int no) {
        switch (no) {
            case 0:
                return EDGE_TOP;
            case 1:
                return EDGE_BOTTOM;
            default:
                throw new IllegalArgumentException();
        }
    }
}
