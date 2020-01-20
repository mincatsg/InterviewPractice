public class test13 {
   //给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    public int[] sortedSquares(int[] A) {
        //普通遍历
        //     for(int i = 0; i < A.length; i++){
        //         A[i] *= A[i];
        //     }
        //  Arrays.sort(A);
        //  return A;
        //双指针
        int index = 0;
        while(index < A.length && A[index] < 0){ //找到正数与负数的分界点
            index++;
        }
        int index1 = index - 1; //负数最后一个.
        int[] B = new int[A.length];
        int ans = 0;
        while(index < A.length && index1 >= 0){//相当于俩个有序数组在排序
            if(A[index] * A[index] > A[index1] * A[index1]){
                B[ans++] = A[index1] * A[index1--];
            }else{
                B[ans++] = A[index] * A[index++];
            }
        }
        //一个数组排完了另一个可能有剩余.
        while(index < A.length){
            B[ans++] = A[index] * A[index++];
        }
        while(index1 >= 0){
            B[ans++] = A[index1] * A[index1--];
        }

        return B;
    }
}
