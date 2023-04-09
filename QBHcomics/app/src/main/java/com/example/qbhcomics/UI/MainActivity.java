package com.example.qbhcomics.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qbhcomics.R;
import com.example.qbhcomics.databinding.LoginBinding;

public class MainActivity extends AppCompatActivity {
    EditText email,pass;

    TextView signupClient;

    Button btnLogin;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        btnLogin=(Button) findViewById(R.id.btnlg);
//        email=(EditText)findViewById(R.id.edtEmail);
//        pass=(EditText)findViewById(R.id.edtPass);

        signupClient=(TextView)findViewById(R.id.signup_client);
        signupClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Home.class);
                startActivity(intent);
            }
        });

    }
}