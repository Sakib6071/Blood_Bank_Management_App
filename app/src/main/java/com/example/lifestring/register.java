package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText name, age, gender, address, contactNumber, email, bloodGroup, userName, password, repassword;
    CheckBox checkbox,checkbox1;
    Button registerButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton = findViewById(R.id.registerButton);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        address = findViewById(R.id.address);
        contactNumber = findViewById(R.id.contactNumber);
        email = findViewById(R.id.email);
        bloodGroup = findViewById(R.id.bloodGroup);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        checkbox = findViewById(R.id.checkbox);
        checkbox1 = findViewById(R.id.checkbox1);
        DB = new DBHelper(this);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _userName = userName.getText().toString();
                String _password = password.getText().toString();
                String _repassword = repassword.getText().toString();
                String _name = name.getText().toString();
                String _age = age.getText().toString();
                String _gender = gender.getText().toString();
                String _address = address.getText().toString();
                String _contactNumber = contactNumber.getText().toString();
                String _email = email.getText().toString();
                String _bloodGroup = bloodGroup.getText().toString();
                Boolean _checkbox = checkbox.isChecked();
                Boolean _checkbox1 = checkbox1.isChecked();
                String donor;
                if(_checkbox1==true){
                     donor="yes";
                }
                else{
                    donor="no";
                }



                if (_userName.equals("") || _password.equals("") || _repassword.equals("") || _name.equals("") || _age.equals("") || _gender.equals("") || _address.equals("") || _contactNumber.equals("") || _email.equals("") || _bloodGroup.equals("") || _checkbox.equals(false)) {
                    Toast.makeText(getApplicationContext(), "Please Enter the all field", Toast.LENGTH_SHORT).show();
                } else {
                    if (_password.equals(_repassword)) {
                        Boolean checkUser = DB.checkUserName(_userName);
                        if (checkUser == false) {


                            Boolean insert = DB.insertData(_userName, _password, _name, _age, _gender, _address, _contactNumber, _email, _bloodGroup, donor,null,null,null,null,null,null,null);
                            if (insert == true) {

                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(register.this, login.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "User Name Exist", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Confirm Password Not matched!", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
    }
}