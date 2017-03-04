package com.springdemo.test;

public abstract class MyClass {
    public int constInt = 5;

    public abstract int method(String str);

    //constInt=constInt+5;
    //public abstract void method(int a);
    public void method() {

    }
}
class ParentA{
    public static void methodstatic(){
        
    }
    public void method(){
        
    }
}
class ChildA extends ParentA{
    @Override
    public native void method();
    
}