package com.example.parthiban.task;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Login extends Activity {

    EditText et5,et6;
    Button b2;
    TextView tv;
    List e_Text = new ArrayList();
    int FLAG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et5 = (EditText) findViewById(R.id.editText5);
        et6 = (EditText) findViewById(R.id.editText6);
        tv = (TextView) findViewById(R.id.textView5);
        b2 = (Button) findViewById(R.id.button2);

        e_Text.add(et5);
        e_Text.add(et6);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us, ps, Name;
                Iterator L_itr = e_Text.iterator();

                Bundle bd2 = getIntent().getExtras();
                Intent L = new Intent(Login.this, Welcome.class);
                Bundle bd3 = new Bundle();

                us = et5.getText().toString();
                ps = et6.getText().toString();
                Name = bd2.getString("user");

                while (L_itr.hasNext())
                {
                    EditText e_Temp = (EditText)L_itr.next();
                    if((e_Temp.getText().toString().isEmpty()))
                    {
                        Toast.makeText(Login.this,"Please enter valid " + e_Temp.getHint(),Toast.LENGTH_SHORT).show();
                        FLAG = 1;
                    }
                }

                if(FLAG != 1) {
                    System.out.println("checking username & password");

                    if (Name.equals(us) && bd2.getString("pass").equals(ps)) {
                        System.out.println("Checked Succssfully");
                        bd3.putString("n", Name);
                        L.putExtras(bd3);
                        System.out.println("Going to welcome page");
                        startActivity(L);
                    } else {
                        System.out.println("Wrong details");
                        tv.setText("Sorry!! Wrong Username / password.");
                    }
                }
             FLAG = 0;
            }

        });
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_login, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
