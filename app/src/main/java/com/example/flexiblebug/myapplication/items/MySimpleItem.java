package com.example.flexiblebug.myapplication.items;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.flexiblebug.myapplication.R;
import com.example.flexiblebug.myapplication.items.viewholders.SimpleItemViewHolder;

import java.util.List;
import java.util.UUID;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IHeader;
import eu.davidea.flexibleadapter.items.ISectionable;

public class MySimpleItem extends AbstractCustomItem<SimpleItemViewHolder> implements ISectionable<SimpleItemViewHolder, IHeader> {

    private IHeader mHeader;


    public MySimpleItem() {
        super(UUID.randomUUID());
        setSelectable(true);
        setDraggable(false);
    }


    @Override
    public int getLayoutRes() {
        return R.layout.sticky_item_layout;
    }

    @Override
    public SimpleItemViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new SimpleItemViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }


    @Override
    public void bindViewHolder(FlexibleAdapter adapter, SimpleItemViewHolder holder, int position, List payloads) {
        holder.bind(position);
    }


    @Override
    public IHeader getHeader() {
        return mHeader;
    }

    @Override
    public void setHeader(IHeader header) {
        mHeader = header;
    }
}
