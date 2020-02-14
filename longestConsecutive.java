package InterviewTraining;

import java.util.Scanner;

public class longestConsecutive {
    //    字符串中找出连续最长的数字串
//    在一行内输出str中里连续最长的数字串
    public void findMath() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = 0;
        int tep = 0;
        int index = 0;
        int index1 = 0;
        for (int i = 0; i < s.length(); i++) {
            index = i;
            while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                tep++;
                i++;
            }
            if
            (tep > count) {
                index1 = index;
                count = tep;
            }
            tep = 0;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(s.charAt(index1 + i));
        }
    }
}
