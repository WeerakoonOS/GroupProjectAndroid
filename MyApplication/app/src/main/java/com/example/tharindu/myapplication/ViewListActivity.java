package com.example.tharindu.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListActivity extends AppCompatActivity {
    private static final String TAG = "ViewListActivity";
    private Button btnDeleteList;
    DatabaseHelper mDatabaseHeper;
    ListView lvShowList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlist_activity);

        init();
        populateList();
        clickDelete();

    }

    private void init(){
        lvShowList = (ListView)findViewById(R.id.lvShowList);
        mDatabaseHeper = new DatabaseHelper(this);
        btnDeleteList = (Button)findViewById(R.id.btnDeleteList);
    }

    private void populateList(){
        Log.d(TAG, "populateList: Displaying the data in ListView.");
        Cursor data = mDatabaseHeper.getData(); //get the data and append to a list
        ArrayList<String> listData = new ArrayList<String>();
        while(data.moveToNext()){
            listData.add(data.getString(1)); //get data from coloum 1 and add to arraylist
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData); //create the list adapter and set the adapter
        lvShowList.setAdapter(adapter);
    }

    private void clickDelete(){
        btnDeleteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = mDatabaseHeper.deleteTable();
                if(result){
                    toastMessage("List Deletded Successfully!");
                    Intent i = new Intent(ViewListActivity.this, CartActivity.class);
                    startActivity(i);
                }else{
                    toastMessage("Nothing to delete");
                }
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
