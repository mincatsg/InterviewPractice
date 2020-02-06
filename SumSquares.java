package InterviewTraining;

public class SumSquares {

//    给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
public boolean judgeSquareSum(int c) {
    double limit = Math.sqrt(c);
    for(int i = 0; i <= limit; i++){
        double test = Math.sqrt(c - i * i);
        if(test == (int)test){
            return true;
        }
    }
    return false;
}
}
