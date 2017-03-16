package com.infotel.gg.execption;

public class DAOException extends Exception{
	
	private String str;
	public DAOException(String str){
		this.str = str;
	}
	
}
