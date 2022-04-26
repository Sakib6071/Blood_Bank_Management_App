package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class requestBlood extends AppCompatActivity {
    TextView setUserName, setName, setContact;
    EditText address, bloodGroup, quantity;
    Button requestButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);
        setUserName = findViewById(R.id.setUserName);
        setName = findViewById(R.id.setName);
        setContact = findViewById(R.id.setContact);
        address = findViewById(R.id.address);
        bloodGroup = findViewById(R.id.bloodGroup);
        quantity = findViewById(R.id.quantity);
        requestButton = findViewById(R.id.requestButton);


        DB = new DBHelper(this);

        Intent intent = getIntent();
        setUserName.setText(intent.getStringExtra("userName"));
        String _userName = setUserName.getText().toString();
        Cursor cursor = DB.showData(_userName);
        cursor.moveToNext();
        setName.setText(cursor.getString(2));
        setContact.setText(cursor.getString(6));

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _address = address.getText().toString();
                String _bloodGroup = bloodGroup.getText().toString();
                String _quantity = quantity.getText().toString();
                if (_address.equals("") || _bloodGroup.equals("") || _quantity.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fillup the all field", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkUpdateBloodRequest = DB.updateBloodRequest(_userName, _address, _bloodGroup, _quantity);
                    if (checkUpdateBloodRequest == true) {
                        Toast.makeText(getApplicationContext(), "Request Data Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(requestBlood.this, timeline.class);
                        startActivity(intent1);
                    } else {
                        Toast.makeText(getApplicationContext(), "Request Data is not Updated", Toast.LENGTH_SHORT).show();


                    }


                }
            }
        });


    }
}