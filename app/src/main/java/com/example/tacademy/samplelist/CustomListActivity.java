package com.example.tacademy.samplelist;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tacademy.samplelist.data.Person;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        listView = (ListView)findViewById(R.id.listView3);
        mAdapter = new PersonAdapter();
        listView.setAdapter(mAdapter);

        initData();
    }

    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3,R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7};

    private void initData(){
        Random r = new Random();

        for(int i=0;i<20;i++){
            Person p = new Person();
            p.setName("name " + i);
            p.setAge(20+r.nextInt(20));
            p.setPhoto(ContextCompat.getDrawable(this,resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}
