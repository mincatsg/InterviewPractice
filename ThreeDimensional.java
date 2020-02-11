package InterviewTraining;

public class ThreeDimensional {
//    在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
//
//    每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
//
//    请你返回最终形体的表面积。
public int surfaceArea(int[][] grid) {
    int sum = 0;
    int[][] ans = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[i].length; j++){
            if(grid[i][j] == 0){
                continue;
            }
            for(int[] d : ans){
                int x1 = i + d[0];
                int x2 = j + d[1];
                if(x1 < 0 || x1 >= grid.length || x2 < 0 || x2 >= grid[i].length){
                    sum += grid[i][j];
                }else if(grid[i][j] > grid[x1][x2]){
                    sum = sum + grid[i][j] - grid[x1][x2];
                }
            }
            sum += 2;  //上下两面.
        }
    }
    return sum;
}
}
