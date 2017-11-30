package com.lamdaexp3;

public enum QualEnum {
	
	TEN(10),TWE(12),BSC(15),MCA(18);
	
	private int value;
	
	public int getValue() {
		return value;
	}

	QualEnum(int value)
	{
    this.value=value;
		
		
	}
	
}
