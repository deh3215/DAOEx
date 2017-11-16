package com.example.a32150.doaex;

import android.content.Context;
import android.util.Log;

import com.example.a32150.doaex.data.Student;
import com.example.a32150.doaex.data.StudentDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by 32150 on 2017/11/15.
 */

public class StudentDAOFileImpl implements StudentDAO {
    ArrayList<Student> data = new ArrayList();
    Context context;
    String DATA_FILE;
    static int MaxID=1;

    public StudentDAOFileImpl(Context context) {//這樣才能帶進上一個activity,使用context.getFilesDir(),否則無法使用

        this.context = context;
        DATA_FILE = context.getFilesDir().getAbsolutePath() + File.separator + "mydata.json";
        data = new ArrayList<>();
        loadData();
    }

    private void saveData()
    {
        try {
            FileWriter fw = new FileWriter(DATA_FILE);
            Gson gson = new Gson();
            String str = gson.toJson(data);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData()
    {
        try {
            FileReader fr = new FileReader(DATA_FILE);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            br.close();
            fr.close();
            if (str.trim().length() > 0)
            {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
                data = gson.fromJson(str, listType);
                Log.d("Data", data.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Student s) {
        s.id = MaxID;
        data.add(s);
        MaxID++;
        saveData();
    }

    @Override
    public Student[] getData() {
        return data.toArray(new Student[data.size()]);
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public void clear() {
        data.clear();
        saveData();
    }

    @Override
    public Student getOneStudent(int id) {
        for (Student tmp : data)
        {
            if (tmp.id == id)
            {
                return tmp;
            }
        }
        return null;
    }

    @Override
    public Student[] searchBYName(String name) {
        return new Student[0];
    }
}
