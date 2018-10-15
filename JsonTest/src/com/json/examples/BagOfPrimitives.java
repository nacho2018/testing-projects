package com.json.examples;

public class BagOfPrimitives {

	  private int value1 = 1;
	  private String value2 = "abc";
	  
	  private Integer value3 = null;
	  
	  private Boolean value4 = null;
	  
	  public boolean isValue4() {
		return value4;
	}

	public void setValue4(boolean value4) {
		this.value4 = value4;
	}

	public BagOfPrimitives() {}
	  
	  public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	

	public Integer getValue3() {
		return value3;
	}

	public void setValue3(Integer value3) {
		this.value3 = value3;
	}

	public String toString(){
		  
		  return "value1: " + this.value1 + " value2: " + this.value2
				  + " value3: " + this.value3 + " value4: " + (this.value4 != null ? this.value4.booleanValue() : "null");
	  }
}
