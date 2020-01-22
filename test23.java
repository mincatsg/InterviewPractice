public class test23 {
    // 给定一组字符，使用原地算法将其压缩。

    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        int newlength = 0; //记录数组长度
        for(int i = 0; i < chars.length; i++){
            if((i < chars.length - 1) && chars[i] == chars[i + 1]){
                int count = 1;
                while((i < chars.length - 1) && chars[i] == (chars[i + 1])){  //看有这个字符有几个
                    i++;
                    count++;
                }
                chars[newlength++] = chars[i]; //赋值字符
                String tem = "" + count;  //赋值个数.
                for(int j = 0; j < tem.length(); j++){
                    chars[newlength++] = tem.charAt(j);
                }
            }else{
                chars[newlength++] = chars[i];
            }
        }
        return newlength;
    }
}
