package cn.edu.utils;
import java.util.Arrays;
public class ArraysUtils {
public static void sort(Object[] t) {
ResponseEnum re = ResponseEnum.NULLPOINT ;
/**
* 使用枚举 ResponseEnum 定义变量，并判断当 t 为空时，输出"对象不能为空!!"(ResponseEnum 中
message 值) */
 assert t != null : 
    re.getMessage();
Arrays.sort(t);
}
}
