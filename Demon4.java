package InterviewTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demon4 {
    //    一.交换字符使得字符串相同
//    有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
//
//    每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
//    交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，
//    但不能交换 s1[i] 和 s1[j]。
//
//    最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。

//    输入：s1 = "xx", s2 = "yy"
//    输出：1
//    解释：
//    交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。

    public int minimumSwap(String s1, String s2) {
        //数量不同，自然无法弄成一样
        if(s1.length() != s2.length()){
            return -1;
        }
        int cen1 = 0;  //记录第一个字符串不相同x的数量
        int cen2 = 0;  //记录第一个字符串不相同y的数量

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(s1.charAt(i) == 'x'){
                    cen1++;
                }else{
                    cen2++;
                }
            }
        }

        //当不相同的x和y数量为奇数，无法弄成一样。
        if((cen1 + cen2) % 2 == 1){
            return -1;
        }
        cen1 = (cen1 % 2 == 0)? cen1 / 2 : cen1 / 2 + 1;
        cen2 = (cen2 % 2 == 0)? cen2 / 2 : cen2 / 2 + 1;
        return cen1 + cen2;
    }
//    二.缀点成线
//
//    在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y]
//    表示横坐标为 x、纵坐标为 y 的点。
//
//    请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
//
//    输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//    输出：true

    public boolean checkStraightLine(int[][] coordinates) {
        int k1 = coordinates[1][0] - coordinates[0][0];
        int k2 = coordinates[1][1] - coordinates[0][1];

        // 斜率公式 = (y2 - y1) / (x2 - x1) = (y3 - y2) / (x3 - x2)
        //         = (y2 - y1) * (x3 - x2) = (x2 - x1) * (y3 - y2)
        for(int i = 1; i < coordinates.length; i++){
            if((coordinates[i][0] - coordinates[i - 1][0]) *  k2 != (coordinates[i][1] - coordinates[i - 1][1]) * k1){
                return false;
            }
        }
        return true;
    }
//   二.删除子文件夹
//    你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
//
//    我们这样定义「子文件夹」：
//
//    如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
//    文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
//
//            / 后跟一个或者多个小写英文字母。
//    例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
//
//    输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//    输出：["/a","/c/d","/c/f"]
//    解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        //得到的新数组肯定满足:
        //1.第一个肯定是父文件夹
        //2.然后去遍历数组,找和他匹配的就是子文件夹
        //3.不匹配则就是新的父文件夹.继续遍历
        List<String> result = new ArrayList<>();
        //获取第一个父文件.
        String tem = folder[0];
        int len = tem.length() + 1;  //给父文件夹加上‘/’ 看后面字符串是否相等,相等就是子文件夹,不相等就是新的
        result.add(tem);
        for(int i = 1; i < folder.length; i++){
            //先去比长度,再去实际比较.
            if(folder[i].length() < len || !((tem + '/').equals(folder[i].substring(0,len)))){
                tem = folder[i];
                result.add(tem);
                len = tem.length() + 1;
            }
        }
        return result;
    }

//    三. 分割平衡字符串
//    在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//
//    给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//
//    返回可以通过分割得到的平衡字符串的最大数量。
//
//    输入：s = "RLRRLLRLRL"
//    输出：4
//    解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。

    public int balancedStringSplit(String s) {
        int count = 0; //来记录每次的更新
        int amount = 0; //记录最大分割数

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //无论看见'L'++还是'R'-- 最终都会相互匹配 算一次。
            if(c == 'R'){
                count++;
            }
            if(c == 'L'){
                count--;
            }
            if(count == 0){
                amount++;
            }
        }
        return amount;
    }
}
