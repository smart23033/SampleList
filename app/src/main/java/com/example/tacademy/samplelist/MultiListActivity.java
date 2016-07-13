package com.example.tacademy.samplelist;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.tacademy.samplelist.data.DateData;
import com.example.tacademy.samplelist.data.ReceiveData;
import com.example.tacademy.samplelist.data.SendData;

public class MultiListActivity extends AppCompatActivity {

    ListView listView;
    EditText messageView;
    RadioGroup messageType;
    ChattingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_list);

        listView = (ListView)findViewById(R.id.listView4);
        messageView = (EditText)findViewById(R.id.edit_message);
        messageType = (RadioGroup)findViewById(R.id.group_view_type);
        mAdapter = new ChattingAdapter();
        listView.setAdapter(mAdapter);

        Button btn = (Button)findViewById(R.id.btn_insert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageView.getText().toString();
                if(!TextUtils.isEmpty(message)){
                    switch (messageType.getCheckedRadioButtonId()){
                        case R.id.radio_send:
                            SendData sd = new SendData();
                            sd.setMessage(message);
                            sd.setPhoto(ContextCompat.getDrawable(MultiListActivity.this,R.drawable.sample_0));
                            mAdapter.add(sd);
                            messageView.setText("");
                            break;
                        case R.id.radio_receive:
                            ReceiveData rd = new ReceiveData();
                            rd.setMessage(message);
                            rd.setPhoto(ContextCompat.getDrawable(MultiListActivity.this,R.drawable.sample_1));
                            mAdapter.add(rd);
                            messageView.setText("");
                            break;
                        case R.id.radio_date:
                            DateData dd = new DateData();
                            dd.setMessage(message);
                            mAdapter.add(dd);
                            messageView.setText("");
                            break;
                    }
                }
            }
        });
    }
}
