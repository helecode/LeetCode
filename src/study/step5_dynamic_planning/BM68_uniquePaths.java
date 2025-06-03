package study.step5_dynamic_planning;

/**
 * BM67 不同路径的数目(一)
 * 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 *
 * 从左上到右下，机器人只能向右走或者向下走，则到达指定位置的路径数等于上面格子的路径数+下面格子的路径数
 * [i][j]=[i-1][j]+[i][j-1]
 *
 */
public class BM68_uniquePaths {
    public static void main(String[] args) {
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        int res[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //最上侧只能一直往上走才能到达，最右侧一直往往右走才能到达，只有一种路径
                if(i==0 || j==0){
                    res[i][j]=1;
                }else{
                //如果不是的话，则到达该位置的路径数等于上面格子的路径数+下面格子的路径数之和
                    res[i][j]=res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }


}
