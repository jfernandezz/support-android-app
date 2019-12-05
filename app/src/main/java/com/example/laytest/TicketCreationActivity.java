package com.example.laytest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import java.util.Arrays;
import java.util.List;

import factory.NodeServiceFactory;
import service.NodeService;
import service.SupportTicketMatchedCompaniesService;

public class TicketCreationActivity extends AppCompatActivity {

    private String[] fruits = {"uno","unoMM","uMM","ddd","dos","tres","cuatro"};
    private List<String> frut= Arrays.asList("uno","unoMM","uMM","ddd","dos","tres","cuatro");
    private AppCompatAutoCompleteTextView autoTextView;
    private Spinner ticketActionSpinner;
    private NodeService nodeService = NodeServiceFactory.getNodeService();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_creation);
        SupportTicketMatchedCompaniesService.matchedCompanies= nodeService.getSuppotrTicketCompanies();
        autoTextView = (AppCompatAutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        CustomListAdapter adaptercc = new CustomListAdapter(TicketCreationActivity.this,  R.layout.company_name_items, SupportTicketMatchedCompaniesService.matchedCompanies);
      //  autoTextView.setThreshold(2); //will start working from 2 character
        autoTextView.setAdapter(adaptercc);
        ticketActionSpinner = (Spinner) findViewById(R.id.supportTicketActionSpinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.support_ticket_actions_items,R.id.supportTicketActionItem, fruits);
        ticketActionSpinner.setAdapter(adapter1);
    }

}
