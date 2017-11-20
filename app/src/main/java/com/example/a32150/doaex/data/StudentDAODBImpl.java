package com.example.a32150.doaex.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by deh3215 on 2017/11/20.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    StudentDBHelper helper;
    SQLiteDatabase db;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
        helper = new StudentDBHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public void add(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("name", s.name);
        cv.put("tel", s.tel);
        cv.put("addr", s.addr);
        db.insert("students", null, cv);
    }

    @Override
    public Student[] getData() {
        ArrayList<Student> tmpList = new ArrayList<>();
        Cursor c = db.query("students", new String[] {"_id", "name", "tel", "addr"}, null, null, null, null ,null);
        if (c.moveToFirst())
        {
            tmpList.add(new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
            while(c.moveToNext())
            {
                tmpList.add(new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
            }
        }
        return tmpList.toArray(new Student[tmpList.size()]);
    }

    @Override
    public void update(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("name", s.name);
        cv.put("tel", s.tel);
        cv.put("addr", s.addr);
        db.update("students", cv, "_id=?", new String[] {String.valueOf(s.id)});
    }

    @Override
    public void delete(Student s) {
        db.delete("students", "_id=?", new String[] {String.valueOf(s.id)});
    }

    @Override
    public void clear() {
        db.delete("students", null, null);
    }

    @Override
    public Student getOneStudent(int id) {
        Cursor c = db.query("students", new String[] {"_id", "name", "tel", "addr"}, "_id=?", new String[] {String.valueOf(id)}, null, null ,null);
        if (c.moveToFirst())
        {
            Student s = new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
            return s;
        }

        return null;
    }

    @Override
    public Student[] searchByName(String name) {
        Log.d("name=", name);
        //Cursor c = db.query("students", new String[] {"_id", "name", "tel", "addr"}, "name=?", new String[] {name}, null, null ,null);
        Cursor c = db.rawQuery("select * from students where name='"+name+"'", null);
        ArrayList<Student> tmpList = new ArrayList<>();

        Student[] s;
        if (c.moveToFirst())
        {
            while(c.moveToNext()) {
                //s = new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
                tmpList.add(new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
                //return s;
            }
        }
        Log.d("count", String.valueOf(tmpList.size()));

        return tmpList.toArray(new Student[tmpList.size()]);
    }
}

