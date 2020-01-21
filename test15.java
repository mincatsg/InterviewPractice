public class test15 {
    //按奇偶排序数组
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while(start < end){
            while(A[start] % 2 == 0 && start < end){
                start++;
            }
            while(A[end] % 2 == 1  && start < end){
                end--;
            }
            int tem = A[start];
            A[start] = A[end];
            A[end] = tem;
        }

        return A;
    }
}
