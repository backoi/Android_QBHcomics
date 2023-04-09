package com.example.qbhcomics.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.qbhcomics.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class Details extends AppCompatActivity {
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_details);

        ImageView imageView=findViewById(R.id.poster_image);
        TextView name=findViewById(R.id.name_detail);
        TextView author=findViewById(R.id.author_detail);
        TextView decs=findViewById(R.id.desc_detail);

        Bundle bundle =getIntent().getExtras();

        String nameDetail =bundle.getString("name");
        String authorDetail =bundle.getString("author");
        String descDetail =bundle.getString("desc");
        String imgDetail =bundle.getString("img");

        Glide.with(this).load(imgDetail).into(imageView);
        name.setText(nameDetail);
        author.setText(authorDetail);
        decs.setText(descDetail);

        //loadContent();

    }

//    private void loadContent() {
//        String url ="https://api.jsonserve.com/5qmhQN?fbclid=IwAR2X8uMKWu7wDz71SC4vGD9yqd01jRpgVU44hhB7vc0qGeWxyBWccGoIAFs";
//        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                JSONArray jsonArray =response.getJSONArray("chapter")
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        })
//
//    }
}