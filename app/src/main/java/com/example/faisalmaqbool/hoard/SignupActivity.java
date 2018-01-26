package com.example.faisalmaqbool.hoard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText passText;
    EditText rePassText;
    EditText emialText;
    public void signUp(View v)
    {
        String password=passText.getText().toString();
        String rePassword=rePassText.getText().toString();
        String email=emialText.getText().toString().trim();
        if(password.equals(rePassword) && !password.equals("") && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            sp.edit().putString("password",password).commit();
            sp.edit().putString("email",email).apply();
            Intent loginIntent=new Intent(this,LoginActivity.class);
            startActivity(loginIntent);

        }
        else
        {
            String errorMsg="";
            if(password.equals(""))
            {
                errorMsg="Password field cannot be empty!\n";
            }
            else if(!password.equals(rePassword))
            {
                errorMsg="Password not matches!\n";
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                errorMsg= errorMsg +" email is not valid\n";
            }
            Toast.makeText(this,errorMsg, Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        passText=(EditText) findViewById(R.id.password);
        rePassText=(EditText) findViewById(R.id.rePass);
        emialText=(EditText) findViewById(R.id.email);


        sp=this.getSharedPreferences("com.example.faisalmaqbool.hoard",MODE_PRIVATE);

    }
}