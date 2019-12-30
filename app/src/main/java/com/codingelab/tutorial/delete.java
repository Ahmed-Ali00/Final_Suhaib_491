package com.codingelab.tutorial;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class delete extends AppCompatActivity {
    query_datalocaal mydb;
    EditText delte_text;
    Button delte;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_screen);
        mydb = new query_datalocaal(this);
        delte = (Button) findViewById(R.id.delte);



        delte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                delte_text = (EditText)findViewById(R.id.delte_text);
                String id_1=delte_text.getText().toString();
                int id=new Integer(id_1).intValue();
                mydb.deleteContact(id);



            }
        });

    }
}
