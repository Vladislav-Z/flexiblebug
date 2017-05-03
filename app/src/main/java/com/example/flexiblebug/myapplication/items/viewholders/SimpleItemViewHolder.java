package com.example.flexiblebug.myapplication.items.viewholders;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flexiblebug.myapplication.R;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

public class SimpleItemViewHolder extends FlexibleViewHolder {

    private TextView mTextView;

    public SimpleItemViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter);
        mTextView = (TextView) view.findViewById(R.id.title);
    }

    public void bind(int position) {
        mTextView.setText("child -> " + position);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        Toast.makeText(itemView.getContext(), mTextView.getText(), Toast.LENGTH_SHORT).show();
    }
}
