package com.infotel.gg.exception;

public class ModelException extends Exception{
	
	private String str;
	public ModelException(String str){
		this.str = str;
	}

}
