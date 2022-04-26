package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText userName, password;
    Button loginButton,forgotButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        forgotButton = findViewById(R.id.forgotButton);
        DB = new DBHelper(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _userName = userName.getText().toString();
                String _password = password.getText().toString();
                if (_userName.equals("") || _password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter all the field", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUserPassword = DB.checkUserPassword(_userName, _password);
                    if (checkUserPassword == true) {
                        Intent intent = new Intent(login.this,homeActivity.class);
                        intent.putExtra("userName",_userName);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Sign in successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid UserName and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,searchUser.class);
                startActivity(intent);

            }
        });
    }
}