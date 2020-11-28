package com.keyboardknight.androidhomework5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button backwardsButton = (Button)findViewById(R.id.register_backwards_button_1);
        backwardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(RegisterActivity.this,"返回",Toast.LENGTH_SHORT).show();

                Intent backwardsIntent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(backwardsIntent);

            }
        });



        Button registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText act = findViewById(R.id.register_account_input_box);
                String account = act.getText().toString();
                EditText psw = findViewById(R.id.register_password_input_box);
                String password = psw.getText().toString();
                EditText psw_cfm = findViewById(R.id.register_password_input_box);
                String password_confirmation = psw_cfm.getText().toString();
                if(account.isEmpty()) {
                    Toast.makeText(RegisterActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                }
                else if(account.length()>15){
                    Toast.makeText(RegisterActivity.this,"账号过长，请重新输入。",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.length()<8){
                        Toast.makeText(RegisterActivity.this,"密码过短，请重新输入。",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(!password_confirmation.equals(password)){
                            Toast.makeText(RegisterActivity.this,"两次输入的密码不一致，请重新输入！",Toast.LENGTH_SHORT).show();
                        }
                        else{

                            Intent registeredToMain = new Intent(RegisterActivity.this,MainActivity.class);
                            registeredToMain.putExtra("account",account);
                            registeredToMain.putExtra("password",password);
                            Toast.makeText(RegisterActivity.this,"恭喜您，注册成功\n账号："+account+"\n密码："+password,Toast.LENGTH_LONG).show();
                            startActivity(registeredToMain);
                        }
                    }
                }

            }

        });
    }

}