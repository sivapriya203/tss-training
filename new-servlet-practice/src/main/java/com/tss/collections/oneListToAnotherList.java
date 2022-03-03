package com.tss.collections;

import java.util.ArrayList;
import java.util.List;

public class oneListToAnotherList {

	public static void main(String[] args) {
		List<String> firstList = new ArrayList<>();
		firstList.add("Sivapriya");
		firstList.add("Kavya");
		firstList.add("Nikhil");
		firstList.add("Haripriya");
		firstList.add("Vamsi");
		
		List<String> joinedList = new ArrayList<>();
		joinedList.addAll(firstList);
		
		System.out.println(joinedList);

	}

}
