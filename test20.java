public class test20 {
    //给定两个二进制字符串，返回他们的和（用二进制表示）。
    //输入为非空字符串且只包含数字 1 和 0。

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
            int sum = ca;
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum +=  ((j >= 0) ? b.charAt(j) - '0' : 0);
            ans.append(sum % 2);
            ca = sum / 2;
        }

        ans.append(ca == 0 ? "" : '1');
        return ans.reverse().toString();
    }
}
