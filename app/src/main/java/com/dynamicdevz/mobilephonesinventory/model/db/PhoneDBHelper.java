package com.dynamicdevz.mobilephonesinventory.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dynamicdevz.mobilephonesinventory.model.data.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "phone.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Phone";
    public static final String COLUMN_PHONE_ID = "phone_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MANUFACTURER = "manufacturer";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_PRICE = "price";



    public PhoneDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCommand = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_PHONE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_MANUFACTURER + " TEXT, " +
                COLUMN_MODEL + " TEXT, " +
                COLUMN_PRICE + " REAL)";

        db.execSQL(createCommand);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(upgrade);
        onCreate(db);
    }

    public void insertPhone(Phone phone) {
        //logDebug("Inserting new phone: "+phone.getName());
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, phone.getName());
        contentValues.put(COLUMN_MANUFACTURER, phone.getManufacturer());
        contentValues.put(COLUMN_MODEL, phone.getModel());
        contentValues.put(COLUMN_PRICE, phone.getPrice());


        SQLiteDatabase sQdb = getWritableDatabase();
        sQdb.insert(TABLE_NAME, null, contentValues);
    }
    public List<Phone> getAllPhones() {
        //logDebug("Reading from database.");

        List<Phone> phones = new ArrayList<>();
        String getQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = getReadableDatabase().rawQuery(getQuery, null);
        cursor.move(-1);

        //Comic(int comicId, int publishYear, Publisher publisher, double rating, String title, int issue)
        while (cursor.moveToNext()) {
            Phone phone = new Phone(
                    cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_MANUFACTURER)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_MODEL)),
                    cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE))
            );
            phones.add(phone);
        }
        return phones;
    }


    public void deleteComic(Phone phone){
        String deleteQuery = "DELETE * FROM "+TABLE_NAME+ " WHERE "+COLUMN_PHONE_ID + " = "+phone.getPhoneId();
        getWritableDatabase().rawQuery(deleteQuery, null, null);
    }
    }


