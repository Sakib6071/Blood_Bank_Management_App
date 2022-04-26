package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class timeline extends AppCompatActivity {
ListView receiverListView;
SearchView searchView;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        receiverListView=findViewById(R.id.receiverListView);
        searchView=findViewById(R.id.searchView);
        DB=new DBHelper(this);
        ArrayList<String> receiverData = new ArrayList<>();
        Cursor cursor = DB.showDataWithoutUserName();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(), "No Data Exist", Toast.LENGTH_SHORT).show();
        }
        else{
            String checkNull;
            while (cursor.moveToNext()){
                checkNull=cursor.getString(10);
                if(checkNull!=null){
                    receiverData.add("Name : "+cursor.getString(2)+"\nAddress : "+cursor.getString(10)+"\nBlood Group: "+cursor.getString(11)+"\nQuantity:"+cursor.getString(12)+"\nContact : "+cursor.getString(6));
                }
            }
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.donor_list,R.id.textViewID,receiverData);
        receiverListView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


    }


}