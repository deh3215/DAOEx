package com.example.a32150.doaex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;

import com.example.a32150.doaex.data.DAOType;
import com.example.a32150.doaex.data.MyAdapter;
import com.example.a32150.doaex.data.Student;
import com.example.a32150.doaex.data.StudentDAO;
import com.example.a32150.doaex.data.StudentDAOFactory;
import com.example.a32150.doaex.data.StudentDAOMemoryImpl;
import com.example.a32150.doaex.data.StudentDAOTest1;
import com.example.a32150.doaex.data.StudentDetail;

import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    //public static StudentDAOMemoryImpl t = new StudentDAOMemoryImpl();
    //public static StudentDAOFileImpl t;

    public static StudentDAO t;//宣告介面物件

    final DAOType type = DAOType.DB;

    ListView lv;
    ArrayList<Map<String, Object>> mylist;
    Intent it;
    RecyclerView rv;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    GestureDetector mGD;
    //int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //t = new StudentDAOMemoryImpl(MainActivity.this);
        //t = new StudentDAOFileImpl(MainActivity.this);

        //t = StudentDAOFactory.getStudentDAO(1, this);//memory mode
        t = StudentDAOFactory.getStudentDAO(type, this);//file mode

        rv=(RecyclerView)findViewById(R.id.recyclerView);
        rv.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(mLayoutManager);
        //t.add(new Student("Jimmy", "66666", "handsome"));
        //t.add(new Student("Jim", "999", "long"));

        mGD = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        }
        );
        rv.addOnItemTouchListener(this);

        //mAdapter = new MyAdapter(MainActivity.this, t.getData());
        //rv.setAdapter(mAdapter);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(), e.getY());
        Log.d("Touch", "onInterceptTouchEvent");
        if (mGD.onTouchEvent(e))
        {
            Log.d("Touch", "Single Tap up");
            int position = rv.getChildLayoutPosition(v);
            // Toast.makeText(MainActivity.this, "posi:" + position, Toast.LENGTH_SHORT).show();
            if (position >= 0)
            {
                Intent it = new Intent(MainActivity.this, StudentDetail.class);
                it.putExtra("id", t.getData()[position].id);
                startActivity(it);
                //Toast.makeText(MainActivity.this, ""+t.getData()[position].id, Toast.LENGTH_LONG).show();
            }
           // Toast.makeText(MainActivity.this, ""+(position+1), Toast.LENGTH_LONG).show();
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

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
//                it = new Intent();
//                it.setClass(MainActivity.this, StudentDetail.class);
//                startActivity(it);
                Toast.makeText(this, "Detail", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

}
