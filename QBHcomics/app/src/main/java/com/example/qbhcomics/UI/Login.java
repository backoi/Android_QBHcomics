package com.example.qbhcomics.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qbhcomics.R;
import com.example.qbhcomics.database.database_comic;
import com.example.qbhcomics.databinding.LoginBinding;

public class Login extends AppCompatActivity {
   LoginBinding binding;
   EditText email,pass;
   Button btnlogin;
    database_comic db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signupClient.setOnClickListener(view->{
            startActivity(new Intent(Login.this, Signup.class));
        });
        db =new database_comic(this);
        email=findViewById(R.id.edtEmail);
        pass=findViewById(R.id.edtPass);
        btnlogin=(Button)findViewById(R.id.btnlg);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String password=pass.getText().toString();
                Boolean checkExist =db.checkuserPass(user,password);
                if(checkExist==true){
                    Intent intent =new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Incorrect account or password, please try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}