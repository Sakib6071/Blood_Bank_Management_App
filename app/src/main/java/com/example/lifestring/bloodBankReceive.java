package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bloodBankReceive extends AppCompatActivity {
    TextView setBloodType,setName,setContact;
    EditText address,reason,quantity;
    Button requestButton;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_receive);
        setBloodType=findViewById(R.id.setBloodType);
        setName=findViewById(R.id.setName);
        setContact=findViewById(R.id.setContact);
        address=findViewById(R.id.address);
        reason=findViewById(R.id.reason);
        quantity=findViewById(R.id.quantity);
        requestButton=findViewById(R.id.requestButton);
        DB=new DBHelper(this);


        Intent intent5 = getIntent();
        setBloodType.setText(intent5.getStringExtra("bloodType"));
        String _userName = intent5.getStringExtra("userName");


        Cursor cursor = DB.showData(_userName);
        cursor.moveToNext();
        setName.setText(cursor.getString(2));
        setContact.setText(cursor.getString(6));

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _bloodType = setBloodType.getText().toString();
                String _address=address.getText().toString();
                String _reason = reason.getText().toString();
                String _quantity= quantity.getText().toString();



                if (_address.equals("") || _quantity.equals("") || _reason.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fillup the all field", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkUpdateBloodRequest = DB.updateBloodRequestStorage(_userName,_bloodType, _address,_reason , _quantity);
                    if (checkUpdateBloodRequest == true) {
                        Toast.makeText(getApplicationContext(), "Request Successful", Toast.LENGTH_SHORT).show();
                        address.setText("");
                        reason.setText("");
                        quantity.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Request Data is not Successful", Toast.LENGTH_SHORT).show();


                    }
            }
            }
        });

}
}