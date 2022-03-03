package com.tss.test;

import java.util.ArrayList;
import java.util.List;

import com.tss.pojo.Branch;
import com.tss.pojo.Student;
import com.tss.util.Utility;

public class StudentMain {

	public static void main(String[] args) {
		List<String> firstTypeHobbies = new ArrayList<String>();
		firstTypeHobbies.add(new String("Painting"));
		firstTypeHobbies.add(new String("Gardening"));
		firstTypeHobbies.add(new String("Singing"));

		List<String> secondTypeHobbies = new ArrayList<String>();
		secondTypeHobbies.add(new String("Playing"));
		secondTypeHobbies.add(new String("Listening Music"));

		List<String> thirdTypeHobbies = new ArrayList<String>();
		thirdTypeHobbies.add(new String("Cooking"));
		thirdTypeHobbies.add(new String("Photography"));

		List<Student> cseStudents = new ArrayList<Student>();
		cseStudents.add(new Student(1, "Sravya", 22, firstTypeHobbies));
		cseStudents.add(new Student(4, "Swati", 19, firstTypeHobbies));

		List<Student> mechStudents = new ArrayList<Student>();
		mechStudents.add(new Student(1, "Sravan", 22, thirdTypeHobbies));
		mechStudents.add(new Student(2, "Abhi", 23, secondTypeHobbies));

		List<Student> eceStudents = new ArrayList<Student>();
		eceStudents.add(new Student(1, "Sravani", 22, secondTypeHobbies));
		eceStudents.add(new Student(3, "chandu", 20, thirdTypeHobbies));

		List<Branch> branches = new ArrayList<Branch>();
		branches.add(new Branch("Cse", cseStudents));
		branches.add(new Branch("Mech", mechStudents));
		branches.add(new Branch("Ece", eceStudents));

		System.out.println("All branches of the students information");
		System.out.println(branches);
		System.out.println("");
//		System.out.println("");
		System.out.println("After sorting of the students information based on age in particular branch");
//		System.out.println(Utility.sortingStudentAge(branches));
		System.out.println("");
		System.out.println("Here display the hobby matching list");
		System.out.println(Utility.getStudentsByHobby("Playing", branches));

	}
}
