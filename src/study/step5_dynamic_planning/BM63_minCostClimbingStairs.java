package study.step5_dynamic_planning;

import java.util.Arrays;

/**
 * BM63 跳台阶
 *
 * 给定一个整数数组其中cost[i]是从楼梯第i个台阶向上爬需要支付的费用，下标从0开始。一旦你支付此费用，即可选择向上爬一个或者两个台阶
 *
 * 上到当前台阶有两种方法，也就是上到上一个台阶的最小值+当前值，或者上到上上一个台阶的最小值+当前值
 */
public class BM63_minCostClimbingStairs {
    public static void main(String[] args) {
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs (int[] cost) {
        //记录到达每一层所需要花费的费用
        //因为需要爬过所有楼梯，所以最后应该到达最后一个楼梯的后一个，也就是到达最后一个楼梯的后一个所需要花费的费用
        int stepCost[]=new int[cost.length+1];
        for(int i=0;i<=cost.length;i++){
            if(i==0 || i==1){
                stepCost[i]=0;
            }else{
                stepCost[i]=Math.min(stepCost[i-1]+cost[i-1],stepCost[i-2]+cost[i-2]);
            }
        }
        return stepCost[cost.length];
    }

}
