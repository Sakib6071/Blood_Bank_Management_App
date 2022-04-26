package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class resetPassword extends AppCompatActivity {
    TextView setUserName;
    EditText password,repassword;
    Button resetButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        setUserName = findViewById(R.id.setUserName);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        resetButton=findViewById(R.id.resetButton);
        DB=new DBHelper(this);

        Intent intent = getIntent();
        setUserName.setText(intent.getStringExtra("userName"));

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String _userName=setUserName.getText().toString();
            String _password=password.getText().toString();
            String _repassword=repassword.getText().toString();
            if(_password.equals(_repassword)){
                Boolean checkUpdatePassword=DB.updatePassword(_userName,_password);
                if(checkUpdatePassword==true){
                    Intent intent = new Intent(resetPassword.this,login.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Password updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Pasword in not updated successfully", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Confirm password is not matched",Toast.LENGTH_SHORT).show();
            }


            }
        });
    }
}