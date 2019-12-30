package com.codingelab.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity  {
  private Button Insert;
  private Button Search;
  EditText edit_name;
  EditText edit_phone;
  EditText edit_email;
  private Button next;
  private Button show;

  //ProgressBar pb;

  ArrayList<User> usersPhp;
  ArrayList<User> usersSqlite ;


  SQLiteDatabase sqLiteDatabase;
  query_datalocaal db;
  Cursor cursor;



  private Quiryphp quiry;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (android.os.Build.VERSION.SDK_INT > 9) {
      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
      StrictMode.setThreadPolicy(policy);
    }
    // initilizing propreties
    this.Insert=(Button)findViewById(R.id.Insert);
    Search=(Button)findViewById(R.id.Search);
    edit_name=(EditText)findViewById(R.id.edit_name);
    edit_phone=(EditText)findViewById(R.id.edit_phone);
    edit_email=(EditText)findViewById(R.id.edit_email);
      this.next=(Button)findViewById(R.id.next);
    this.show=(Button)findViewById(R.id.show_users);

   // pb = (ProgressBar) findViewById(R.id.pb);

    this.next.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
              startActivity(intent);
          }
      });




    this.quiry=new Quiryphp();
    // preparing listener (onAction)
    this.Insert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String msg=quiry.doInBackground("insert",edit_name.getText().toString(),edit_phone.getText().toString(),edit_email.getText().toString());
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
      }
    });

    this.Search.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, Search_users_PhpActivity.class);
        startActivity(i);
      }
    });






      this.show.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent i = new Intent(MainActivity.this, show_users_php.class);
              startActivity(i);

          }
      });




  }

  boolean containName(List<User> list, User userphp) {

    for(int i=0;i<list.size();i++) {
      if (list.get(i).getName().equals(userphp.getName()) && list.get(i).getEmail().equals(userphp.getEmail())&& list.get(i).getPhone().equals(userphp.getPhone())){
        return true;
      }
    }

    return false;
  }



}
