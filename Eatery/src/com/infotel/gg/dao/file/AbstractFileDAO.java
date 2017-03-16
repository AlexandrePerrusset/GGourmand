package com.infotel.gg.dao.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


import com.infotel.gg.dao.DAO;


public abstract class AbstractFileDAO<T,K> implements DAO<T,K> {
	@Override
	public void create(T obj) {
		
		String filename = elementToFileName(obj);
		
		try(
			OutputStream file = new FileOutputStream(filename);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);	
		){
			output.writeObject(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public T read(K i) {
		T obj = null;
		String filename = idToFileName(i);
		
		try(
			InputStream file = new FileInputStream(filename);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);	
		){
			obj = (T) input.readObject();
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return obj;
	
	}

	@Override
	public void update(T obj) {
	}

	@Override
	public void delete(T obj) {
	}

	@Override
	public void deleteById(K id) {
	}
	
	public String elementToFileName(T element){
		StringBuilder sb = new StringBuilder();
//		sb.append(System.getProperty("user_home"));
//		sb.append(System.getProperty("file.separator"));
		sb.append(element.getClass().getSimpleName().toLowerCase());
		sb.append("_");
		sb.append(getId(element));
		sb.append(".ser");
		return sb.toString();
	}
	
	public abstract String idToFileName(K i);

	
}
