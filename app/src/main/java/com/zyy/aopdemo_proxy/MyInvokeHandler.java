package com.zyy.aopdemo_proxy;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokeHandler implements InvocationHandler {
    private Context mContext;
    private Object mObject;

    MyInvokeHandler(Object object){
        mContext = (Context)object;
        mObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        System.out.println("invoke before");
        invoke = method.invoke(mObject, args);
        System.out.println("invoke after");
        return invoke;
    }
}
