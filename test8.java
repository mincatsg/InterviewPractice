public class test8 {
    //最后一个单词的长度
    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int count = 0;
        while(len >= 0 && s.charAt(len) == ' '){  //防止最后是空格
            len--;
        }
        for(int i = len; i >= 0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            count++;
        }
        return count;
    }
}
