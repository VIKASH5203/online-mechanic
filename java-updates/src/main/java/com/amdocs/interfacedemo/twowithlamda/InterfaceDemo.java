package com.amdocs.interfacedemo.twowithlamda;

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
		
		//we can define the above function for multiplication like below
		ArithmeticOperation mul = (int num1, int num2) -> {
			return num1 * num2;
			};
		System.out.println(mul.mathOperation(6, 4));
		
		//if single statement -no need to write return,,and data type is also not required
		ArithmeticOperation div = ( num1, num2) -> num1 / num2;
		System.out.println(mul.mathOperation(6, 4));
		
		
	}

}
