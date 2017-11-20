package com.example.a32150.doaex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.a32150.doaex.data.Student;

public class StudentUpdate extends AppCompatActivity {

    EditText et1, et2, et3;
    int id;
    Student stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);

        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.phone);
        et3=(EditText)findViewById(R.id.addr);
        id = getIntent().getIntExtra("id", -1);
        stu = MainActivity.t.getOneStudent(id);
        et1.setText(stu.name);
        et2.setText(stu.tel);
        et3.setText(stu.addr);

    }
    public void ClickUpdate(View v)
    {
        stu.name = et1.getText().toString();
        stu.tel = et2.getText().toString();
        stu.addr = et3.getText().toString();
        MainActivity.t.update(stu);
        finish();
    }
    public void ClickBack(View v)
    {
        finish();
    }

}
