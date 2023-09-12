package com.amdocs.interfacedemo.twowithlamda;

/**
 * Funtional interface(lamda expression can only work with functional interface)
 * i,e,. interface having only one abstract method
 */

public interface ArithmeticOperation {
	
	int mathOperation(int num1, int num2) ;
	
	//if we create this function then it will give error.
//	int mathOperation1(int num1, int num2) ;
	
	default void hi() {
		System.out.println("Hello");
	}
	
	static void bye() {
		System.out.println("bye-bye");
	}

}
