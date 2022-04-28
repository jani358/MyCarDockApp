package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView username;
    TextView password;
    MaterialButton loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =  findViewById(R.id.username);
        password =  findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userN = username.getText().toString();
                String passW = password.getText().toString();
                validationInfo(userN,passW);

            }
        });

    }
    private Boolean validationInfo(String userN, String passW){
        if(userN.length() == 0){
            username.requestFocus();
            username.setError("Empty data provided");
            return false;
        }else if(passW.length() == 0) {
            password.requestFocus();
            password.setError("Empty data provided");
            return false;
        }else if(userN.equals("admin") && passW.equals("1234"))
        {
            Toast.makeText(MainActivity.this,"Successfully login",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,CarDetails.class);
            startActivity(intent);

        }else{
            Toast.makeText(MainActivity.this,"Invalid Username/Password",Toast.LENGTH_SHORT).show();
        }
        return  true;
    }

}