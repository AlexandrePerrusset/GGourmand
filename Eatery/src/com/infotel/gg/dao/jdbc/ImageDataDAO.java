package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.infotel.gg.image.ImageData;

public class ImageDataDAO extends AbstractDAO<ImageData>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "image_data";
	}

	@Override
	public ImageData getModelObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdate(ImageData obj) {
		return null;
	}

	@Override
	public String getInsert(ImageData obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, ImageData obj) {
	}

	
	
}
