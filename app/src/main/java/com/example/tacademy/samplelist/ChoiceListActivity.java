package com.example.tacademy.samplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceListActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_list);

        listView = (ListView)findViewById(R.id.listView2);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_multichoice);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setAdapter(mAdapter);

        Button btn = (Button)findViewById(R.id.btn_delete);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE){
                    int position = listView.getCheckedItemPosition();
                    String text = (String) listView.getItemAtPosition(position);
                    mAdapter.remove(text);
                }else if(listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE){
                    SparseBooleanArray array = listView.getCheckedItemPositions();
                    List<String> removeList = new ArrayList<String>();

                    for(int i=0;i<array.size();i++){
                        int position = array.keyAt(i);
                        if(array.get(position)){
                            String text = (String)listView.getItemAtPosition(position);
                            removeList.add(text);
                        }
                    }

                    for(String s: removeList){
                        mAdapter.remove(s);
                    }
                    listView.clearChoices();
                }
            }
        });

        initData();

        listView.setItemChecked(2, true);
    }

    public void initData(){
        mAdapter.addAll(getResources().getStringArray(R.array.items));
    }
}
