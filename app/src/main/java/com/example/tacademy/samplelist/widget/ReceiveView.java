package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.ReceiveData;
import com.example.tacademy.samplelist.data.SendData;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class ReceiveView extends FrameLayout {
    public ReceiveView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView photoView;

    public void init(){
        inflate(getContext(), R.layout.view_receive,this);
        messageView = (TextView)findViewById(R.id.text_message);
        photoView = (ImageView)findViewById(R.id.image_photo);
    }

    ReceiveData data;
    public void setData(ReceiveData data){
        this.data = data;
        messageView.setText(data.getMessage());
        photoView.setImageDrawable(data.getPhoto());
    }
}
