package study.step5_dynamic_planning;

import java.awt.*;
import java.util.Arrays;

/**
 * BM70 兑换零钱(一)
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 *如果无解，请返回-1.
 *
 * 把兑换的零钱看做要上的楼梯，给定的数组看做每次上扣题的阶梯数，相当求解上到指定楼梯的最小次数
 * 而当前楼梯次数=上到他的前一次楼梯的次数最小值+1 即 dp[i]=min(dp[i],dp[i−arr[j]]+1)
 *
 */
public class BM70_minMoney {
    public static void main(String[] args) {
        int a[]=new int[]{5,2,3};
        int solve = new BM70_minMoney().minMoney(a,20);
        System.out.println("ss");

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        if(arr.length==0 || aim==0) return -1;
        //上到每阶楼梯的次数,初始化一个不可能的值（比最大可能解大）,便于后续计算
        int res[]=new int[aim+1];
        Arrays.fill(res, aim + 1);
//        res[0] = 0 是动态规划的基准条件，表示“凑出 0 元需要 0 个硬币”。
//        如果不初始化 res[0] = 0，递推公式无法正确计算最小硬币数。
//        这是动态规划问题中常见的初始化技巧，类似的还有：
//        背包问题：dp[0][0] = 0（容量为 0 时最大价值是 0）。
//        爬楼梯问题：dp[0] = 1（爬到第 0 阶有 1 种方式）。
        res[0] = 0;
        for(int i=1;i<res.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i>=arr[j]){
                    res[i]=Math.min(res[i],res[i-arr[j]]+1);
                }
            }
        }
        return res[res.length-1]<aim+1?res[res.length-1] :-1 ;
    }


}
