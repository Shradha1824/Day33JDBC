package com.jdbc;

import java.time.LocalDate;

public class EmployeePayrollData {
	
	public int id;
	public String name;
	public LocalDate startDate;
	public double basic_pay;
	
	public EmployeePayrollData(int id, String name, double salary) {
		// TODO Auto-generated constructor stub
	this.id = id;
	this.name = name;
	this.basic_pay = basic_pay;
	
	}
	public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
	this(id,name,salary);
	this.startDate = startDate;
	}
	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", basic_pay =" + basic_pay + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)return true;
		if (o == null || getClass() != o.getClass()) return false;
		return false;
	
	}
}