package study.step5_dynamic_planning;

/**
 * BM68 矩阵的最小路径和
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 *
 * 和上一题的逻辑差不多，0,0的路径为当前值，最上面一行只有一条路径，所以最小路径和就是前一个位置的最小路径之和加上当前值
 * 最走遍也只有一条路径，所以最左边的路径和等于上一个位置的路径之和加上当前值
 * 而其他位置的最小路径为当前值加上 上一个位置路径之和和左边位置路径之和的最小值
 * df递推公式为 [i][j]=[i][j].val+min([i-1][j],[i][j-1])
 *
 */
public class BM69_minPathSum {
    public static void main(String[] args) {
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        int [][] res=new int[matrix.length][matrix[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                if(i==0 && j==0){
                    //当前起点的值有且只有一个就是当前值
                    res[i][j]=matrix[i][j];
                }else if(i==0){
                    //到达上侧位置的值为到达上一个位置的值+当前值
                    res[i][j]=res[i][j-1]+matrix[i][j];
                }else if(j==0){
                    //到达左侧位置的值为到达上一个位置的值+当前值
                    res[i][j]=res[i-1][j]+matrix[i][j];
                }else{
                    //最小路径为当前值加上 上一个位置路径之和和左边位置路径之和的最小值
                    res[i][j]= Math.min(res[i-1][j],res[i][j-1])+matrix[i][j];
                }
            }
        }
        return res[matrix.length-1][matrix[0].length-1];
    }


}
