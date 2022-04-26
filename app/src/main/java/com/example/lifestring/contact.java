package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class contact extends AppCompatActivity {
Button sendButton;
EditText name,email,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        sendButton=findViewById(R.id.sendButton);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        message=findViewById(R.id.message);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name=name.getText().toString();
                String _email=email.getText().toString();
                String _message=message.getText().toString();
                
                if(_name.equals("")||_message.equals("") || _email.equals("") ){
                    Toast.makeText(getApplicationContext(), "Enter all the field", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Message send successful", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    email.setText("");
                    message.setText("");
                }
            }
        });
    }
}