package com.example.flexiblebug.myapplication.items.viewholders;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.flexiblebug.myapplication.R;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

public class HeaderViewHolder extends FlexibleViewHolder {
    private TextView mTextView;

    public HeaderViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter, true);
        mTextView = (TextView) view.findViewById(R.id.title);
    }

    public void bind(int position) {
        mTextView.setText("HEADER -> " + position);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        Toast.makeText(itemView.getContext(), mTextView.getText(), Toast.LENGTH_SHORT).show();
    }
}
