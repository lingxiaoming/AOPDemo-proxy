package com.zyy.aopdemo_proxy;

import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Proxy;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ILogin {
    private ILogin proxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proxy = (ILogin)Proxy.newProxyInstance(getClassLoader(), new Class[]{ILogin.class}, new MyInvokeHandler(this));


    }


    public void onClick(View view) {
        proxy.go();
    }

    @Override
    public void go() {
        System.out.println("invoke going");
    }


}


interface ILogin{
    void go();
}
