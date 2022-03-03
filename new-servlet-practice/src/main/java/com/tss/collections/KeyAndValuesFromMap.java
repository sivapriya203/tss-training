package com.tss.collections;

import java.util.HashMap;
import java.util.Map;

public class KeyAndValuesFromMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("India", 1);
		map.put("USA", 2);
		map.put("Germany", 3);

		System.out.println(map.values());
		System.out.println(map.keySet());
	}

}
