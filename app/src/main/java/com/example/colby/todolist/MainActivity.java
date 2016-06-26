package com.example.colby.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    //set request code
    private final int REQUEST_CODE = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView)findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        //items.add("Wash Dishes");
        //items.add("Make Dinner");
        setupListViewListener();
    }



    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,View item, int pos, long id) {
                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        return true;
                    }
                }
        );

        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter,View item, int pos, long id) {
                        String selectedFromList = (lvItems.getItemAtPosition(pos)).toString(); // get the task in the list
                        Intent i = new Intent(MainActivity.this, editItemActivity.class);
                        // put "extras" into the bundle for access in the second activity
                        i.putExtra("taskName", selectedFromList);
                        i.putExtra("position", pos);
                        i.putExtra("mode", 2);
                        startActivityForResult(i, REQUEST_CODE); // set up activity to receive data.
                    }
                }
        );
    }


    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    //update todo file
    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        int position = itemsAdapter.getCount();
        itemsAdapter.insert(itemText, position);
        etNewItem.setText("");
        writeItems();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            writeItems();
            String name = data.getExtras().getString("taskName");
            int position = data.getExtras().getInt("position");
            int code = data.getExtras().getInt("code", 0);
            items.remove(position);
            itemsAdapter.insert(name, position);
            Toast.makeText(this, "Task is now: \n'" + name + "'", Toast.LENGTH_SHORT).show(); // show the data passed back
            writeItems();

        }
    }


}
