package com.example.qbhcomics.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.qbhcomics.R;
import com.example.qbhcomics.model.Comic;
import com.example.qbhcomics.model.Comic_Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    List<Comic> ls= new ArrayList<>();
    Comic_Adapter cmAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        recyclerView=(RecyclerView)findViewById(R.id.rcv_comic);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue= Volley.newRequestQueue(this);
        //requestQueue= VolleySingleton.getInstance(this).getRequestQueue();
        loadComic();
    }

    private void loadComic() {
        String url ="https://api.jsonserve.com/Zj2R7E?fbclid=IwAR3MlKYq9EbIe19ELIdVw5tJ3R-Nd7f-SIjVL1LrpLuX31PxknGqRVkrd_M";
        JsonArrayRequest jsonArrayRequest =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);

                        String name = jsonObject.getString("name");
                        String author = jsonObject.getString("author");
                        String desc = jsonObject.getString("contents");
                        String img = jsonObject.getString("image");

                        Comic comic = new Comic(name, author, img, desc);
                        ls.add(comic);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    Comic_Adapter comic_adapter =new Comic_Adapter(Home.this,ls);
                    recyclerView.setAdapter(comic_adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonArrayRequest);


}
}