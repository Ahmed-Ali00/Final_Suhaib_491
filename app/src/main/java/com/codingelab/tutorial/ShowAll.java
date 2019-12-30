package com.codingelab.tutorial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShowAll extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    query_datalocaal db;
    ListView listView;
    Cursor cursor;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_all_screen);
        listView=(ListView)findViewById(R.id.listView);
        db = new query_datalocaal(getApplicationContext());
        sqLiteDatabase=db.getReadableDatabase();
        cursor=db.getAllData();
        listAdapter=new ListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listAdapter);
        if(cursor.moveToFirst())
        {

            do
                {

                    String name,mobile,email;
                    String id;
                    id=cursor.getString(0);
                    name=cursor.getString(1);
                    mobile=cursor.getString(2);
                    email=cursor.getString(3);
                    Data_Provider dataProvider=new Data_Provider(id,name,mobile,email);
                    listAdapter.add(dataProvider);


            }while (cursor.moveToNext());

        }

    }

    }
