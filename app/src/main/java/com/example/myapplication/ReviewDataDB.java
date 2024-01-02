package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static java.sql.DriverManager.println;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class ReviewDataDB extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "reviewdata.db";
    public static final int DATABASE_VERSION = 1;

    //TABLE 1
    public static final String TABLE_NAME = "review_info";
    public static final String COLUMN_MOVIE = "movie";
    public static final String COLUMN_REVIEW = "review";
    public static final String COLUMN_SCORE = "score";

    //TABLE 2
    public static final String TABLE_NAME_2 = "movie_rank";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AVG_SCORE = "avg_score";

    //DB 생성
    public ReviewDataDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    //TABLE 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_MOVIE + " TEXT," +
                COLUMN_REVIEW + " TEXT," +
                COLUMN_SCORE + " REAL);";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_NAME_2 +
                " (" + COLUMN_TITLE + " TEXT," +
                COLUMN_AVG_SCORE + " REAL);";
        db.execSQL(query2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        onCreate(db);
    }

    //데이터 가져오기
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }
    public Cursor readAllData2(){
        String query = "SELECT * FROM " + TABLE_NAME_2;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

    //데이터 등록
    public void addReviewData(String movie, String review, float score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ReviewDataDB.COLUMN_MOVIE, movie);
        cv.put(ReviewDataDB.COLUMN_REVIEW, review);
        cv.put(ReviewDataDB.COLUMN_SCORE, score);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else if (result != -1){
            Toast.makeText(context, "Succeed", Toast.LENGTH_SHORT).show();
        }
    }

    public void addRankingData(String title, float avg_score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ReviewDataDB.COLUMN_TITLE, title);
        cv.put(ReviewDataDB.COLUMN_AVG_SCORE, avg_score);

        db.insert(TABLE_NAME_2, null, cv);
    }

    public boolean isValueExist(String title){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        try{
            String query = "SELECT " + COLUMN_TITLE + " FROM " + TABLE_NAME_2 + " WHERE " + COLUMN_TITLE + " =?";
            cursor = db.rawQuery(query, new String[]{title});
            return cursor.moveToFirst();
        } finally {
            if (cursor != null){
                cursor.close();
            }
            db.close();
        }
    }

    public int CountValue(String title){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try{
            String query = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + COLUMN_MOVIE + " =?";
            cursor = db.rawQuery(query, new String[]{title});

            if(cursor.moveToFirst()){
                return cursor.getInt(0);
            }

            return 0;
        } finally {
            if (cursor != null){
                cursor.close();
            }
            db.close();
        }
    }

    public float getSumForTitle(String title){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try{
            String query = "SELECT SUM(" + COLUMN_SCORE + ") FROM " + TABLE_NAME + " WHERE " + COLUMN_MOVIE + " = ?";
            cursor = db.rawQuery(query, new String[]{title});
            if(cursor.moveToFirst()){
                return cursor.getFloat(0);
            }

            return 0f;
        } finally {
            if (cursor != null){
                cursor.close();
            }
            db.close();
        }
    }

    //데이터 수정
    public void updateValue(String title, float new_avg_score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ReviewDataDB.COLUMN_AVG_SCORE, new_avg_score);
        db.update(TABLE_NAME_2, cv, "title = ?", new String[]{title});

        db.close();
    }

    //내림차준 정렬
    public Cursor getAllDataSortedByColumn(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sortOrder = COLUMN_AVG_SCORE + " DESC";
        return db.query(
                TABLE_NAME_2,
                null,
                null,
                null,
                null,
                null,
                sortOrder);
    }

}
