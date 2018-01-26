package com.example.faisalmaqbool.hoard;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.newSafe:
                Log.i("Menu selected","New Safe");
                return true;
            case R.id.resetPass:
                Log.i("Menu selected","Reset Password");
                return true;
            case R.id.about:
                Log.i("Menu selected","About");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //action bar title chaned
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Safes");
        ab.setSubtitle("You can hide any thing there");
    }
}
