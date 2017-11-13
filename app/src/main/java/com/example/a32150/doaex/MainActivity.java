package com.example.a32150.doaex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.a32150.doaex.data.MyAdapter;
import com.example.a32150.doaex.data.Student;
import com.example.a32150.doaex.data.StudentDAOMemoryImpl;
import com.example.a32150.doaex.data.StudentDAOTest1;
import com.example.a32150.doaex.data.StudentDetail;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static StudentDAOMemoryImpl t = new StudentDAOMemoryImpl();
    ListView lv;
    ArrayList<Map<String, Object>> mylist;
    Intent it;
    RecyclerView rv;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=(RecyclerView)findViewById(R.id.recyclerView);
        rv.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(mLayoutManager);
        t.add(new Student("Jimmy", "66666", "handsome"));
        t.add(new Student("Jim", "999", "long"));
        mAdapter = new MyAdapter(MainActivity.this, t.getData());
        rv.setAdapter(mAdapter);

//------------------------------------------------------
        if(false) {
            //StudentDAOTest1 t = new StudentDAOTest1();
            t.add(new Student("Jimmy", "1111", "handsome"));
            t.add(new Student("Jim", "999", "high"));

            Student[] mylist = t.getData();
            for (Student s : mylist) {
                Log.d("Data", s.toString());
            }
            //Update student資料
            //Student editStudent = mylist.get(0);
            Student editStudent = mylist[0];
            editStudent.tel = "520";
            t.update(editStudent);

            //ArrayList<Student> mylist1 = t.getData();
            Student[] mylist1 = t.getData();
            for (Student s : mylist1) {
                Log.d("DATAS", "update:" + s.toString());
            }
        }
//------------------------------------------------------




    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter = new MyAdapter(MainActivity.this, t.getData());
        rv.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())    {
            case R.id.add:
                it = new Intent();
                it.setClass(MainActivity.this, StudentAdd.class);
                startActivity(it);
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.detail:
                it = new Intent();
                it.setClass(MainActivity.this, StudentDetail.class);
                startActivity(it);
                Toast.makeText(this, "Detail", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

}
