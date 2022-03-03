package com.tss.main;

public class InbuiltMethods {

	public static void main(String[] args) {
	  //charAt()
	  String myStr = "Hello";
	  char result = myStr.charAt(0);
	  System.out.println(result);
	  
	  //codePointAt()
	  int resultOne = myStr.codePointAt(0);
	  System.out.println(resultOne);
	  
	  //codePointBefore
	  int resultTwo = myStr.codePointBefore(2);
	  System.out.println(resultTwo);
	  
	  //codePointCount
	  int resultThree = myStr.codePointCount(2,4);
	  System.out.println(resultThree);
	  
	  //compareTo()
	  String Str1 = "Hello";
	  String Str2 = "hello";
	  System.out.println(Str1.compareTo(Str2));
	  System.out.println(Str1.compareToIgnoreCase(Str2));
	  
	  //concat()
	  System.out.println(Str1.concat(Str2));
	  
	  //contains()
	  System.out.println(Str1.contains("Hell"));
	  
	  //equals()
	  System.out.println(Str1.equals(Str2));
	  System.out.println(Str1.equalsIgnoreCase(Str2));
	  
	  //endsWith()
	  System.out.println(Str1.endsWith("H"));
	}

}