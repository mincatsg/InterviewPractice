package NKTest;

import java.util.Scanner;

public class NStatisticalPalindrome {

//    统计回文

        public static String build(String A, String B, int index){
            String newAB;
            if(index != A.length()){
                newAB = A.substring(0, index) + B + A.substring(index);
            }else{
                newAB = A.substring(0, index) + B;
            }
            return newAB;
        }
        public static boolean jude(String newAB){
            int left = 0;
            int right = newAB.length() - 1;
            while(left < right){
                if(newAB.charAt(left) != newAB.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String A = scanner.next();
            String B = scanner.next();
            int count = 0;
            for(int i = 0; i <= A.length(); i++){
                String newAB = build(A, B, i);
                if(jude(newAB)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

