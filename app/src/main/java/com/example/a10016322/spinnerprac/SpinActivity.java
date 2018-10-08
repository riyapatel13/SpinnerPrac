package com.example.a10016322.spinnerprac;
//change this line on computer

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinActivity extends AppCompatActivity {

    Spinner prefix, addressBook;
    ArrayList<String> prefixList, nameList;
    TextView fullName, smallOne, smallTwo;
    Button add;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);

        prefix = (Spinner)(findViewById(R.id.prefix_id));
        addressBook = (Spinner)(findViewById(R.id.address_id));
        fullName = (TextView) (findViewById(R.id.name_id));
        smallOne = (TextView) (findViewById(R.id.small1_id));
        smallTwo = (TextView) (findViewById(R.id.small2_id));
        add = (Button) (findViewById(R.id.button_id));
        editText = (EditText) (findViewById(R.id.editText_id));

        prefixList = new ArrayList<>();
        prefixList.add("Mr. ");
        prefixList.add("Mrs. ");
        prefixList.add("Ms. ");
        prefixList.add("Dr. ");

        ArrayAdapter<String> preAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, prefixList);
        prefix.setAdapter(preAdapter);

        nameList = new ArrayList<>();
        final ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, nameList);
        addressBook.setAdapter(nameAdapter); //allows you to click on the items in the address book

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName.setText(prefix.getSelectedItem().toString() + editText.getText());
                nameList.add(fullName.getText().toString());
                nameAdapter.notifyDataSetChanged();
            }
        });

    }
}
