package study.step5_dynamic_planning;

/**
 * BM78 打家劫舍(一)
 * 你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
 * 给定一个整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 *
 * 使用动态规划的思想来做
 * step1： 用dp[i]表示长度为i的数组，表示到第i家时能偷到的最多钱，
 * step2： 因此dp[1]=nums[0]dp[1]=nums[0]。
 * step3：每次对于第i个人家，我们选择偷他或者不偷他，如果我们选择偷那么前一家必定不能偷，因此累加的上上级的最多收益，同理如果选择不偷他，那我们最多可以累加上一级的收益
 *        因此转移方程为dp[i]=max(dp[i−1],nums[i−1]+dp[i−2])
 *
 */
public class BM75_rob1 {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5,6};
       new BM75_rob1().rob(new int[]{19,43,94,4,34,33,91,75,38,79});
        System.out.println("ss");

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int rob (int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        // write code here
        //偷到第i家时，用数组下标i+1表示能偷到的最多钱,防止i-2时数据溢出，所以将第i家能偷到的最多钱放在了i-1
        int dp[]=new int[nums.length+1];
        //长度为1只能偷第一家
        dp[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            //偷到第i家时，用数组下标i+1表示能偷到的最多钱,防止i-2时数据溢出，所以将第i家能偷到的最多钱放在了i-1
            dp[i+1]=Math.max(dp[i+1-2]+nums[i],dp[i+1-1]);
        }
         return dp[dp.length-1];
    }


}
