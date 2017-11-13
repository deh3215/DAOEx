package com.example.a32150.doaex.data;

/**
 * Created by 32150 on 2017/11/13.
 */

public interface StudentDAO {

    void add(Student s);
    Student[] getData();
    void update(Student s);
}
