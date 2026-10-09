package cn.edu.nwsuaf.jp.p5;

import java.time.*;
public class HourlyEmployee extends Employee{
	private double hourSalaries;
	private double hours;
	public HourlyEmployee(String name,LocalDate birthday,double hourSalaries,double hours) {
		super(name,birthday);
		this.hourSalaries = hourSalaries;
		this.hours = hours;
	}
	
	@Override
	public double getSalary(Employee e) {
		// TODO Auto-generated method stub
		double monthSalary=0;
		double otherSalary=100.0;
		LocalDate a = e.getBirthday();
		int b = a.getMonthValue();
		double c = e.getSalarybyBrith(b);
		if(hours>160) {
			hours = 1.5 * hours;
		   if(c != 0) {
		   monthSalary = hourSalaries * hours + otherSalary;
		    }
		    else {
			monthSalary = hourSalaries * hours;
		    }
		}
		return monthSalary;
	}
}
