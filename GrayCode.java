import java.util.*;


//格雷码的生成
public class GrayCode {
    public String[] getGray(int n) {
        if(n == 1){
            String[] result = new String[2];
            result[0] = "0";
            result[1] = "1";
            return result;
        }else{
            String[] ans = getGray(n - 1);
            String[] result = new String[ans.length * 2];
            for(int i = 0; i < ans.length; i++){
                result[i] = "0" + ans[i];
            }
           for(int i = 0; i < ans.length; i++){
               result[i + ans.length] = "1" + ans[ans.length - 1 - i];
           }
            return result;
        }
    }
}