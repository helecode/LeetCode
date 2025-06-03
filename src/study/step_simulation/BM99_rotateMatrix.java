package study.step_simulation;

/**
 * BM99 顺时针旋转矩阵
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵。
 *
 * 使用翻转实现，先进行水平翻转，再进行对角线翻转。得到结果
 */
public class BM99_rotateMatrix {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param mat int整型二维数组
     * @param n int整型
     * @return int整型二维数组
     */
    public int[][] rotateMatrix (int[][] mat, int n) {
       //进行水平翻转
        //水平翻转，列不变，行进行对称变化,对称变化加起来会等于首尾之和
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[n-1-i][j];
                mat[n-1-i][j]=temp;
            }
        }
        //对角线翻转
        //行和列进行互换
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        return mat;
    }
}
