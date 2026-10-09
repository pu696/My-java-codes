package cn.edu.pp3;

public class Main {
    public static void main(String[] args) {
        int num = 2023;
        
        while (true) {
            String hex = Integer.toHexString(num);
            // 检查是否包含数字
            if (!containsDigit(hex)) {
                System.out.println("最小数是: " + num);
                System.out.println("16进制为: " + hex);
                break;
            }
            num++;
        }
    }
    
    // 检查字符串是否包含数字字符
    static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
}


