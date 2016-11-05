package com.truongtechno.bible.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.truongtechno.bible.base.manager.BaseManager;
import com.truongtechno.bible.config.Constant;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Book {

	private int bookId = 0;
	private String bookName = Constant.TEXT_EMPTY;
	private String bookType = Constant.TEXT_EMPTY;
	private int bookSTT = 0;
	private int bookChapterCount = 0;
	private int bookVerseCount = 0;

	
	public static final String TABLE_BOOK = "Book";
	
	//column table book
	public static final String BOOKID = "bookId";
	public static final String BOOKNAME = "bookName";
	public static final String BOOKTYPE = "bookType";
	public static final String BOOKSTT = "bookStt";
	public static final String BOOKCHAPTERCOUNT = "bookChapterCount";
	public static final String BOOKVERSECOUNT = "bookVerseCount";
	
	public static final String COMMAND_CREATETABLE = "CREATE TABLE " +TABLE_BOOK+
	"(" + BOOKID + " INTEGER PRIMARY KEY,"
		+ BOOKSTT + " INTEGER,"
		+ BOOKNAME + " TEXT," 
		+ BOOKTYPE	+ " TEXT," 
		+ BOOKCHAPTERCOUNT + "INTEGER,"
		+ BOOKVERSECOUNT + "INTEGER" +
	")";
	
	
	public Book() {
	}

	public Book(int stt,String bookName,String bookType,int chapterCount, int verseCount) {
		this.bookSTT = stt;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookChapterCount = chapterCount;
		this.bookVerseCount = verseCount;
	}
	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public int getBookSTT() {
		return bookSTT;
	}

	public void setBookSTT(int bookSTT) {
		this.bookSTT = bookSTT;
	}
	
	
	public int getBookChapterCount() {
		return bookChapterCount;
	}

	public void setBookChapterCount(int bookChapterCount) {
		this.bookChapterCount = bookChapterCount;
	}

	public int getBookVerseCount() {
		return bookVerseCount;
	}

	public void setBookVerseCount(int bookVerseCount) {
		this.bookVerseCount = bookVerseCount;
	}

	public static void addItemBook(Book book) {
		try {
			SQLiteDatabase database = BaseManager.getIntance()
					.getDatabaseHandler().getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(BOOKNAME, book.getBookName());
			values.put(BOOKSTT, book.getBookSTT());
			values.put(BOOKTYPE, book.getBookType());

			database.insert(TABLE_BOOK, null, values);
			database.close();
			Log.e("ENtitySOng-====================>", "Add success");
		} catch (Exception e) {
			Log.e("ENtitySOng- addItemWishList", e.getMessage());
		}
	}
	public static List<Book> getListBookByType(String type) {
		ArrayList<Book> mBooks = new ArrayList<Book>();
		String query = "SELECT * FROM " + TABLE_BOOK + " WHERE " + BOOKTYPE + "= '" + type + "'";
		SQLiteDatabase database = BaseManager.getIntance().getDatabaseHandler()
				.getWritableDatabase();
		Cursor cursor = database.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				Book book = new Book();
				book.setBookSTT(cursor.getInt(1));
				book.setBookName(cursor.getString(2));
				book.setBookType(cursor.getString(3));
				book.setBookChapterCount(cursor.getInt(4));
				book.setBookVerseCount(cursor.getInt(5));
				mBooks.add(book);
			} while (cursor.moveToNext());
		}
		return mBooks;
	}

}
