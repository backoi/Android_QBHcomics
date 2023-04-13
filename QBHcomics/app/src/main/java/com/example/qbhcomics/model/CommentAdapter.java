package com.example.qbhcomics.model;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qbhcomics.R;

import java.util.ArrayList;

public class CommentAdapter extends AppCompatActivity {
    private ListView commentListView;
    private EditText nameEditText, contentEditText;
    private Button commentButton;
    private ArrayList<Comment> commentList;
    private ArrayAdapter<Comment> commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        commentListView = findViewById(R.id.comment_listview);
        nameEditText = findViewById(R.id.comment_name);
        contentEditText = findViewById(R.id.comment_content);
        commentButton = findViewById(R.id.comment_button);

        commentList = new ArrayList<>();
        commentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, commentList);
        commentListView.setAdapter(commentAdapter);

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String content = contentEditText.getText().toString();

                if (!name.isEmpty() && !content.isEmpty()) {
                    Comment comment = new Comment(name, content);
                    commentList.add(comment);
                    commentAdapter.notifyDataSetChanged();
                    nameEditText.setText("");
                    contentEditText.setText("");
                } else {
                    Toast.makeText(CommentAdapter.this, "Please enter name and content", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
