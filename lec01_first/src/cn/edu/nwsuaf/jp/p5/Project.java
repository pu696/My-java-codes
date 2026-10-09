package cn.edu.nwsuaf.jp.p5;

import java.time.LocalDate;
import java.util.*;

public class Project {
	private static List<Employee> employees = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入拿固定工资的人数：");
    	Scanner scanner = new Scanner(System.in);
    	int a1 = scanner.nextInt();
    	System.out.println("请输入拿无固定底薪的人数：");
    	int a2 = scanner.nextInt();
    	System.out.println("请输入拿有固定底薪的人数：");
    	int a3 = scanner.nextInt();
    	System.out.println("请输入打小时工的人数：");
    	int a4 = scanner.nextInt();
    	boolean running = true;
        while (running) {
        	printMenu();
        	int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                	    for(int i = 1;i<=a1;i++) {
                	    System.out.println("请输入第" + i + "个员工姓名：");
                        String name = scanner.nextLine();
                        System.out.println("请输入第" + i + "个员工出生月份：");
                        int month = scanner.nextInt();
                        System.out.println("请输入第" + i + "个员工月薪：");
                        double salary = scanner.nextDouble();
                        scanner.nextLine(); 
                        LocalDate birthday = LocalDate.of(1990,month,1);
                        employees.add(new SalariedEmployee(name, birthday, salary));
                		}
                    break;
                case 2:
                	for(int i = 1;i<=a2;i++) {
                	System.out.println("请输入第" + i + "个员工姓名：");
                    String name = scanner.nextLine();
                    System.out.println("请输入第" + i + "个员工出生月份：");
                    int month = scanner.nextInt();
                    System.out.println("请输入第" + i + "个员工销售额：");
                    double sale = scanner.nextDouble();
                    scanner.nextLine();                     
                    LocalDate birthday = LocalDate.of(1990,month,1);
                    double commissionRate = 0;
                    employees.add(new SaleEmployee(name,birthday,sale,commissionRate));
                	}
                    break;
                case 3:
                	for(int i = 1;i<=a3;i++) {
                	System.out.println("请输入第" + i + "个员工姓名：");
                    String name = scanner.nextLine();                    
                    System.out.println("请输入第" + i + "个员工出生月份：");
                    int month = scanner.nextInt();                 
                    System.out.println("请输入第" + i + "个员工销售额：");
                    double sale = scanner.nextDouble();
                    System.out.println("请输入第" + i + "个员工底薪：");
                    double baseSalary = scanner.nextDouble();
                    scanner.nextLine(); 
                    LocalDate birthday = LocalDate.of(1990,month,1);
                    double commissionRate = 0;
                    employees.add(new BasePlusSalesEmployee(name,birthday,baseSalary,sale,commissionRate));
                }
                    break;
                case 4:
                	for(int i = 1;i<=a4;i++) {
                	System.out.println("请输入第" + i + "个员工姓名：");
                    String name = scanner.nextLine();                  
                    System.out.println("请输入第" + i + "个员工出生月份：");
                    int month = scanner.nextInt();                   
                    System.out.println("请输入第" + i + "个员工小时工资：");
                    double hourSalary = scanner.nextDouble();                   
                    System.out.println("请输入第" + i + "个员工工作小时数：");
                    double hours = scanner.nextDouble();
                    scanner.nextLine(); 
                    LocalDate birthday = LocalDate.of(1990,month,1);
                    employees.add(new HourlyEmployee(name,birthday,hourSalary,hours));
                	}
                    break;
                case 5:
                	System.out.println("员工工资表：");
                    for (Employee employee : employees) {
                        double salary = employee.getSalary(employee);
                        System.out.println("员工姓名：" + employee.getName() + "       员工薪资：" + salary);
                    }
                	break;
                default:
                    System.out.println("无效选项，请重新选择！");
            }
        }
        scanner.close();
	}
	private static void printMenu() {
        System.out.println("***欢迎使用员工工资管理系统****");
		System.out.println("*************************");
        System.out.println("0-退出         1-固定工资员工");
        System.out.println("2-无固定底薪    3-有固定底薪");
        System.out.println("4-小时工       5-打印工资表");
        System.out.println("请输入选项："); 
	}
}

