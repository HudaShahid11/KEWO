package com.kewo.huda;

import android.content.Context;
import android.content.SharedPreferences;


public class Session {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public Session(Context context) {
        sharedPreferences=context.getSharedPreferences("appkey",0);
        editor = sharedPreferences.edit();
        editor.commit();
    }
    public void setlogin(Boolean login){
        editor.putBoolean("key_kogin",login);
        editor.commit();
    }
    public boolean getlogin(){
        return sharedPreferences.getBoolean("key_login",false);
    }
    public void setemail(String user){
        editor.putString("key_email",user);
        editor.commit();
    }
    public String getemail(){
        return sharedPreferences.getString("key_email","");
    }

    public void setid(String id){
        int Id = Integer.parseInt(id);
        editor.putInt("key_id",Id);
        editor.commit();
    }
    public int getid(){
        return sharedPreferences.getInt("key_id",0);
    }
    public String getIdInString(){
        return String.valueOf(sharedPreferences.getInt("key_id",0));
    }

    public void setcnic(String cnic){
        editor.putString("key_cnic",cnic);
        editor.commit();
    }
    public String getcnic(){
        return sharedPreferences.getString("key_cnic","");
    }


    public void setphone(String phone){
        editor.putString("key_phone",phone);
        editor.commit();
    }
    public String getphone(){
        return sharedPreferences.getString("key_phone","");
    }
}