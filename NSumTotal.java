import java.util.Scanner;
import java.util.*;

public class NSumTotal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> ans = new ArrayList<>();
            String N = in.next();
            for(int i = 0; i < N.length(); i++){
            Integer key = Integer.parseInt(String.valueOf(N.charAt(i)));
                if(!map.containsKey(key)){
                    map.put(key, 1);
                    ans.add(key);
                }else{
                    int count = map.get(key);
                    map.put(key, count + 1);
                }
            }
             Integer[] arr=ans.toArray(new Integer[ans.size()]);
             Arrays.sort(arr);
             for(Integer x : arr){
                System.out.println(x +":" + map.get(x));
            }
        }
    }
}