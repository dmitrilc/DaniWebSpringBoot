package com.school.app.pojos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	private final String name;
	private final Grade grade;
	
	public Student(
			@JsonProperty("name")String name,
			@JsonProperty("grade")Grade grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public Grade getGrade() {
		return grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return grade == other.grade && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}

}
