package com.tss.collections;

import java.util.ArrayList;
import java.util.List;

public class MultipleListToSingleList {

	public static void main(String[] args) {
		List<String> firstList = new ArrayList<>();
		firstList.add("Jan");
		firstList.add("Feb");
		firstList.add("Mar");

		List<String> secondList = new ArrayList<>();
		secondList.add("Apr");
		secondList.add("May");
		secondList.add("Jun");
		secondList.add("Jul");
		secondList.add("Aug");

		List<String> thirdList = new ArrayList<>();
		thirdList.add("Sep");
		thirdList.add("Oct");
		thirdList.add("Nov");
		thirdList.add("Dec");

		List<String> joinedList = new ArrayList<>();
		joinedList.addAll(firstList);
		joinedList.addAll(secondList);
		joinedList.addAll(thirdList);

		System.out.println(joinedList);

	}

}
