package com.amdocs.interfacedemo;

public class AddArithmeticOperation implements ArithmeticOperation{

	@Override
	public int mathOperation(int num1, int num2) {
		return num1 + num2;
	}

}
