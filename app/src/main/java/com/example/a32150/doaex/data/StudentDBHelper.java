package com.example.a32150.doaex.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deh3215 on 2017/11/20.
 */

public class StudentDBHelper extends SQLiteOpenHelper {

    static String FILENAME = "stu";
    static int version = 1;

    public StudentDBHelper(Context context) {
        super(context, FILENAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE  TABLE \"main\".\"students\" (\"_id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , \"name\" VARCHAR, \"tel\" VARCHAR, \"addr\" VARCHAR)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
