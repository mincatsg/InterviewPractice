import java.util.*;

public class test41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            int len = input.length();
            int i = 0, j = len -1;
            int end = j;
            while (i <= j) {
                if (input.charAt(i) == input.charAt(j)) {
                    i++;
                    j--;
                }else {
                    i = 0;
                    j--;
                    end = j;
                }
            }
            System.out.println(end +1);
        }
        in.close();
    }
}