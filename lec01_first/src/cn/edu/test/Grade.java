package cn.edu.test;
public class Grade {
public static String getGrade(int score) throws InputException {
String grade = null ;
 if(score<0 || score >100){
	throw new InputException("你输入的成绩不合法！！");
}
if(score>90){
grade = "优秀";
}
else if(score>=80){
grade = "良好";
}else if(score>=70){
grade = "一般";
}else if(score>=60){
grade = "及格";
}else if(score<60){
grade = "不及格";
}
return grade;
}
}
