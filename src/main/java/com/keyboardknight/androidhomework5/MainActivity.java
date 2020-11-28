package com.keyboardknight.androidhomework5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String registeredAccount="";
    String registeredPassword="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText act = (EditText)findViewById(R.id.account_input);
                String actInput=act.getText().toString();
                EditText psw = (EditText)findViewById(R.id.password_input);
                String pswInput=psw.getText().toString();
                if(actInput.equals(registeredAccount)&&pswInput.equals(registeredPassword)) {
                    Toast.makeText(MainActivity.this,"已登录",Toast.LENGTH_SHORT).show();
                    Intent Login = new Intent(MainActivity.this,Loading.class);
                    startActivity(Login);
                }
                else{
                    Toast.makeText(MainActivity.this,"请检查账号及密码",Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView noAccount = (TextView)findViewById(R.id.no_account);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRegister = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(toRegister);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent getAccount = getIntent();
        registeredAccount=getAccount.getStringExtra("account");
        registeredPassword=getAccount.getStringExtra("password");

    }
}