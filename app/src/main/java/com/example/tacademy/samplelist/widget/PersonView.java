package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends FrameLayout{

    public PersonView(Context context) {
        this(context,null);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    ImageView photoView;
    TextView nameView, ageView;

    public interface OnImageClickListener{
        public void onImageClick(PersonView personView,Person person);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener){
        mListener = listener;
    }

    private void init(){
//        생성자로부터 super를 통해 Context를 얻어올 수 있음 : getContext()
        LayoutInflater inflater = LayoutInflater.from(getContext());
//        view_person이라는 캔버스에 나(this)를 그려
        inflater.inflate(R.layout.view_person, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);

        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onImageClick(PersonView.this,person);
                }
            }
        });
    }

    Person person;

    public void setPerson(Person person) {
        this.person = person;
        photoView.setImageDrawable(person.getPhoto());
        nameView.setText(person.getName());
        ageView.setText("" + person.getAge());
    }

    public Person getPerson() {
        return person;
    }

}
