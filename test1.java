package BigBig;

import java.util.Scanner;

public class test1 {
//    现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] tree = new int[n];
        for(int i = 0; i < n; i++){
            tree[i] = -1;
        }
        for(int i = 0; i < n - 1; i++){
            int father = in.nextInt();
            int child = in.nextInt();
            tree[child] = father;
        }
        //从每一个儿子往根节点遍历,找最大.
        int max = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            int j = tree[i];
            while(j != -1){
                sum++;
                j = tree[j];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
