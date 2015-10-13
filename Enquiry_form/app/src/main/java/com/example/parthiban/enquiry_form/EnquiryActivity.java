package com.example.parthiban.enquiry_form;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;



public class EnquiryActivity extends Activity {
    EditText name,phone,mail,category,submit;
    AutoCompleteTextView auto;
    MultiAutoCompleteTextView multi;
    ArrayAdapter adapter1,adapter2;
    String[] a_comp = {"Male","Female"};
    String[] m_comp = {"Android","IOS","Web Design"};
    //int a = 0,b = 0,c = 0,check = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        name = (EditText)findViewById(R.id.editText2);
        phone = (EditText)findViewById(R.id.editText3);
        mail = (EditText)findViewById(R.id.editText4);
        category = (EditText)findViewById(R.id.editText5);
        submit = (EditText)findViewById(R.id.editText11);
        auto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        multi = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        adapter1 =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,a_comp);
        adapter2 =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,m_comp);

        auto.setAdapter(adapter1);
        multi.setAdapter(adapter2);
        auto.setThreshold(1);
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent N = new Intent(EnquiryActivity.this,enquiry_from_nextpageActivity.class);
                Bundle bd = new Bundle();

                bd.putString("us",name.getText().toString());
                bd.putString("no",phone.getText().toString());
                bd.putString("mal",mail.getText().toString());

                bd.putString("cy",auto.getText().toString());

                String str = multi.getText().toString();
                String[] str_split = str.split(",");
                bd.putStringArray("cs",str_split);

                //N.putExtra("cs",str_split);
                //check = str_split.length;
                //bd.putInt("len",check);
              /*  for(String s : str_split)
                {
                    switch(s)
                    {
                        case "Android":
                        {
                            a = 1;

                            break;
                        }
                        case "IOS":
                        {
                            b = 1;

                            break;
                        }
                        case "Web Design":
                        {
                            c = 1;

                            break;
                        }
                    }
                }
                bd.putInt("A",a);
                bd.putInt("B",b);
                bd.putInt("C",c);*/
                N.putExtras(bd);
                startActivity(N);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enquiry, menu);
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
