package com.example.a32150.doaex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.a32150.doaex.data.Student;

public class StudentAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);



    }

    public void clickAdd(View v)  {
        EditText ed1 = (EditText) findViewById(R.id.et_name);
        EditText ed2 = (EditText) findViewById(R.id.et_phone);
        EditText ed3 = (EditText) findViewById(R.id.et_statement);

        MainActivity.t.add(new Student(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString()));
        finish();
    }
}
