package com.example.lifestring;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class donorList extends AppCompatActivity {
ListView donorListView;
SearchView searchView;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);
        donorListView=findViewById(R.id.donorListView);
        searchView=findViewById(R.id.searchView);
        DB= new DBHelper(this);
        loadDonorData();

    }
    public void loadDonorData(){
        ArrayList<String> donorData = new ArrayList<>();
        Cursor cursor = DB.showDonorData();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(), "No Data Exist", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                donorData.add("Name : "+cursor.getString(2)+"\nContact : "+cursor.getString(6)+"\nAddress : "+cursor.getString(5)+"\nBlood Group: "+cursor.getString(8));
            }
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.donor_list,R.id.textViewID,donorData);
        donorListView.setAdapter(adapter);
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