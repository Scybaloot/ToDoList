package com.example.colby.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class editItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String taskName = getIntent().getStringExtra("taskName");
        int position = getIntent().getIntExtra("position", 0);
        int code = getIntent().getIntExtra("code", 0);

        //write text. set default value, or write to the field?
        EditText etNewItem = (EditText)findViewById(R.id.editText);
        etNewItem.setText(taskName);
        etNewItem.setSelection(taskName.length());
        //return position;

        //etNewItem= taskName;

//        EditText etNewItem = (EditText) findViewById(R.id.editText);
//        etNewItem.add(taskName);
//        etNewItem.setText("");
//        writeItems();
    }

    public void saveChanges(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        String updatedItem = etNewItem.getText().toString();
        int position = getIntent().getIntExtra("position", 0);
        // logcat.print(updatedItem)
//        itemsAdapter.add(itemText);
//        etNewItem.setText("");
//        writeItems();
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("taskName", etNewItem.getText().toString());
        data.putExtra("position", position);
        data.putExtra("code", 20); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set re
        this.finish();
        //when submit button is clicked, send data back
    }

//    public void onSubmit(View v) {
//        //EditText etName = (EditText) findViewById(R.id.name);
//        // Prepare data intent
//        Intent data = new Intent();
//        // Pass relevant data back as a result
//        data.putExtra("name", "name");
//        data.putExtra("code", 200); // ints work too
//        // Activity finished ok, return the data
//        setResult(RESULT_OK, data); // set result code and bundle data for response
//        finish(); // closes the activity, pass data to parent
//    }



}
