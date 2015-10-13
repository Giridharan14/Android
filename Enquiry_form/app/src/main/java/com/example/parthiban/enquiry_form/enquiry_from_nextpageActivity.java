package com.example.parthiban.enquiry_form;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Arrays;


public class enquiry_from_nextpageActivity extends Activity {
    TextView tv1,tv2,tv3;
    RadioButton rb1,rb2;
    CheckBox ch1,ch2,ch3;

    EditText check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry_from_nextpage);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);
        tv3 = (TextView) findViewById(R.id.textView4);

        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        ch1 = (CheckBox) findViewById(R.id.checkBox);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);

        check = (EditText) findViewById(R.id.editText7);

        Bundle b = getIntent().getExtras();
        tv1.setText(b.getString("us"));
        tv2.setText(b.getString("no"));
        tv3.setText(b.getString("mal"));

        if (b.getString("cy").equals("Male")) {
            rb1.setChecked(true);
        } else {
            rb2.setChecked(true);
        }

       /* if (b.getInt("A") == 1) {
            ch1.setChecked(true);
        } else {
            ch1.setChecked(false);
        }

        if (b.getInt("B") == 1) {
            ch2.setChecked(true);
        } else {
            ch2.setChecked(false);
        }

        if (b.getInt("C") == 1) {
            ch3.setChecked(true);
        } else {
            ch3.setChecked(false);
        }*/

        //check.setText(Integer.toString(b.getInt("len")));
        //Intent in = getIntent();
        String[] che = b.getStringArray("cs");
        /* Arrays.sort(che);
        check.setText(Integer.toString(che.length));
        System.out.println("Hello Android");
        for(String te : che)
        {

            System.out.println(te);
        }*/
        //check.setText(che.length+"  ");
        //for(String f : che)
          //  check.setText(f+",");

        for(int i=0;i<3;i++)
        {
            switch (che[i]) {
                case "Android":
                {
                    ch1.setChecked(true);
                    break;
                }
                case "IOS":
                {
                    ch2.setChecked(true);
                    break;
                }
                case "Web Design":
                {
                    ch3.setChecked(true);
                    break;
                }

            }
        }


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enquiry_from_nextpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
