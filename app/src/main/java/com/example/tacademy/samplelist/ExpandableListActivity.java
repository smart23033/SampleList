package com.example.tacademy.samplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class ExpandableListActivity extends AppCompatActivity {
    ExpandableListView listView;
    MyGroupAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        listView = (ExpandableListView)findViewById(R.id.expandableListView);
        mAdapter = new MyGroupAdapter();
        listView.setAdapter(mAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListActivity.this,"child clicked",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(ExpandableListActivity.this,"group expanded",Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(ExpandableListActivity.this,"group collapsed",Toast.LENGTH_SHORT).show();
            }
        });

        initData();

        for(int i=0;i<mAdapter.getGroupCount();i++){
            listView.expandGroup(i);
        }
    }

    private void initData(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 ; j++) {
                mAdapter.put("group" + i , "child:"+i+","+j);
            }
        }
    }
}
