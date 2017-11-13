package com.example.a32150.doaex.data;



import java.util.ArrayList;

/**
 * Created by 32150 on 2017/11/13.
 */

public class StudentDAOTest1 {
    ArrayList<Student> data = new ArrayList();
    int MaxID = 1;

    public void add(Student stu)
    {
        stu.id = MaxID;
        data.add(stu);
        MaxID++;
    }
    public ArrayList<Student> getData() {
        return data;
    }
    public void update(Student s)
    {
        for (Student tmp : data)
        {
            if (tmp.id == s.id)
            {
                tmp.name = s.name;
                tmp.tel = s.tel;
                tmp.addr = s.addr;
            }
        }
    }
}
