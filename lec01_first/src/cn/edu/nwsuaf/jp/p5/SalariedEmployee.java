package cn.edu.nwsuaf.jp.p5;

import java.time.*;
public class SalariedEmployee extends Employee{
	private double monthSalary;
	public SalariedEmployee(String name, LocalDate birthday,double monthSalary) {
		super(name,birthday);
		this.monthSalary = monthSalary;
	}
	@Override
	public double getSalary(Employee e) {
		return monthSalary;
	}
}
