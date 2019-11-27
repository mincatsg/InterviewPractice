package InterviewTraining;

import java.util.ArrayList;
import java.util.List;

public class Demon1 {
//    一.二维网格迁移
//    给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//    每次「迁移」操作将会引发下述活动：
//
//    位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
//    位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
//    位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。

//    请你返回 k 次迁移操作后最终得到的 二维网格。
//    输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//    输出：[[9,1,2],[3,4,5],[6,7,8]]

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (grid.length == 0) {
            return result;
        }
        //获取行数
        int n = grid.length;
        //获取列数
        int m = grid[0].length;
        //因为移动一个二维数组元素总和就会重复，所以求下实际次数
        int times = k % (n * m);
        int tem;
        //从后向前遍历更简单
        for (int cc = 0; cc < times; cc++) {
            //将最后一个值先保存。
            tem = grid[n - 1][m - 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    //按照上面规则去赋值交换。
                    if (i == 0 && j == 0) {
                        grid[i][j] = tem;
                    } else {
                        //前后
                        if (j == 0) {
                            grid[i][j] = grid[i - 1][m - 1];
                            //每行第一个和上一行最后一个
                        } else {
                            grid[i][j] = grid[i][j - 1];
                        }
                    }
                }
            }
        }
        //去添加元素给表中
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                cur.add(grid[i][j]);
            }
            result.add(cur);
        }
        return result;
    }

//二. 奇数值单元格的数目
//    给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
//
//    另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
//
//    你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
//
//    请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。

//    输入：n = 2, m = 3, indices = [[0,1],[1,1]]
//    输出：6
//    解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
//    第一次增量操作后得到 [[1,2,1],[0,1,0]]。
//    最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。

    public int oddCells(int n, int m, int[][] indices) {
        //行数组
        int[] row = new int[n];
        //列数组
        int[] col = new int[m];

        for (int i = 0; i < indices.length; i++) {
            //记录每行出现次数
            row[indices[i][0]]++;
            //记录每列出现次数
            col[indices[i][1]]++;
        }
        //就是说他这一行加了几次1, 这一列加了几次1.

        //遍历每行每列，将他们这一行这一列的计数加起来就是他自已数。
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
//  三.  重构 2 行二进制矩阵
//    给你一个 2 行 n 列的二进制数组：
//
//    矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
//    第 0 行的元素之和为 upper。
//    第 1 行的元素之和为 lower。
//    第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
//    你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
//
//    如果有多个不同的答案，那么任意一个都可以通过本题。
//
//    如果不存在符合要求的答案，就请返回一个空的二维数组。

//    输入：upper = 2, lower = 1, colsum = [1,1,1]
//    输出：[[1,1,0],[0,0,1]]
//    解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        //建存的顺序表
        List<List<Integer>> result = new ArrayList<>(2);

        int len = colsum.length;
        //在建2行顺序表
        List<Integer> one = new ArrayList<>(len);
        List<Integer> two = new ArrayList<>(len);

        //接下来在colsum数组里找是2的,是2的肯定2行都为1,,然后分别将upper和lower减去一，看他们每行还有还有几个一。
        for (int i = 0; i < len; i++) {
            if (colsum[i] == 2) {
                upper--;
                lower--;
            }
        }
        //如果把2减完了,他俩有个成负数了，则完全不成立。
        if (upper < 0 || lower < 0) {
            return result;
        }
        //再去遍历一遍,去给2个顺序表里添加.
        for (int i = 0; i < len; i++) {
            //当那一列为2时,分别加1
            if (colsum[i] == 2) {
                one.add(1);
                two.add(1);
            }
            //那一列为0,则分别加0
            else if (colsum[i] == 0) {
                one.add(0);
                two.add(0);
            }
            //否则则是那一列为1.
            else {
                //先给第一行加1，去--upper。
                if (upper > 0) {
                    one.add(1);
                    two.add(0);
                    upper--;
                } else if (lower > 0) {
                    one.add(0);
                    two.add(1);
                    lower--;
                } else {
                    return result;
                }
            }
        }
        if (upper > 0 || lower > 0) {
            return result;
        }
        result.add(one);
        result.add(two);
        return result;
    }
}

