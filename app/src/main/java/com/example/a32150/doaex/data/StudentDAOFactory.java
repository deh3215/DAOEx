package com.example.a32150.doaex.data;

import android.content.Context;

import com.example.a32150.doaex.StudentDAOFileImpl;

/**
 * Created by 32150 on 2017/11/20.
 */

public class StudentDAOFactory {
    public static StudentDAO getStudentDAO(DAOType type, Context context)    {

        switch(type)    {
            case MEMORY:
                return new StudentDAOMemoryImpl();
            case FILE:
                return new StudentDAOFileImpl(context);
            case DB:
                return new StudentDAODBImpl(context);
        }
        return null;
    }
}
