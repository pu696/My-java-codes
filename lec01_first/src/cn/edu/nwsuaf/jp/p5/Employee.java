package cn.edu.nwsuaf.jp.p5;

import java.time.*;
public abstract class Employee {
	protected String name;
	protected LocalDate birthday;
	public abstract double getSalary(Employee e);
	public double getSalarybyBrith(int a) {
		double tep = 0;
		int month = birthday.getMonthValue();
		if(month == a) {
			tep = 1;
		}
		return tep;
	}
	public Employee() {
		super();
	}
	public Employee(String name, LocalDate birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
