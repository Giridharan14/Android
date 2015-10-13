package com.example.parthiban.task;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    Thread t = new Thread();
    TextView tv;
    ImageView i_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        i_view = (ImageView)findViewById(R.id.imageView);
        try {
            i_view.setImageResource(R.drawable.ic_launcher);
            tv.setText("This page is wait for 3 Seconds....");
            t.sleep(3000);
            System.out.println("Wait Succss");
            //t.start();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        Intent N = new Intent(MainActivity.this,Register.class);
        System.out.println("Going to Register page.....");
        startActivity(N);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
