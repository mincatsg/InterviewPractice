package NKTest;

import java.util.Stack;

public class NTwoStack {
    //用俩个栈实现一个队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //stack1 进队 stack2 辅助出队
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //栈中元素逆转成队列
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //出栈即出队
        int element = stack2.pop();
        //再返回回去
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return element;
    }
}
