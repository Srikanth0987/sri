package com.stringutil;

public enum FileFormat 
{
	
	PDF(".pdf",1),word(".doc",2),Excel(".xls",3);
	
   private FileFormat(String name, int value)
   {
		this.name = name;
		this.value = value;
	}

private String name;
	
	public String getName() {
	return name;
}

public int getValue() {
	return value;
}

	private int value;
	
}
