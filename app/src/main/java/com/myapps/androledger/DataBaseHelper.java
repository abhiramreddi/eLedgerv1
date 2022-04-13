package com.myapps.androledger;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.myapps.androledger.fragments.Visualize;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String PAYMENTS_HISTORY = "PAYMENTS_HISTORY";
    public static final String COLUMN_AMOUNT = "AMOUNT";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TYPE = "TYPE";


    public static int[] values;



    public DataBaseHelper(@Nullable Context context) {
        super(context, "Payments.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + PAYMENTS_HISTORY + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_AMOUNT + " INT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_CATEGORY + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }




    public boolean addOne(TransactionModel transactionModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_AMOUNT, transactionModel.getAmount());
        cv.put(COLUMN_DESCRIPTION, transactionModel.getDescription());
        cv.put(COLUMN_CATEGORY, transactionModel.getCategory());

        long insert = db.insert(PAYMENTS_HISTORY, null, cv);
        return insert != -1;
    }

    public void inko_result_ra(int[] array_ra_pumka) {
                Visualize visualize = new Visualize();
                visualize.vals = array_ra_pumka;

    }

    public List<TransactionModel> getAll() {
        List<TransactionModel> returnList = new ArrayList<>();
        // String queryString = "SELECT * FROM " + PAYMENTS_HISTORY;
        String que = "SELECT * FROM " + PAYMENTS_HISTORY + " ORDER BY " + COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(que, null);

        int food_Total = 0;
        int groceries_Total = 0;
        int travel_Total = 0;
        int phone_Total = 0;
        int shopping_Total = 0;
        int education_Total = 0;
        int electricity_Total = 0;
        int bills_Total = 0;
        int housing_Total = 0;
        int fuel_Total = 0;
        int others_Total = 0;
        int health_Total = 0;


        if (cursor.moveToFirst()) {
            do {
                int transactionID = cursor.getInt(0);
                int transactionAmount = cursor.getInt(1);
                String transactionDescription = cursor.getString(2);
                String transactionCategory = cursor.getString(3);

                switch (transactionCategory) {
                    case "Food":
                        food_Total += transactionAmount;
                        break;
                    case "Shopping":
                        shopping_Total += transactionAmount;
                        break;
                    case "Phone":
                        phone_Total += transactionAmount;
                        break;
                    case "Health":
                        health_Total += transactionAmount;
                        break;
                    case "Groceries":
                        groceries_Total += transactionAmount;
                        break;
                    case "Travel":
                        travel_Total += transactionAmount;
                        break;
                    case "Fuel":
                        fuel_Total += transactionAmount;
                        break;
                    case "Education":
                        education_Total += transactionAmount;
                        break;
                    case "Electricity":
                        electricity_Total += transactionAmount;
                        break;
                    case "Bills":
                        bills_Total += transactionAmount;
                        break;
                    case "Housing":
                        housing_Total += transactionAmount;
                        break;
                    case "Other":
                        others_Total += transactionAmount;
                        break;
                }

                TransactionModel transactionModel = new TransactionModel(transactionID, transactionAmount, transactionDescription, transactionCategory  );
                returnList.add(transactionModel);


            } while (cursor.moveToNext());

            values = new int[]{food_Total, shopping_Total, phone_Total, health_Total, groceries_Total, travel_Total, fuel_Total, education_Total, electricity_Total, bills_Total, housing_Total, others_Total};
            inko_result_ra(values);

        }

        cursor.close();
        db.close();
        return returnList;

    }





}

