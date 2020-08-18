

package com.intellibitz.muthuselvam.androidapplication.widget.advrecyclerview.animator.impl;

import androidx.recyclerview.widget.RecyclerView;

public abstract class ItemAnimationInfo {
    public abstract RecyclerView.ViewHolder getAvailableViewHolder();

    public abstract void clear(RecyclerView.ViewHolder holder);
}

