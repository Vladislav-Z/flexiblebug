package com.example.flexiblebug.myapplication.items;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.flexiblebug.myapplication.R;
import com.example.flexiblebug.myapplication.items.viewholders.HeaderViewHolder;

import java.util.List;
import java.util.UUID;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IHeader;

public class MyHeader extends AbstractCustomItem<HeaderViewHolder> implements IHeader<HeaderViewHolder> {

    public MyHeader() {
        super(UUID.randomUUID());
        setSelectable(true);
        setDraggable(false);
    }


    @Override
    public int getLayoutRes() {
        return R.layout.adapter_sticky_header;
    }

    @Override
    public HeaderViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new HeaderViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {
        holder.bind(position);
    }
}
