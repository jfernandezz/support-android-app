package com.example.laytest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class TicketCreationActivity extends AppCompatActivity {

    private String[] fruits = {"uno","dos","tres","cuatro"};
    private AppCompatAutoCompleteTextView autoTextView;
    private Spinner ticketActionSpinner;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_creation);
        autoTextView = (AppCompatAutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, fruits);
        autoTextView.setThreshold(1); //will start working from first character
        autoTextView.setAdapter(adapter);

        ticketActionSpinner = (Spinner) findViewById(R.id.ticketActionSpinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, fruits);
        ticketActionSpinner.setAdapter(adapter1);


        autoTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //TODO aquí tengo que cargar filtro de compañias
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
