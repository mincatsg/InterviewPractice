import java.util.Stack;

public class test25 {

    //根据逆波兰表示法，求表达式的值。

    //有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

    public int evalRPN(String[] tokens) {
        //俩种转换String 转 Integer
        //Integer.valueOf(str);
        //Integer.parseInt(str);

        int sum = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if( (!(tokens[i].equals("+"))) && (!(tokens[i].equals("-"))) && (!(tokens[i].equals("/"))) && (!(tokens[i].equals("*")))){ //是数字就入栈.
                stack.push(tokens[i]);
            }else{//出栈俩个数计算并且在入栈算的结果
                int s1 = Integer.valueOf(stack.pop());
                int s2 = Integer.valueOf(stack.pop());
                sum = 0;
                if(tokens[i].equals("+")){
                    sum = s1 + s2;
                }
                if(tokens[i].equals("-")){
                    sum = s2 - s1;
                }
                if(tokens[i].equals("/")){
                    sum = s2 / s1;
                }
                if(tokens[i].equals("*")){
                    sum = s1 * s2;
                }
                String s3 =  "" + sum;
                stack.push(s3);
            }
        }
        sum = Integer.valueOf(stack.pop());
        return sum;

        //  Stack<Integer> stack = new Stack<>();
        // for (String s : tokens) {
        //     if (s.equals("+")) {
        //         stack.push(stack.pop() + stack.pop());
        //     } else if (s.equals("-")) {
        //         stack.push(-stack.pop() + stack.pop());
        //     } else if (s.equals("*")) {
        //         stack.push(stack.pop() * stack.pop());
        //     } else if (s.equals("/")) {
        //         int num1 = stack.pop();
        //         stack.push(stack.pop() / num1);
        //     } else {
        //         stack.push(Integer.parseInt(s));
        //     }
        // }
        // return stack.pop();

    }
}
