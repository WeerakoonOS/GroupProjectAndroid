package com.example.tharindu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateNewListActivity extends AppCompatActivity {
    EditText etItemName;
    Button btnAdd, btnDelete, btnUpdate, btnClear;
    ListView lvList;

    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewlist_activity);

        init();
        //Creates new array adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                etItemName.setText(items.get(position));

            }
        });

        clickAdd();
        clickUpdate();
        clickDelete();
        clickClear();

    }

    private void init(){
        etItemName = (EditText)findViewById(R.id.etItemName);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnClear = (Button)findViewById(R.id.btnClear);
        lvList = (ListView)findViewById(R.id.lvList);

    }

    private void add(){
        String itemName = etItemName.getText().toString();
        if(!itemName.isEmpty() && itemName.length()>0){
            adapter.add(itemName);
            adapter.notifyDataSetChanged();
            etItemName.setText("");
            Toast.makeText(getApplicationContext(), "Added " + itemName, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Nothing to add", Toast.LENGTH_SHORT).show();

        }
    }

    private void update(){
        String itemName = etItemName.getText().toString();
        int pos = lvList.getCheckedItemPosition();

        if(!itemName.isEmpty() && itemName.length()>0){
            adapter.remove(items.get(pos));
            adapter.insert(itemName, pos);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Updated " + itemName, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Nothing to update", Toast.LENGTH_SHORT).show();

        }
    }

    private void delete(){

        int pos = lvList.getCheckedItemPosition();
        if(pos > -1){
            adapter.remove(items.get(pos));
            adapter.notifyDataSetChanged();
            etItemName.setText("");
            Toast.makeText(getApplicationContext(), "Deleted ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Nothing to delete", Toast.LENGTH_SHORT).show();
        }
    }

    private void clear(){
        adapter.clear();
        etItemName.setText("");
    }

    private void clickAdd(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
    }

    private void clickUpdate(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
    }

    private void clickDelete(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });
    }

    private void clickClear(){
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }
}
