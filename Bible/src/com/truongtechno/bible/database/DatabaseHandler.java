package com.truongtechno.bible.database;

import com.truongtechno.bible.entity.Book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// Database Name
	private static final String DATABASE_NAME = "bible";
	// Database Version
	private static final int DATABASE_VERSION = 1;

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			db.execSQL(Book.COMMAND_CREATETABLE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + Book.TABLE_BOOK);
		// Create tables again
		onCreate(db);
	}

}
