package com.tss.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetAndLinkedHashSet {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>() {
			{
				add("a");
				add("b");
				add("c");
			}
		};

		LinkedHashSet<String> setOne = new LinkedHashSet<String>();
		setOne.add("One");
		setOne.add("Two");
		setOne.add("Three");
		setOne.add("Four");
		setOne.add("Five");

		System.out.println(set);
		System.out.println(setOne);
	}

}
