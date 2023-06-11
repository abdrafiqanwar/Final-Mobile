package com.example.h071211029_finalmobile.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Database.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_TASK =
            String.format(
                    "CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " %s TEXT,"
                    + " %s TEXT,"
                    + " %s TEXT,"
                    + " %s TEXT,"
                    + " %s TEXT,"
                    + " %s TEXT,"
                    + " %s TEXT,"
                    + " %s TEXT)",
                    DatabaseContract.TABLE_NAME,
                    DatabaseContract.TaskColumns._ID,
                    DatabaseContract.TaskColumns.TITLE,
                    DatabaseContract.TaskColumns.NAME,
                    DatabaseContract.TaskColumns.VOTE_AVERAGE,
                    DatabaseContract.TaskColumns.OVERVIEW,
                    DatabaseContract.TaskColumns.RELEASE_DATE,
                    DatabaseContract.TaskColumns.FIRST_AIR_DATE,
                    DatabaseContract.TaskColumns.POSTER_PATH,
                    DatabaseContract.TaskColumns.BACKDROP_PATH
            );

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addMovies(String title, String vote, String overview, String date,
                          String poster, String backdrop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.TaskColumns.TITLE, title);
        cv.put(DatabaseContract.TaskColumns.VOTE_AVERAGE, vote);
        cv.put(DatabaseContract.TaskColumns.OVERVIEW, overview);
        cv.put(DatabaseContract.TaskColumns.RELEASE_DATE, date);
        cv.put(DatabaseContract.TaskColumns.POSTER_PATH, poster);
        cv.put(DatabaseContract.TaskColumns.BACKDROP_PATH, backdrop);
        db.insert(DatabaseContract.TABLE_NAME, null, cv);
    }

    public void addShows(String name, String vote, String overview, String date,
                          String poster, String backdrop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.TaskColumns.NAME, name);
        cv.put(DatabaseContract.TaskColumns.VOTE_AVERAGE, vote);
        cv.put(DatabaseContract.TaskColumns.OVERVIEW, overview);
        cv.put(DatabaseContract.TaskColumns.FIRST_AIR_DATE, date);
        cv.put(DatabaseContract.TaskColumns.POSTER_PATH, poster);
        cv.put(DatabaseContract.TaskColumns.BACKDROP_PATH, backdrop);
        db.insert(DatabaseContract.TABLE_NAME, null, cv);
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM " + DatabaseContract.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
