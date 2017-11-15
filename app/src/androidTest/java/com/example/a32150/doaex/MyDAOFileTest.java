package com.example.a32150.doaex;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.a32150.doaex.data.Student;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by 32150 on 2017/11/15.
 */
@RunWith(AndroidJUnit4.class)
public class MyDAOFileTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImpl dao = new StudentDAOFileImpl(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.clear();
        dao.add(new Student("Jimmy", "66666", "handsome"));
        dao.add(new Student("Jim", "999", "long"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 2);
    }
}
