package com.example.faisalmaqbool.hoard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.faisalmaqbool.hoard.Adapters.DataAdapter;
import com.example.faisalmaqbool.hoard.Database.DBHelper;
import com.example.faisalmaqbool.hoard.Models.UserInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    DataAdapter dataAdapter;
    RecyclerView recyclerView;
    DBHelper DB_Helper;

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
                Intent adsafe=new Intent(this,AddSafe.class);
                startActivity(adsafe);
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
        //Code to change the title bar of any activity that extends AppCompatActivity
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Safes");
        ab.setSubtitle("You can hide any thing there");
        DB_Helper = new DBHelper(this);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<UserInfo> ui = DB_Helper.getAll();

        dataAdapter = new DataAdapter(this, ui);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(dataAdapter);

    }
}
