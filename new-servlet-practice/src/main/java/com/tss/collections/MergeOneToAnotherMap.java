package com.tss.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeOneToAnotherMap {
	public static void main(String[] args) {
		Map<Integer, String> mapOne = new HashMap<>();
		mapOne.put(1, "A");
		mapOne.put(2, "B");
		mapOne.put(3, "C");
		mapOne.put(5, "E");

		Map<Integer, String> mapTwo = new LinkedHashMap<>();
		mapTwo.put(1, "A");
		mapTwo.put(2, "B");
		mapTwo.put(3, "C");
		mapTwo.put(4, "D");

		mapOne.putAll(mapTwo);

		System.out.println(mapOne);
	}

}
