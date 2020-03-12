import java.util.ArrayList;
public class NBuildMuli {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            int sum = 1;
            for(int j = 0; j < A.length; j++){
                if(j != i){
                    sum *= A[j];
                }
            }
            B[i] = sum;
        }
        return B;
    }
}