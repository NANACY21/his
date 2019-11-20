package com.personal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils {
	public static  Date parse(String strDate) throws ParseException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        return sdf.parse(strDate);  
    }
	
	 public static  int getAges(Date birthDay) throws Exception{  
	        Calendar cal = Calendar.getInstance();  
	  
	        if (cal.before(birthDay)) {  
	            throw new IllegalArgumentException("出生日期小于当前时间，无效的日期!");  
	        }
	        int yearNow = cal.get(Calendar.YEAR);  
	        int monthNow = cal.get(Calendar.MONTH);  
	        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
	        cal.setTime(birthDay);  
	  
	        int yearBirth = cal.get(Calendar.YEAR);  
	        int monthBirth = cal.get(Calendar.MONTH);  
	        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
	  
	        int age = yearNow - yearBirth;  
	  
	        if (monthNow <= monthBirth) {  
	            if (monthNow == monthBirth){  
	                if (dayOfMonthNow < dayOfMonthBirth) 
	                age--;  
	            }else{  
	                age--;  
	            }  
	        }  
	        return age;  
	    }
}
