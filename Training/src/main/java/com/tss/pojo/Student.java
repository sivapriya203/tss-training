package com.tss.pojo;

import java.util.List;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private int age;
	private List<String> hobbies;

	public Student(int id, String name, int age,List<String> hobbies) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public int getId() {
		return id;
	}

	public void setId(int studentId) {
		this.id = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student student) {
		// TODO Auto-generated method stub
		return this.age - student.getAge();
	}

	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", hobbies=" + hobbies + "]";
	}

	


}
