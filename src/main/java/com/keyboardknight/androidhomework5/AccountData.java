package com.keyboardknight.androidhomework5;

public class AccountData {
    private static String account;
    private String password;

    public void setAccount(String str){
        account=str;
    }

    public void setPassword(String str){
        password=str;
    }

    public String getAccount()
    {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
