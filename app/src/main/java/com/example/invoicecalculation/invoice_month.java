package com.example.invoicecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class invoice_month extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        Button ncontinue =(Button)findViewById(R.id.button_continue);
        RadioButton month1 =(RadioButton)findViewById(R.id.radioButton1);
        RadioButton month2 =(RadioButton)findViewById(R.id.radioButton2);
        RadioButton month3 =(RadioButton)findViewById(R.id.radioButton3);
        RadioButton month4 =(RadioButton)findViewById(R.id.radioButton4);
        RadioButton month5 =(RadioButton)findViewById(R.id.radioButton5);
        RadioButton month6 =(RadioButton)findViewById(R.id.radioButton6);
        //----------------------------------------------------------------------------------------------//
       final Intent intent = new Intent();
        final Bundle bundle = new Bundle();
        //--------------------------------------------------------------------------------------------//
        month1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            bundle.putInt("month",2);
            }
        });
        month2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("month",4);
            }
        });
        month3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("month",6);
            }
        });
        month4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("month",8);
            }
        });
        month5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("month",10);
            }
        });
        month6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("month",12);
            }
        });
        ncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            intent.putExtras(bundle);
            intent.setClass(invoice_month.this,invoice_number.class);
            startActivity(intent);
            Log.e("sdfbfuub","==========111========="+bundle);
            }
        });
    }
}
