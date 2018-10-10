package com.applitool.practice;

public class B extends A {

	public void m1() {

		System.out.println("overriden m1");
	}

	public void m2() {

		System.out.println("overridden m2");
	}

	public void m3() {

		System.out.println("B---->m3");
	}



public static void main(String args[]) {
	
	B b= new B();
	A a= new A();
	
A a1 =new B();
a.m1();
a1.m1(); // top casting --Run time polymorphism
	
b.m0(); //Static Polymorphism
}



}
