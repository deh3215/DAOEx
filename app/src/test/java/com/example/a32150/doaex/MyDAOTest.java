package com.example.a32150.doaex;

import android.util.Log;

import com.example.a32150.doaex.data.Student;
import com.example.a32150.doaex.data.StudentDAO;
import com.example.a32150.doaex.data.StudentDAOMemoryImpl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by 32150 on 2017/11/15.
 */

public class MyDAOTest {
    @Test
    public void MyTest()   {

        assertEquals(3+3, 6);
    }

    @Test
    public void TestStudentDAO_1()    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();

        dao.add(new Student("A1", "111", "wewewe"));
        dao.clear();
        dao.add(new Student("A2", "155wwww11", "weweewe"));
        dao.add(new Student("A3", "2444111", "wewerwerwerewe"));

        Student[] stud = dao.getData();
        System.out.print(stud[1].tel);
        assertEquals(stud.length, 2);

    }

    @Test
    public void TestStudentDAO_2()    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();

        dao.add(new Student("A1", "111", "wewewe"));
        dao.add(new Student("A2", "155wwww11", "weweewe"));
        dao.add(new Student("A3", "2444111", "wewerwerwerewe"));

        Student[] stud = dao.getData();
        System.out.print(stud[1].tel);
        assertEquals(stud[1].tel, "155wwww11");
    }


    @Test
    public void TestStudentDAO_Update()    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();

        dao.add(new Student("A1", "111", "wewewe"));
        dao.add(new Student("A2", "155wwww11", "weweewe"));
        dao.add(new Student("A3", "2444111", "wewerwerwerewe"));

        Student[] stud = dao.getData();
        dao.update(stud[0]);
        stud[0].name="xxxxxxxx";

        assertEquals(stud[0].name, "xxxxxxxx");
    }

    @Test
    public void TestStudentDAO_Delete()    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();

        dao.add(new Student("A1", "111", "wewewe"));
        dao.add(new Student("A2", "155wwww11", "weweewe"));
        dao.add(new Student("A3", "2444111", "wewerwerwerewe"));

        Student[] stud = dao.getData();
        dao.delete(stud[1]);
        assertEquals(dao.getData().length, 2);
    }

    @Test
    public void TestStudentDAO_Get()    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("A1", "111", "wewewe"));
        dao.add(new Student("A2", "155wwww11", "weweewe"));
        dao.add(new Student("A3", "2444111", "wewerwerwerewe"));

        Student s = dao.getOneStudent(3);

        assertEquals(s.addr, "wewerwerwerewe");
    }

    @Test
    public void TestStudentDAO_Search()    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        //dao.clear();

        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        dao.add(new Student("CC", "66", "aabb"));
        Student s[] = dao.searchBYName("CC");

        //System.out.println(s[0].name);
        //System.out.println(s[1].name);
        assertEquals(s.length, 2);
    }
}