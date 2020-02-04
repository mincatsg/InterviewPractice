package Map;

import java.util.ArrayList;
import java.util.List;

public class Fuzzycoordinates {
//    我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
////
////    原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
////
////    最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。

    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList<>();
        for(int i = 2; i < S.length() - 1; i++){
            for(String left : make(S, 1, i)){
                for(String right : make(S, i, S.length() - 1)){
                    ans.add("(" + left + ", " + right + ")");
                }
            }
        }
        return ans;
    }
    public List<String> make(String S, int i, int j){
        List<String> ans = new ArrayList<>();
        for(int d = 1; d <= j - i; d++){
            String left = S.substring(i, i + d);
            String right = S.substring(i + d, j);
            if((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")){
                ans.add(left + ((d < j - i)? "." : "") + right);
            }
        }
        return ans;
    }
}
