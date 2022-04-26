package com.example.lifestring;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create Table userDetails(userName TEXT primary key, password TEXT,name TEXT, age TEXT,gender TEXT,address TEXT,contactNumber TEXT,emailAddress TEXT,bloodGroup TEXT,donor TEXT,reqAddress TEXT,reqBlood TEXT,quantity TEXT,bloodTypeForStorage TEXT,addressForStorage TEXT,reasonForStorage TEXT,quantityForStorage TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop Table if exists userDetails");
    }

    public Boolean insertData(String userName, String password, String name, String age, String gender, String address, String contactNumber, String emailAddress, String bloodGroup, String donor, String reqAddress, String reqBlood, String quantity, String bloodTypeForStorage, String addressForStorage, String reasonForStorage, String quantityForStorage) {
        SQLiteDatabase Mydb = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", userName);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("address", address);
        contentValues.put("contactNumber", contactNumber);
        contentValues.put("emailAddress", emailAddress);
        contentValues.put("bloodGroup", bloodGroup);
        contentValues.put("donor", donor);
        contentValues.put("reqAddress", reqAddress);
        contentValues.put("reqBlood", reqBlood);
        contentValues.put("quantity", quantity);
        contentValues.put("bloodTypeForStorage", bloodTypeForStorage);
        contentValues.put("addressForStorage", addressForStorage);
        contentValues.put("reasonForStorage", reasonForStorage);
        contentValues.put("quantityForStorage", quantityForStorage);


        long result = Mydb.insert("userDetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }


    public Boolean checkUserName(String userName) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails where userName=?", new String[]{userName});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUserPassword(String userName, String password) {
        SQLiteDatabase Mydb = getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails where userName = ? and password=?", new String[]{userName, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Boolean updatePassword(String userName, String password) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = Mydb.update("userDetails", contentValues, "userName=?", new String[]{userName});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updateBloodRequest(String userName, String reqAddress, String reqBlood, String quantity) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("reqAddress", reqAddress);
        contentValues.put("reqBlood", reqBlood);
        contentValues.put("quantity", quantity);
        long result = Mydb.update("userDetails", contentValues, "userName=?", new String[]{userName});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateBloodRequestStorage(String userName,String bloodTypeForStorage, String addressForStorage, String reasonForStorage, String quantityForStorage) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bloodTypeForStorage", bloodTypeForStorage);
        contentValues.put("addressForStorage", addressForStorage);
        contentValues.put("reasonForStorage", reasonForStorage);
        contentValues.put("quantityForStorage", quantityForStorage);
        long result = Mydb.update("userDetails", contentValues, "userName=?", new String[]{userName});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor showDonorData() {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails where donor=?", new String[]{"yes"});
        return cursor;
    }

    public Cursor showData(String userName) {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails where userName=?", new String[]{userName});
        return cursor;
    }

    public Cursor showDataWithoutUserName() {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from userDetails", null);
        return cursor;
    }

}

