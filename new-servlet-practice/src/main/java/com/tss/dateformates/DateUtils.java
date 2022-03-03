package com.tss.dateformates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tss.util.Utility;
import java.text.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {
	public static final int YEAR = 2022;
	public static final int DATE = 01;

	/**
	 * 
	 * @param strDate
	 * @param format
	 * @return String
	 * @throws ParseException
	 */
	public static String getDate(Date strDate, String format) throws ParseException {
		if (Utility.isBlank(strDate) || Utility.isBlank(format)) {
			return null;
		}
		return new SimpleDateFormat(format).format(strDate);
	}

	/**
	 * 
	 * @param javaStrDate
	 * @param format
	 * @return String
	 * @throws ParseException
	 */
	public static String getStrDate(String javaStrDate, String format, String formatOne) throws ParseException {
		try {
			if (Utility.isBlank(javaStrDate) || Utility.isBlank(format)) {
				return null;
			}
			if(Utility.isBlank(formatOne)) {
				formatOne = "dd-MM-yyyy";
			}
			return new SimpleDateFormat(formatOne).format(new SimpleDateFormat(format).parse(javaStrDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 
	 * @param dataStr
	 * @param date
	 * @return int
	 */
	public static int ageCalculate(String dataStr, String date) {
		if (Utility.isBlank(dataStr) || Utility.isBlank(date)) {
			return 0;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Period age = Period.between(LocalDate.parse(date, formatter), LocalDate.now());
		if (dataStr.equalsIgnoreCase("years")) {
			return (age.getYears());
		} else if (dataStr.equalsIgnoreCase("months")) {
			return ((age.getMonths()) + (age.getYears() * 12));
		} else if (dataStr.equalsIgnoreCase("days")) {
			return ((age.getYears() * 365) + (age.getMonths() * 30) + (age.getDays()));
		}
		return 0;
	}

	/**
	 * 
	 * @param month
	 * @return int
	 */
	public static int getDays(int month) {
		if (Utility.isBlank(month)) {
			return 0;
		}
		return LocalDate.of(YEAR, month, DATE).lengthOfMonth();
	}

	/**
	 * 
	 * @return String
	 */
	public static String calculateTime() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
		System.out.println("Time taken : " + (System.currentTimeMillis() - startTime) + "ms");
		return "";
	}

	/**
	 * @throws ParseException
	 * @return List
	 */
	public static List<Date> getDates(String strDate, String endDate,String format) throws ParseException {
		List<Date> dates = new ArrayList<Date>();
		DateFormat formatter = new SimpleDateFormat(format);
		Date startDate = (Date) formatter.parse(strDate);
		Date endDates = (Date) formatter.parse(endDate);
		long interval = 24 * 1000 * 60 * 60;
		long endTime = endDates.getTime();
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
			dates.add(new Date(curTime));
			curTime += interval;
		}
		return dates;	
	}
   
	/**
	 * 
	 * @param month
	 * @return List
	 */
	public static List<LocalDate> getWeekends(int month) {
		LocalDate firstDateOfTheMonth = LocalDate.now().withMonth(month).with(TemporalAdjusters.firstDayOfMonth());
		List<LocalDate> list = new ArrayList<>();
		for (LocalDate date = firstDateOfTheMonth; !date.isAfter(firstDateOfTheMonth.with(TemporalAdjusters.lastDayOfMonth())); date = date.plusDays(1)) {
			if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				list.add(date);
			}
		}
		return list;
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @return List
	 */
	public static List<LocalDate> getWeekends(int year, int month) {
		LocalDate firstDate = YearMonth.of(year, month).atDay(1);
		List<LocalDate> list = new ArrayList<>();
		for (LocalDate date = firstDate;!date.isAfter(firstDate.with(TemporalAdjusters.lastDayOfMonth())); date = date.plusDays(1)) {
			if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				list.add(date);
			}
		}
		return list;
	}
	
	/**
	 * This method show end day of month in leap year
	 * 
	 * @param year
	 * @return String
	 * @throws ParseException
	 */
	public static String lastDayOfFeb(int year) throws ParseException {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
			Date mydate = format.parse("02-29-" + year);
			format.applyPattern("E, MMM dd yyyy");
			return format.format(mydate);
		} else {
			return "Not a leap year";
		}	
	}
    
	public static void main(String[] args) throws ParseException {
//		System.out.println(DateUtils.getDate(new Date(), FORMAT));
//		System.out.println(DateUtils.getStrDate("11-02-2022", null, "yyyy-dd-MM"));
//		System.out.println(ageCalculate("months", "08-12-2020"));
//		System.out.println(getDays(01));
//		System.out.println(calculateTime());
//		System.out.println(getDates("08/02/2022", "10/02/2022"));
//		System.out.println(DateUtils.getWeekends(2022, 2));
		System.out.println(DateUtils.lastDayOfFeb(2020));
		

	}

}
