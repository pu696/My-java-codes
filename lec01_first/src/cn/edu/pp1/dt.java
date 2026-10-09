package cn.edu.pp1;

import java.time.*;
import java.util.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
public class dt {
        public static void main(String[] args){
            // TODO Auto-generated method stub
        	Scanner scanner = new Scanner(System.in);
            System.out.println("请输入年月日时分秒（输入格式：yyyy-mm-dd hh:MM:ss）");
            String input = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime inputDateTime = LocalDateTime.parse(input, formatter);
            LocalDateTime now = LocalDateTime.now();
  
            Duration duration = Duration.between(inputDateTime, now);
            
            long days = duration.toDays();
            long hours = duration.toHours() % 24;
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;
            
            System.out.printf("运行结果：相差%d天%d时%d分%d秒\n", days, hours, minutes, seconds);
        }
}