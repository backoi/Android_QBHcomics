package com.example.qbhcomics.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.qbhcomics.R;
import com.example.qbhcomics.model.Comic;
import com.example.qbhcomics.model.Comic_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    GridView gv;
    List<Comic> ls= new ArrayList<>();
    Comic_Adapter cmAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        gv= (GridView)findViewById(R.id.gv_comic);
        enterData();
        cmAdapter=new Comic_Adapter(ls,R.layout.item_comics,Home.this);
        gv.setAdapter(cmAdapter);
    }
    public void enterData(){
        ls.add(new Comic(R.drawable.img,"Chap 1","Naruto"));
        ls.add(new Comic(R.drawable.img_1,"Chap 12","sieu nhan"));
        ls.add(new Comic(R.drawable.img_2,"Chap 17","Sasuke"));

    }
}