package com.infotel.gg.exception;

public class UserException extends Exception{
	
	private String str;
	public UserException(String str){
		this.str = str;
	}
	
}
