

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.utils;

import android.view.View;

import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.expandable.ExpandableItemViewHolder;
import com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.expandable.annotation.ExpandableItemStateFlags;

import androidx.recyclerview.widget.RecyclerView;

public abstract class AbstractExpandableItemViewHolder extends RecyclerView.ViewHolder implements ExpandableItemViewHolder {
    @ExpandableItemStateFlags
    private int mExpandStateFlags;

    public AbstractExpandableItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    @ExpandableItemStateFlags
    public int getExpandStateFlags() {
        return mExpandStateFlags;
    }

    @Override
    public void setExpandStateFlags(@ExpandableItemStateFlags int flags) {
        mExpandStateFlags = flags;
    }
}
