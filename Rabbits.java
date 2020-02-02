package Map;

import java.util.HashMap;
import java.util.Map;

public class Rabbits {

//    森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
//    我们将这些回答放在 answers 数组里。
//    返回森林中兔子的最少数量。
    public static int numRabbits(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < answers.length; i++){
            if(map.containsKey(answers[i]) && map.get(answers[i]) != 0){
                int value = map.get(answers[i]);
                map.put(answers[i], value - 1);
                if(map.get(answers[i]) == 0){
                    sum = sum + answers[i] + 1;
                }
                continue;
            }
            map.put(answers[i], answers[i]);
            if(answers[i] == 0){
                sum = sum + answers[i] + 1;
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) != 0){
                sum = sum + key + 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {2,1,2,2,2,2,2,2,1,1};
        System.out.println(numRabbits(a));
    }
}
