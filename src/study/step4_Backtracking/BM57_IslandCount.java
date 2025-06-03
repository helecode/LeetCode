package study.step4_Backtracking;

/**
 *
 * BM57 岛屿数量
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 *
 * 如果当前是岛屿，则遍历该岛屿的上下左右是不是岛屿，如果不是则直接返回，如果是，则进行递归遍历该岛屿上下左右是不是岛屿
 */
public class BM57_IslandCount {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'0','1','0','1','1'},
                {'0','0','0','1','1'},
                {'0','0','0','0','0'},
                {'0','0','1','1','1'}
        };
        int solve = new BM57_IslandCount().solve(grid);
        System.out.println();
    }
    public int solve (char[][] grid) {
        int res=0;
       //遍历数据
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    //递归遍历该岛屿周边的岛屿
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        //定义边界条件
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        //上面
        dfs(grid,i-1,j);
        //下面
        dfs(grid,i+1,j);
        //左边
        dfs(grid,i,j-1);
        //右边
        dfs(grid,i,j+1);
    }


}
