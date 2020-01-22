public class test21 {
    //请你来实现一个 atoi 函数，使其能将字符串转换成整数。

    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();  //trim()的作用是去掉字符串两端的多余的空格，注意，是两端的空格，且无论两端的空格有多少个都会去掉，当然中间的那些空格不会被去掉
        if (str.length() == 0) return 0;
        int i = 0;
        //2.判断数字的符号
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for (; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                break;
            //溢出判断
            if (flag > 0 && res > Integer.MAX_VALUE / 10)
                return Integer.MAX_VALUE;
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10)
                return Integer.MAX_VALUE;
            if (flag < 0 && -res < Integer.MIN_VALUE / 10)
                return Integer.MIN_VALUE;
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
                return Integer.MIN_VALUE;
            res = res * 10 + ch - '0';
        }
        return res * flag;
    }
}
