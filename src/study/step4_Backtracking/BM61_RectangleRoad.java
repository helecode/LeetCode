package study.step4_Backtracking;

/**
 *
 * BM61 矩阵最长递增路径
 * 给定一个 n 行 m 列矩阵 matrix ，矩阵内所有数均为非负整数。 你需要在矩阵中找到一条最长路径，使这条路径上的元素是递增的。并输出这条最长路径的长度。
 * 这个路径必须满足以下条件：
 *
 * 1. 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。
 * 2. 你不能走重复的单元格。即每个格子最多只能走一次。
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * 挨个遍历矩阵中的元素，以每个点作为出发点，并且让其往上下左右四个方向移动，如果是递增的则满足条件，则记录该位置，并且路径+1
 * 当矩阵其他点的位置与标记为已移动的路径重合时，那么路径长度为当前路径长度加上已移动节点的路径长度
 */
public class BM61_RectangleRoad {

    public static void main(String[] args) {

    }

    int maxPath=0;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solve (int[][] matrix) {
        int res=0;
        //记录被遍历的元素
        int memo[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int len = dfs(matrix, i, j, Integer.MIN_VALUE, memo);
                maxPath = Math.max(maxPath, len);
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j, int lastValue,int[][] memo) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[i].length || matrix[i][j]<lastValue){
            return 0;
        }
        //如果该点已经被计算，则只直接使用，不用向上下左右进行搜索
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        //如果没有被计算，仍然进行搜索
        int currVal = matrix[i][j];
        int up = dfs(matrix, i - 1, j, currVal, memo);
        int down = dfs(matrix, i + 1, j, currVal, memo);
        int left = dfs(matrix, i, j - 1, currVal, memo);
        int right = dfs(matrix, i, j + 1, currVal, memo);

        //取到每个方向的最大值
        memo[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        return memo[i][j];
    }


}