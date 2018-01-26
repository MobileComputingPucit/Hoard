package com.example.faisalmaqbool.hoard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText passText;
    public void onClick(View v)
    {
        Toast.makeText(this, "We will send you your password", Toast.LENGTH_LONG).show();

    }
    public void signIn(View v)
    {
        String pass=sp.getString("password","");
        String pass1= passText.getText().toString();
        if(pass1.contentEquals(pass))
        {
            Toast.makeText(this, "Loged In!!!", Toast.LENGTH_SHORT).show();
            Intent main=new Intent(this,MainActivity.class);
            startActivity(main);
            finish();

        }
        else
        {
            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        passText=(EditText) findViewById(R.id.pass);
        sp=this.getSharedPreferences("com.example.faisalmaqbool.hoard",MODE_PRIVATE);
        if(sp.getString("password","").equals(""))
        {
            Intent loginIntent=new Intent(this,SignupActivity.class);
            startActivity(loginIntent);
            finish();
        }




    }
}
