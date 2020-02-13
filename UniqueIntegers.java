package InterviewTraining;

public class UniqueIntegers {
//    和为零的N个唯一整数
//    给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
public int[] sumZero(int n) {
    int[] arr = new int[n];
    for(int i = 0; i < n - 1; i++){
        arr[i] = i;
        arr[n - 1] += i;
    }
    arr[n - 1] = -arr[n - 1];
    return arr;
}
}
