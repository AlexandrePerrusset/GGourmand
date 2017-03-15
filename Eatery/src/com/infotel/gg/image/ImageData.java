package com.infotel.gg.image;

import com.infotel.gg.dao.jdbc.Identifiable;

public class ImageData implements Identifiable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4072087939439076750L;
	private long id;
	private byte[] content;
	private String target;
	private int targetId;
	private String size;
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
