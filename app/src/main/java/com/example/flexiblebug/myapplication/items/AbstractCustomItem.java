package com.example.flexiblebug.myapplication.items;

/**
 * Created by vladyslav.zhabin on 5/3/2017.
 */

import java.util.UUID;

import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.viewholders.FlexibleViewHolder;


public abstract class AbstractCustomItem<VH extends FlexibleViewHolder>
        extends AbstractFlexibleItem<VH> {

    public UUID id;


    public AbstractCustomItem(UUID objectUid) {
        this.id = objectUid;
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof AbstractCustomItem) {
            AbstractCustomItem inItem = (AbstractCustomItem) inObject;
            return this.id.equals(inItem.id);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Uid=" + id;
    }
}