package InterviewTraining;

public class StupidFactorial {
//    通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
//
//    相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
//
//    例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
//
//    另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
//
//    实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
    public int clumsy(int N) {
        //按部分计算看有几次存到数组中,集中去减,开始一次先牺牲加一次 ,后面乘2次就行.
        int count = 0;
        int times = N / 4 + ((N % 4 == 0)? 0 : 1);
        int[] arr = new int[times];
        int sum = 0;
        int m = N;
        for(int i = 0; i < times; i++){
            arr[i] = N;
            if(count == 0 && N > 1){
                arr[i] = arr[i] * (N - 1);
                count++;
                N--;
            }
            if(count == 1 && N > 1 ){
                arr[i] = arr[i] / (N - 1);
                count++;
                N--;
            }
            if(count == 2 && N > 1){
                arr[i] = arr[i] - (N - 1);
                count++;
                N--;
            }
            if(i == 0){
                sum = arr[i];
            }else{
                sum = sum - arr[i];
            }
            count = 0;
            N--;
        }
        if(m > 3){
            sum = sum + (m - 3) * 2;
        }
        return sum;
    }
}
