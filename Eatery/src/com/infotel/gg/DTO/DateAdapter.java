
package com.infotel.gg.DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Calendar> {

	 static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	 @Override
	 public Calendar unmarshal(String date) throws Exception
	 {
	  Calendar calendar = Calendar.getInstance();
	  calendar.setTime(df.parse(date));
	  return calendar;
	 }
	 
	 @Override
	 public String marshal(Calendar calendar) throws Exception
	 {
	  return df.format(calendar.getTime());
	 }

	 }




	
	


