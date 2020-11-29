package com.keyboardknight.androidhomework5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String registeredAccount="";
    String registeredPassword="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText act = (EditText)findViewById(R.id.account_input);
        EditText psw = (EditText)findViewById(R.id.password_input);
        Button loginButton = (Button)findViewById(R.id.login_button);
        CheckBox agr = (CheckBox)findViewById(R.id.i_agree);
        LinearLayout sinaLogin = (LinearLayout)findViewById(R.id.sina_login);
        LinearLayout tencentLogin = (LinearLayout)findViewById(R.id.tencent_login);


        sinaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"已通过新浪微博登录",Toast.LENGTH_SHORT).show();
                Intent loginBySina = new Intent(MainActivity.this,Loading.class);
                startActivity(loginBySina);
            }
        });

        tencentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"已通过腾讯微博登录",Toast.LENGTH_SHORT).show();
                Intent loginByTencent = new Intent(MainActivity.this,Loading.class);
                startActivity(loginByTencent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actInput=act.getText().toString();
                String pswInput=psw.getText().toString();
                Boolean iAgree = agr.isChecked();
                if(actInput.equals(registeredAccount)&&pswInput.equals(registeredPassword)) {
                    if(iAgree) {
                    Toast.makeText(MainActivity.this,"已登录",Toast.LENGTH_SHORT).show();
                    Intent Login = new Intent(MainActivity.this,Loading.class);
                    startActivity(Login);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"同意用户协议才可登录",Toast.LENGTH_SHORT).show();
                    }
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