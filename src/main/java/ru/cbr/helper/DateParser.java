package ru.cbr.helper;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser {
	
	private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date getDate(String value) {
		if (value == null || value.isEmpty())
			return null;
		
		try {
			java.util.Date date = sdf.parse(value);
			Date date1 = new java.sql.Date(date.getTime());
			return date1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
