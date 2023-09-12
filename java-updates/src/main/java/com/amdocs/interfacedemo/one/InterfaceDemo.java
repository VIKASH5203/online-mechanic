package com.amdocs.interfacedemo.one;

public class InterfaceDemo {

	public static void main(String[] args) {
		
		//we can define the funtion in this anynomous class ie Interface demo here.
		
		ArithmeticOperation add= new ArithmeticOperation() {
			
			@Override
			public int mathOperation(int num1, int num2) {
				return num1 + num2;
			}
		};
		System.out.println(add.mathOperation(10, 20));
		
		ArithmeticOperation subs=new ArithmeticOperation() {
			
			@Override
			public int mathOperation(int num1, int num2) {
				return num1 - num2;
			}
		};
		System.out.println(add.mathOperation(100, 20));
	}

}
