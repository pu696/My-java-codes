package cn.edu.nwsuaf.jp.p5;

import java.time.*;
public class SaleEmployee extends Employee{
	protected double sale;
	protected double commissionRate;
	public SaleEmployee(String name, LocalDate birthday,double sale, double commissionRate) {
		super(name,birthday);
		this.sale = sale;
		if(this.sale<=30000) {
			this.commissionRate=0.05;
		}
		else {
			this.commissionRate=0.08;
		}
	}
	@Override
	public double getSalary(Employee e) {
		// TODO Auto-generated method stub
		double monthSalary=0;
		double otherSalary=-900.0;
		LocalDate a = e.getBirthday();
		int b = a.getMonthValue();
		double c = e.getSalarybyBrith(b);
		   if(c != 0) {
		    monthSalary=sale*commissionRate+otherSalary;
		    }
		    else {
			 monthSalary =sale*commissionRate;
		    }
		return monthSalary;
	}
}
