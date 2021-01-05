package com.yashuthar.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.yashuthar.foodorderingapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelpers extends SQLiteOpenHelper {
    final static String DBName = "foods.db";
    final static int DBversion = 2;
    public DBHelpers(@Nullable Context context) {
        super(context, DBName, null, DBversion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders" +
                "(id integer primary key autoincrement," +
                "name text," +
                "phone text," +
                "price int," +
                "image int," +
                "quantity int," +
                "description text," +
                "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table if exists orders");
            onCreate(db);
    }
    public boolean insertOrders(String name, String phone, int price, int image, String description, String foodname, int quantity){
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image", image);
        values.put("description", description);
        values.put("foodname",foodname);
        values.put("quantity",quantity);
        long id = database.insert("orders",null,values);
        if(id <= 0){
           return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<OrderModel> gettOrders(){
        ArrayList<OrderModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders", null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderModel model = new OrderModel();
                model.setOrderId(cursor.getInt(0)+"");
                model.setOrderName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setOrderPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id ="+ id,null);
        if(cursor != null)
            cursor.moveToFirst();
        return cursor;
    }
    public boolean updateOrders(String name, String phone, int price, int image, String description, String foodname, int quantity, int id){
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image", image);
        values.put("description", description);
        values.put("foodname",foodname);
        values.put("quantity",quantity);
        long row = database.update("orders", values,"id="+id,null);
        if(row <= 0){
            return false;
        }
        else{
            return true;
        }
    }
    public int deletedOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }
}
