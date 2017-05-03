package com.example.flexiblebug.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.flexiblebug.myapplication.items.AbstractCustomItem;
import com.example.flexiblebug.myapplication.items.MyHeader;
import com.example.flexiblebug.myapplication.items.MySimpleItem;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;

import static eu.davidea.flexibleadapter.SelectableAdapter.MODE_SINGLE;

public class MainActivity extends AppCompatActivity implements FlexibleAdapter.OnItemClickListener {

    private RecyclerView mList;
    private FlexibleAdapter<AbstractCustomItem> mAdapter;
    private int mActivatedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = (RecyclerView) findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this));


        mAdapter = new FlexibleAdapter<>(getGeneratedItems(), this);
        mAdapter.setStickyHeaders(true);
        //  mAdapter
        mAdapter.setDisplayHeadersAtStartUp(true);
        mAdapter.showAllHeaders();
        mAdapter.expandItemsAtStartUp();
        mAdapter.setMode(MODE_SINGLE);
        mList.setAdapter(mAdapter);
    }

    @Override
    public boolean onItemClick(int position) {
        //All like in example
        if (position != mActivatedPosition) setActivatedPosition(position);
        return true;
    }

    private void setActivatedPosition(int position) {
        mActivatedPosition = position;
        mAdapter.toggleSelection(position);
    }

    public List<AbstractCustomItem> getGeneratedItems() {

        List<AbstractCustomItem> headers = new ArrayList<>();

        //Sometimes i have EMPTY headers, without any children
        headers.add(new MyHeader());
        headers.add(new MyHeader());

        for (int i = 0; i < 10; i++) {
            MyHeader header = new MyHeader();
            for (int child = 0; child < 10; child++) {
                MySimpleItem item = new MySimpleItem();
                item.setHeader(header);
                headers.add(item);
            }
        }


        return headers;
    }

}
