package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.DateData;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class DateView extends FrameLayout {
    public DateView(Context context) {
        super(context);
        init();
    }

    TextView messageView;

    private void init(){
        inflate(getContext(), R.layout.view_date, this);
        messageView = (TextView)findViewById(R.id.text_message);
    }

    DateData data;

    public void sendData(DateData data){
        this.data = data;
        messageView.setText(data.getMessage());
    }
}
