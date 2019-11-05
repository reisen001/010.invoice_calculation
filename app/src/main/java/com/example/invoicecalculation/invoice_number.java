package com.example.invoicecalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class invoice_number extends AppCompatActivity {
    String num1,num2,num3,num4,num5,sent;
    int month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_number);

        final EditText inv_num =(EditText)findViewById(R.id.editText_inv);
        TextView title = (TextView)findViewById(R.id.textView_title);
        TextView show = (TextView)findViewById(R.id.textView_show);
        Button back = (Button)findViewById(R.id.button_backA);
        Button result = (Button)findViewById(R.id.button_result);
        //------------------------------------------------------------------------//
        final Intent intent = new Intent();
        final Bundle bundle = getIntent().getExtras();
        month = bundle.getInt("month",0);
        final int month2 =month-1;
        title.setText("109年 "+month2+"、"+month+"月中獎發票");
        //------------------------------------------------------------------------//
        int sw_mon =month/2;

        //------------------------------------------------------------------------//
        switch (sw_mon) {
            case 1:
                num1 = getString(R.string.m1_num1);
                num2 = getString(R.string.m1_num2);
                num3 = getString(R.string.m1_num3);
                num4 = getString(R.string.m1_num4);
                num5 = getString(R.string.m1_num5);
                break;
            case 2:
                num1 = getString(R.string.m2_num1);
                num2 = getString(R.string.m2_num2);
                num3 = getString(R.string.m2_num3);
                num4 = getString(R.string.m2_num4);
                num5 = getString(R.string.m2_num5);
                break;
            case 3:
                num1 = getString(R.string.m3_num1);
                num2 = getString(R.string.m3_num2);
                num3 = getString(R.string.m3_num3);
                num4 = getString(R.string.m3_num4);
                num5 = getString(R.string.m3_num5);
                break;
            case 4:
                num1 = getString(R.string.m4_num1);
                num2 = getString(R.string.m4_num2);
                num3 = getString(R.string.m4_num3);
                num4 = getString(R.string.m4_num4);
                num5 = getString(R.string.m4_num5);
                break;
            case 5:
                num1 = getString(R.string.m5_num1);
                num2 = getString(R.string.m5_num2);
                num3 = getString(R.string.m5_num3);
                num4 = getString(R.string.m5_num4);
                num5 = getString(R.string.m5_num5);
                break;
            case 6:
                num1 = getString(R.string.m6_num1);
                num2 = getString(R.string.m6_num2);
                num3 = getString(R.string.m6_num3);
                num4 = getString(R.string.m6_num4);
                num5 = getString(R.string.m6_num5);
                break;

        }
        show.setText("中獎號碼為:\n"+num1+'\n'+num2+'\n'+num3+'\n'+num4+'\n'+num5);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(invoice_number.this,invoice_month.class);
                startActivity(intent);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(inv_num.getText().toString().equals(""))
            {
                Toast toast = Toast.makeText(invoice_number.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                toast.show();
            }
            else if(inv_num.getText().toString().length()<8||inv_num.getText().toString().length()>8){
                Toast toast = Toast.makeText(invoice_number.this, "發票號碼一共8碼，請確認輸入是否正確!!", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
                sent =inv_num.getText().toString();
                intent.setClass(invoice_number.this, invoice_calculation.class);
                bundle.putString("num1",num1);
                bundle.putString("num2",num2);
                bundle.putString("num3", num3);
                bundle.putString("num4",num4);
                bundle.putString("num5", num5);
                bundle.putString("sent", sent);
                bundle.putInt("month",month);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        }
    });

    }
}
