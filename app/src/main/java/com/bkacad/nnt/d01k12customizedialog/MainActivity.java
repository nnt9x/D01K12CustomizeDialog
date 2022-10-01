package com.bkacad.nnt.d01k12customizedialog;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;

    private List<String> dataSource;

    private ArrayAdapter<String> arrayAdapter;

    private ContactDialog contactDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContact = findViewById(R.id.lvContact);

        dataSource = new ArrayList<>();
        dataSource.add("Contact 1 - 123456789");
        dataSource.add("Contact 2 - 123456788");
        dataSource.add("Contact 3 - 123456787");

        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,
                dataSource);

        lvContact.setAdapter(arrayAdapter);

        // Tạo đối tượng dialog
    }

    public void showDialog(View view) {
        if (contactDialog == null) {
            contactDialog = new ContactDialog(this) {
                @Override
                protected void sendData(String data) {
                    dataSource.add(data);
                    arrayAdapter.notifyDataSetChanged();
                }
            };
        }
        contactDialog.show();
    }
}