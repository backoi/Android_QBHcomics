package com.example.qbhcomics.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qbhcomics.R;

import java.util.List;

public class Comic_Adapter extends BaseAdapter {
    List<Comic> arrComics;
    public Context context;
    int layout;

    public Comic_Adapter(List<Comic> arrComics,int Layout, Context context) {
        this.arrComics = arrComics;
        this.context = context;
        Layout=layout;
    }

    public LayoutInflater inflater;

    @Override
    public int getCount() {
        return arrComics.size();
    }

    @Override
    public Object getItem(int i) {
        return arrComics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgv;
        TextView name;
        TextView chap;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view= inflater.inflate(R.layout.item_comics,null);
        imgv=view.findViewById(R.id.comic_img);
        name=view.findViewById(R.id.comic_name);
        chap=view.findViewById(R.id.comic_chap);

        Comic cm =arrComics.get(i);
        imgv.setImageResource(cm.getCm_img());
        name.setText(cm.getCm_name());
        chap.setText(cm.getCm_chap());


        return view;
    }
}
