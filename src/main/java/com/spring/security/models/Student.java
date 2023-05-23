package com.spring.security.models;

public class Student implements Comparable<Student> {

	private String id;
	private String firstName;
	private String lastName;
	private int rank;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public Student(String firstName, String lastName, int rank) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rank=" + rank + "]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.firstName.compareTo(o.getFirstName());
	}
}
