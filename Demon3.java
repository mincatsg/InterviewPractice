package InterviewTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Demon3 {
//    一.统计参与通信的服务器
//    这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
//
//    如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
//
//    请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
//    输入：grid = [[1,0],[0,1]]
//    输出：0
//    解释：没有一台服务器能与其他服务器进行通信。

    public int countServers(int[][] grid) {
        //先统计一下每行每列的服务器数，然后在遍历一次数组，去查看每个元素所在那一列或那一行有无服务器。去判断他能否通信

        int[] row = new int[grid.length];  //获取每行元素总数
        int[] col = new int[grid[0].length]; //获取每列元素总数

        //遍历数组统计每行每列总数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        //再去遍历一遍数组，看通信数
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //值为0肯定不行
                if(grid[i][j] == 0){
                    continue;
                }
             //如果他所在那一行那一列都为1,则为孤岛就不加，无法通信
                if(row[i] == 1 && col[j] == 1){
                continue;
              }
                    result++;
            }
        }

       return result;
    }

//    二.搜索推荐系统
//    给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
//
//    请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。
//    如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
//
//    请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
//
//    输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//    输出：[
//            ["mobile","moneypot","monitor"],
//            ["mobile","moneypot","monitor"],
//            ["mouse","mousepad"],
//            ["mouse","mousepad"],
//            ["mouse","mousepad"]
//            ]
//    解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
//    输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
//    输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //先获取一下数组长度和要查询字符串长度.
        int prolen = products.length;
        int searlen = searchWord.length();
        List<List<String>> result = new ArrayList<>(searlen);

        //去遍历一下数组，看有没有和第一个字符相等的，存到数组前point中,然后之后一二元素相等就在[0,point]中查找。

        for(int i = 0; i < searlen; i++){
            int point = 0;
            for(int j = 0; j < prolen; j++){
                //肯定数组这个元素的字符串长度肯定要比前缀要长.
                if(i < products[j].length() && searchWord.charAt(i) == products[j].charAt(i)){
                    products[point++] = products[j];
                }
            }

            //接下来就得排序了,用万能的sort排序.
            Arrays.sort(products, 0, point);
            //添加字符串
            List<String> cur = new ArrayList<>(3);
            for(int z = 0; z < point && z < 3; z++){
                cur.add(products[z]);
            }
            result.add(cur);
            //还得更新一下数组的长度,point之后的数组不匹配第一个,肯定后面就无用了.
            prolen = point;
        }
        return result;
    }
//    三.移除无效的括号
//
//    给你一个由 '('、')' 和小写字母组成的字符串 s。
//
//    你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
//
//    请返回任意一个合法字符串。
//
//    有效「括号字符串」应当符合以下 任意一条 要求：
//
//    空字符串或只包含小写字母的字符串
//    可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
//    可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
//
//    输入：s = "lee(t(c)o)de)"
//    输出："lee(t(c)o)de"
//    解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。

    public String minRemoveToMakeValid(String s) {
       //创建一个栈来做辅助去判断他的( )是否有效
        Stack<Integer> stack = new Stack<>();
        //创建一个布尔数组来去看他哪个位置是否有效
        boolean[] effect = new boolean[s.length()];
        StringBuilder news = new StringBuilder(s.length());

        //遍历一边字符串,去看那些符号是有效的.
        for(int i = 0; i < s.length(); i++){
            //如果他的字符是左括号,入栈先判非法，看他有没有匹配括号.
            if(s.charAt(i) == '('){
                stack.push(i);
                effect[i] = true;
            }
            //如果是右括号,出栈元素是否与其匹配,匹配就将匹配元素置为合法,否则就判为非法.
            if(s.charAt(i) == ')'){
                if(stack.empty()){
                    effect[i] = true;
                }else{
                    effect[stack.pop()] = false;
                }
            }
        }

        for(int i = 0; i < effect.length; i++){
            if(!effect[i]){
                news.append(s.charAt(i));
            }
        }
        return news.toString();
    }
}
