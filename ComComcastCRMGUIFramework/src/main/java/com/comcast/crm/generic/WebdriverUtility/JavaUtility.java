package com.comcast.crm.generic.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random ranD = new Random();
		int num = ranD.nextInt(2000);
		return num;
	}
	
	public String getDateYYYYMMDD()
	{
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(d);
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String rdate = sim.format(cal.getTime());
		return rdate;
	}

}
