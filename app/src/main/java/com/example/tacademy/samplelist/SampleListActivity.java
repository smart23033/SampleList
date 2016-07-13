package com.example.tacademy.samplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SampleListActivity extends AppCompatActivity {

    EditText keywordView;
    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list);

        keywordView = (EditText)findViewById(R.id.edit_keyword);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = (String)listView.getItemAtPosition(position);
                Toast.makeText(SampleListActivity.this,"item : " + text,Toast.LENGTH_LONG).show();
            }
        });


        Button btn = (Button)findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = keywordView.getText().toString();
                if(!TextUtils.isEmpty(text)){
                    mAdapter.add(text);
                    keywordView.setText("");
                    listView.smoothScrollToPosition(mAdapter.getCount() -1);
                }
            }
        });

        initData();
    }

    public void initData(){
        String[] items = getResources().getStringArray(R.array.items);
        mAdapter.addAll(items);
    }
}
