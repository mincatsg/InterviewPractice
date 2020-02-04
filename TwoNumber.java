package Map;

import java.util.Arrays;

public class TwoNumber {
//    给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
//
//    每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
//
//    如果无法让 arr1 严格递增，请返回 -1。
public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
    int start = 0;
    for(int i = 0; i < arr1.length; i++){
        if(arr1[i] > arr1[i + 1]){
            start = i;
            break;
        }
    }
    Arrays.sort(arr2);
    int tem = 0;
    int tep = 0;
    int count = 0;
    if(start > 0){  //获取start前一位.
        tep = start - 1;
    }else{
        tep = start;
    }
    for(int i = start; i < arr1.length; i++){
        boolean judge = false;
        while(tem < arr2.length - 1 && arr1[tep] >= arr2[tem]){
            tem++;
        }
        arr1[i] = arr2[tem];
        count++;
        tep = i;
        for(int j = i; j < arr1.length - 1; j++){
            if(arr1[j] >= arr1[j + 1]){
                judge = true;
                break;
            }
        }
        if(!judge){
            break;
        }
        if(judge == true && tem == arr2.length - 1){
            return -1;
        }
    }
    return count;
}

    public static void main(String[] args) {
        int[] arr1 = {1,5,3,6,7};
        int[] arr2 = {1,6,3,3};
        System.out.println(makeArrayIncreasing(arr1, arr2));
    }

}
