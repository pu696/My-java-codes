package cn.edu.pp4;

public class Main5 {
    public static void main(String[] args) {
        long start = 2022;
        long end = 2022222022;
        int count = 0;
        
        for (long i = start; i <= end; i++) {
            if (isMountainNumber(i)) {
                count++;
            }
        }
        
        System.out.println("在区间 [2022, 2022222022] 中山形数的个数: " + count);
    }
    
    static boolean isMountainNumber(long num) {
        String str = String.valueOf(num);
        int n = str.length();
        
        if (!isPalindrome(str)) {
            return false;
        }
        
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}