package com.example.tacademy.samplelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonAdapter extends BaseAdapter {
    List<Person> items = new ArrayList<>();

    public void add(Person p){
        items.add(p);
        notifyDataSetChanged();
    }
    public void addAll(List<Person> items){
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonView personView;
        personView = new PersonView(parent.getContext());
        personView.setPerson(items.get(position));

        return personView;
    }
}
