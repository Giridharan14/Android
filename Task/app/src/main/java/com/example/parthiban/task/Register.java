package com.example.parthiban.task;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Register extends Activity {

    EditText et1,et2,et3,et4;
    Button b;
    List e_Text = new ArrayList();
    int FLAG = 0;
     /*{
        @Override
        public void add(int location, Object object) {

        }

        @Override
        public boolean add(Object object) {
            return false;
        }

        @Override
        public boolean addAll(int location, Collection collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean contains(Object object) {
            return false;
        }

        @Override
        public boolean containsAll(Collection collection) {
            return false;
        }

        @Override
        public Object get(int location) {
            return null;
        }

        @Override
        public int indexOf(Object object) {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @NonNull
        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public int lastIndexOf(Object object) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator listIterator(int location) {
            return null;
        }

        @Override
        public Object remove(int location) {
            return null;
        }

        @Override
        public boolean remove(Object object) {
            return false;
        }

        @Override
        public boolean removeAll(Collection collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection collection) {
            return false;
        }

        @Override
        public Object set(int location, Object object) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @NonNull
        @Override
        public List subList(int start, int end) {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public T[] toArray(Object[] array) {
            return new T[0];
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
        et4 = (EditText)findViewById(R.id.editText4);
        b = (Button)findViewById(R.id.button);


        e_Text.add(et1);
        e_Text.add(et2);
        e_Text.add(et3);
        e_Text.add(et4);
        System.out.println("EditText added in List");
        System.out.println("Reg button clicked");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Reg Creating Intent object");
                Intent reg = new Intent(Register.this,Login.class);
                System.out.println("Reg Intent object Created");
                System.out.println("Reg Creating Bundle object");
                Bundle bd = new Bundle();
                System.out.println("Reg Bundle object Created");

                bd.putString("user",et1.getText().toString());
                System.out.println("Reg Username assigned");
                bd.putString("pass",et2.getText().toString());
                bd.putString("e-mail",et3.getText().toString());
                bd.putString("phone",et4.getText().toString());

                System.out.println("Reg putExtras Running");
                Iterator L_itr = e_Text.iterator();
                System.out.println("Iterator obj created");
                while(L_itr.hasNext()) {
                    EditText e_Temp = (EditText) L_itr.next();
                    System.out.println("Check EditText empty / not");
                    if ((e_Temp.getText().toString()).isEmpty()) {
                        System.out.println("Check EditText empty then print Msg");
                        Toast.makeText(Register.this, "Please enter " + e_Temp.getHint(), Toast.LENGTH_SHORT).show();
                        FLAG = 1;
                    }

                }
                if(FLAG != 1)
                    {
                        reg.putExtras(bd);
                        System.out.println("Going to Login page....");
                        startActivity(reg);
                    }

            FLAG = 0;


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
