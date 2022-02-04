package com.tss.main;

import com.tss.util.Utility;

public class StringOperations {

	public static void main(String[] args) {
		String data = "This is sample <<message>> end and my <<order>> number is: AP1025658, \r\n"+
				"This is with {{data: {a }} name:naresh \r\n"+
				"my ticket: AP12345 \r\n"+
			"email:any@123.com \r\n "+
			"reason:<some reason \r\n"+
			"name:test, to find> other \r\n"+
			" test with {{name: xyz}} \r\n"+
		    "{{name: abc}}";
		

		System.out.println(Utility.typeA(data, "<<", ">>"));
		// System.out.println(Utility.typeB(data, "", "start"));
		// System.out.println(Utility.typeC(data, "with","any","", ""));
		System.out.println(Utility.camelCase("hii sivapriya"));
		System.out.println(Utility.pascalCase("hii sivapriya"));
		System.out.println(Utility.titleCase("hii sivapriya"));

	}

}
