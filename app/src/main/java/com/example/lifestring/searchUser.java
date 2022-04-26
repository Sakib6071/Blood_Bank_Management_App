package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class searchUser extends AppCompatActivity {
    EditText userName;
    Button findUserNameButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        userName=findViewById(R.id.userName);
        findUserNameButton=findViewById(R.id.findUserNameButton);
        DB= new DBHelper(this);


        findUserNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _userName=userName.getText().toString();
                Boolean checkUserName = DB.checkUserName(_userName);
                if(checkUserName==true){
                    Intent intent = new Intent(searchUser.this,resetPassword.class);
                    intent.putExtra("userName",_userName);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(), "No user exist", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}