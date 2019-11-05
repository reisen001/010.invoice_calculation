package com.example.invoicecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class invoice_calculation extends AppCompatActivity {
    String num1,num2,num3,num4,num5,sent;
    int month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_calculation);

        TextView textView_title = (TextView)findViewById(R.id.textView_titleC);
        TextView show = (TextView)findViewById(R.id.textView_showC);
        Button backA = (Button)findViewById(R.id.button_cbackA);
        Button backB = (Button)findViewById(R.id.button_cbackB);
        //---------------------------------------------------------------------------------//

        final Bundle bundle = getIntent().getExtras();
        month = bundle.getInt("month",0);
        num1 = bundle.getString("num1");
        num2 = bundle.getString("num2");
        num3 = bundle.getString("num3");
        num4 = bundle.getString("num4");
        num5 = bundle.getString("num5");
        sent = bundle.getString(("sent"));

        //--------------------------------------------------------------------------------//
        int month2 =month-1;
        textView_title.setText("109年"+month2+"、"+month+"月中獎發票");
        //--------------------------------------------------------------------------------//
        for(int i=0;i<6;i++){
            if (sent.matches(num1)){
                show.setText("恭喜得到獎金：1000萬元");
            }
            else if(sent.matches(num2)){
                show.setText("恭喜得到獎金：200萬元");
            }
            else if(sent.substring(i,7).matches(num3.substring(i,7))
                    ||sent.substring(i,7).matches(num4.substring(i,7))
                    ||sent.substring(i,7).matches(num5.substring(i,7))){
                switch (i){
                    case 0:
                        show.setText("恭喜得到獎金：20萬元");
                        break;
                    case 1:
                        show.setText("恭喜得到獎金：40000元");
                        break;
                    case 2:
                        show.setText("恭喜得到獎金：10000元");
                        break;
                    case 3:
                        show.setText("恭喜得到獎金：2000元");
                        break;
                    case 4:
                        show.setText("恭喜得到獎金：1000元");
                        break;
                    case 5:
                        show.setText("恭喜得到獎金：200元");
                        break;
                }
                break;
            }
            else {
                show.setText("再接再厲 ");
            }
        }
        backA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                bundle.putInt("month",month);
                intent.putExtras(bundle);
                intent.setClass(invoice_calculation.this,invoice_month.class);
                startActivity(intent);
            }
        });
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(invoice_calculation.this,invoice_number.class);
                startActivity(intent);
            }
        });
    }
}
