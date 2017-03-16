package com.infotel.gg.exception;

public class DAOException extends Exception{
	
	private String str;
	public DAOException(String str){
		this.str = str;
	}
	
}
