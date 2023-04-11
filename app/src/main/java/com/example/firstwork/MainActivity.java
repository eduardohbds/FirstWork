package com.example.firstwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ListView list;
    Button button;
    ArrayAdapter<String> itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list = findViewById(R.id.list);
        button = findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });
        items = new ArrayList<>();
        itemAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        list.setAdapter(itemAdapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return removeItem(position);
            }
        });

    }

    private boolean removeItem(int position) {
        Context context = getApplicationContext();
        items.remove(position);
        itemAdapter.notifyDataSetChanged();
        Toast.makeText(context,"Item removed",Toast.LENGTH_LONG).show();
        return true;
    }

    private void addItem(View v) {
        EditText input = findViewById(R.id.edit_text);
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))){
            itemAdapter.add(itemText);
            input.setText("");
        }else {
            Toast.makeText(getApplicationContext(),"Please enter text...",Toast.LENGTH_LONG ).show();
        }
    }
}