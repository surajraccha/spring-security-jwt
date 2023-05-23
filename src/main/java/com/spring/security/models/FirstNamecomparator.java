package com.spring.security.models;

import java.util.Comparator;

public class FirstNamecomparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
