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
    //receive data and display it.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String taskName = getIntent().getStringExtra("taskName");
        // int code = getIntent().getIntExtra("code", 0); // code examples had this value being received, but code works fine when it is commented out.
        EditText etNewItem = (EditText)findViewById(R.id.editText);
        etNewItem.setText(taskName); // display data
        etNewItem.setSelection(taskName.length()); // move text cursor to end of line
    }

    //when submit button is clicked, send data back
    public void saveChanges(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        String updatedItem = etNewItem.getText().toString();
        int position = getIntent().getIntExtra("position", 0);
        Intent data = new Intent();

        data.putExtra("taskName", etNewItem.getText().toString());
        data.putExtra("position", position);
        data.putExtra("code", 20);
        setResult(RESULT_OK, data); //pass data back to main activity
        this.finish();
    }




}
