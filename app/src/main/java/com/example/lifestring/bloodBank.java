package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bloodBank extends AppCompatActivity {
 Button aPositive,aNegative,bPositive,bNegative,abPositive,abNegative,oPositive,oNegative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);
        aPositive=findViewById(R.id.aPositive);
        aNegative=findViewById(R.id.aNegative);
        bPositive=findViewById(R.id.bPositive);
        bNegative=findViewById(R.id.bNegative);
        abPositive=findViewById(R.id.abPositive);
        abNegative=findViewById(R.id.abNegative);
        oPositive=findViewById(R.id.oPositive);
        oNegative=findViewById(R.id.oNegative);
        Intent intent = getIntent();
        String _userName = intent.getStringExtra("userName");

        aPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","A+");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
        aNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","A-");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });

        bPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","B+");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
        bNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","B-");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
        abPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","AB+");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
        abNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","AB-");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
        oPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","O+");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
        oNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bloodBank.this,bloodBankReceive.class);
                intent.putExtra("bloodType","O-");
                intent.putExtra("userName",_userName);
                startActivity(intent);
            }
        });
    }
}