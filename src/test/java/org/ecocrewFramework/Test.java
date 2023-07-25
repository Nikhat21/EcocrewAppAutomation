package org.ecocrewFramework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;

public class Test {
	
	public static void main(String[] args) {
		 String string = "25 Jul 2023";
		 
//		 Date date = new Date();
//		 Date nextDate = DateUtils.addDays(date, 1);
	       String sss="25-07-2023,TUESDAY";
	        DateTimeFormatter format
	            = DateTimeFormatter.ofPattern("d MMM yyyy");	           
	       
	 	    	LocalDate date = LocalDate.parse(string, format);
	 	    	String aa=date.toString();
	            System.out.println(aa);
	            
	          
	            String date1 =  LocalDate.parse( aa ).format(DateTimeFormatter.ofPattern( "dd-MM-uuuu" ));
	            System.out.println(date1);
	            
	            java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();
	        
	            String day=dayOfWeek.toString();
	            System.out.println("Day of week in text:"+day);
	            
	           String amma=date1.concat(","+day);
	           
	           System.out.println("Day of week in text:"+amma);
	           if(sss.equalsIgnoreCase(amma)) {
	        	   System.out.println("ggggg");
	           }else {
	        	   System.out.println("jjjj");
	           }
	          
	            
	          
	           // ("d MMM yyyy"); 
	            
	       
}

	
}
