package com.applitool.practice;

import java.util.Scanner;

class Count{
	
	static int count;
	public synchronized static  void incCount() {
		
		count ++;
	}
	
	
}

public class test1   {

	public static void main(String args[]) throws InterruptedException {
		
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Enter Text");
		String a =in.nextLine();
		
		System.out.println(a);
		
		
		
		Runnable t1= new synch();
		Runnable t2= new synch1();
		
		
		Thread t3= new Thread(t1);
		Thread t4= new Thread(t2);
		
		t3.start();
		t4.start();
		
		t3.join();
		t4.join();
		
		System.out.println(Count.count);
		
		
		}
	
}

class synch1 implements Runnable  {

		public void run() {
			
			
			for(int i=0;i<1000;i++) {
				
			Count.incCount();
				
				
			}
		}
}




class synch implements Runnable{

	
	
public void run() {
		
		
		for(int i=0;i<1000;i++) {
			
		Count.incCount();
			
			
		}
	}
	
}

