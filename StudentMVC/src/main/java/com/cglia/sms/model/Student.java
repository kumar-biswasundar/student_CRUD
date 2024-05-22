package com.cglia.sms.model;

public class Student {
	    private int rollNo;
	    private String name;
	    private int age;
	    private String department;
		
		
		public Student(int rollNo, String name, int age, String department) {
			super();
			this.rollNo = rollNo;
			this.name = name;
			this.age = age;
			this.department = department;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getRollNo() {
			return rollNo;
		}
		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
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
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		@Override
		public String toString() {
			return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", department=" + department + "]";
		}
	     
}


