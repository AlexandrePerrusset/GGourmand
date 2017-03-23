package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.infotel.gg.model.ImageData;

public class ImageDataDAO extends AbstractDAO<ImageData, Integer>{

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

	@Override
	public List<ImageData> listAll() {
		return null;
	}

	@Override
	public Integer getId(ImageData obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, ImageData obj) {
		obj.setId(id);
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}
	

	
	
}
