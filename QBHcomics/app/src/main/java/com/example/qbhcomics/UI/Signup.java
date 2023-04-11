package com.example.qbhcomics.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qbhcomics.R;

public class Signup extends AppCompatActivity {
    EditText username,pass,repass;

    TextView loginClient;
    Button signup;
//    database_comic db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);

        signup=(Button)findViewById(R.id.signup_btn);
        username=(EditText)findViewById(R.id.signup_username);
        pass=(EditText)findViewById(R.id.signup_pass);
        repass=(EditText)findViewById(R.id.signup_repass);



//        db=new database_comic(this);

        loginClient=(TextView)findViewById(R.id.login_client);
        loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String user = username.getText().toString();
//                String pw = pass.getText().toString();
//                String repw =repass.getText().toString();
//                if(user.equals("")||pw.equals("")||repw.equals("")){
//                    Toast.makeText(Signup.this,"Please complete all information",Toast.LENGTH_SHORT ).show();
//                }
//                else {
//                    if(pw.equals(repw)){
//                        Boolean checkuser =db.checkUser(user);
//                        if(!checkuser){
//                            Boolean insert= db.insertData(user,pw);
//                            if(insert){
//                                Toast.makeText(Signup.this, "Registered successfully !!!", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(),Login.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(intent);
//                            }
//                            else {
//                                Toast.makeText(Signup.this, "Registered failed !!!", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else{
//                            Toast.makeText(Signup.this, "User already Exists", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else {
//                        Toast.makeText(Signup.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
//                    }
                //}
            //}
        //});
    }

    @Override
    protected void onResume() {
        super.onResume();
        username.setText("");

        pass.setText("");

        repass.setText("");
    }
}