package com.examweb.examHelper;

public class ExamUserFoundException extends Exception {

	public ExamUserFoundException() {
		super("user with this name is alrady in Data Base !!! try with  other user name");
	}
	
	public ExamUserFoundException(String msg) {super(msg);}
}
