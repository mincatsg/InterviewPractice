package InterviewTraining;

public class EqualDifference {
//    如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
public int numberOfArithmeticSlices(int[] A) {
    // int count = 0;
    // for(int i = 0; i < A.length - 2; i++){
    //     int d = A[i + 1] - A[i];
    //     for(int j = i + 2; j < A.length; j++){
    //         int z;
    //         for(z = i + 1; z <= j; z++){
    //             if(A[z] - A[z - 1] != d){
    //                 break;
    //             }
    //         }
    //         if(z > j){
    //             count++;
    //         }
    //     }
    // }
    // return count;
    int count = 0;
    for(int i = 0; i < A.length - 2; i++){
        int d = A[i + 1] - A[i];
        for(int j = i + 2; j < A.length; j++){
            if(A[j] - A[j - 1] != d){
                break;
            }else{
                count++;
            }
        }
    }
    return count;
}
}
