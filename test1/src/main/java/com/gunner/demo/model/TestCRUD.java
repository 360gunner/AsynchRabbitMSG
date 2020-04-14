package com.gunner.demo.model;

public class TestCRUD {
	
	Test test;
	
	HTTPTYPE type;
	
	public TestCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestCRUD(Test test, HTTPTYPE type) {
		super();
		this.test = test;
		this.type = type;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public HTTPTYPE getType() {
		return type;
	}

	public void setType(HTTPTYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TestCRUD [test=" + test + ", type=" + type + "]";
	}
	
}
