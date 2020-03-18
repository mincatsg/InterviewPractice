package NKTest;

public class NDifferentAdd {

    public int addAB(int A, int B) {
        int add = 0;
        int addNext = 0;
//       位的异或运算跟求'和'的结果一致：
//       位的与运算跟求'进位‘的结果一致：
        while(B != 0){
            add = A ^ B;
            addNext = (A & B) << 1;
            A = add;
            B = addNext;
        }
        return A;
    }
}
