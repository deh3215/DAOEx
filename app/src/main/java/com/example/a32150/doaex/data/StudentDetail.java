package com.example.a32150.doaex.data;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a32150.doaex.MainActivity;
import com.example.a32150.doaex.R;
import com.example.a32150.doaex.StudentUpdate;

public class StudentDetail extends AppCompatActivity {

    TextView identity, name, phone, addr;
    Student stu;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        identity = (TextView)findViewById(R.id.id);
        phone = (TextView)findViewById(R.id.phone);
        name = (TextView)findViewById(R.id.name);
        addr = (TextView)findViewById(R.id.addr);

        Intent it=getIntent();
        id=it.getIntExtra("id", -1);
        showData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showData();
    }

    void showData() {
        stu = MainActivity.t.getOneStudent(id);
        identity.setText(String.valueOf(stu.id));
        name.setText(stu.name);
        phone.setText(stu.tel);
        addr.setText(stu.addr);
    }

    public void ClickBack(View v) {
        finish();
    }

    public void ClickDelete(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delele_confirm);
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.t.delete(stu);
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }

    public void ClickUpdate(View v) {
        Intent it = new Intent(StudentDetail.this, StudentUpdate.class);
        it.putExtra("id", id);
        startActivity(it);
    }
}
