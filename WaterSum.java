package InterviewTraining2;

public class WaterSum{
   public int numIslands(char[][] grid) {
//用深度优先搜索DFS
        if(grid == null || grid.length == 0){
            return 0;
        }
        int[][] auxiliary_array = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    result++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * col + j);
                    while(!queue.isEmpty()){
                        int zz = queue.remove();
                        int x = zz / col;
                        int y = zz % col;
                        for(int c = 0; c < 4; c++){
                            int newx = x + auxiliary_array[c][0];
                            int newy = y + auxiliary_array[c][1];
                            if(newx >= 0 && newx < row && newy >= 0 && newy < col && grid[newx][newy] == '1'){
                                queue.add(newx * col + newy);
                                grid[newx][newy] = '0';
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    public void DFS(char[][] grid, int i, int j){
        if(grid == null || grid.length == 0){
            return;
        }
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
     }
}