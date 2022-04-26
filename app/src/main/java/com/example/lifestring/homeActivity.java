package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeActivity extends AppCompatActivity {
    Button seeDonor, requestButton,timelineButton,bloodBankButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        seeDonor = findViewById(R.id.seeDonor);
        requestButton = findViewById(R.id.requestButton);
        timelineButton=findViewById(R.id.timelineButton);
        bloodBankButton=findViewById(R.id.bloodBankButton);
        Intent intent = getIntent();
        String x = intent.getStringExtra("userName");

        seeDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity.this, donorList.class);
                startActivity(intent);
            }
        });
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(homeActivity.this, requestBlood.class);
                intent1.putExtra("userName", x);
                startActivity(intent1);
            }
        });
        timelineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(homeActivity.this,timeline.class);
                startActivity(intent2);
            }
        });
        bloodBankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(homeActivity.this,bloodBank.class);
                intent3.putExtra("userName", x);
                startActivity(intent3);
            }
        });

    }
}