package com.example.a32150.doaex.data;

/**
 * Created by 32150 on 2017/11/13.
 */

public interface StudentDAO {

    void add(Student s);
    Student[] getData();
    void update(Student s);
    void delete(Student s);
    void clear();
    Student getOneStudent(int id);
    Student[] searchByName(String name);
}
