package study.step5_dynamic_planning;

import java.util.Arrays;

/**
 * BM79 打家劫舍(二)
 * 你是一个经验丰富的小偷，准备偷沿湖的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家，如果偷了第二家，那么就不能偷第一家和第三家。沿湖的房间组成一个闭合的圆形，即第一个房间和最后一个房间视为相邻。
 * 给定一个长度为n的整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 *
 * 由于数组成环了，所以首尾元素不能同时存在
 * 情况一：考虑包含首元素，不包含尾元素
 * 情况二：考虑包含尾元素，不包含首元素
 * 分析到这里，本题其实比较简单了。 剩下的和198.打家劫舍 (opens new window)就是一样的了。
 *
 */
public class BM79_rob2 {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5,6};
       new BM79_rob2().rob(new int[]{19,43,94,4,34,33,91,75,38,79});
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
        //考虑首元素,不考虑尾元素
        int nums1[]= Arrays.copyOfRange(nums,0,nums.length-1);
        int dp1[]=new int[nums1.length+1];
        //长度为1只能偷第一家
        dp1[1]=nums1[0];
        for(int i=1;i<nums1.length;i++){
            dp1[i+1]=Math.max(dp1[i+1-2]+nums1[i],dp1[i+1-1]);
        }

        //考虑尾元素,不考虑首元素
        int nums2[]= Arrays.copyOfRange(nums,1,nums.length);
        int dp2[]=new int[nums2.length+1];
        //长度为1只能偷第一家
        dp2[1]=nums2[0];
        for(int i=1;i<nums2.length;i++){
            dp2[i+1]=Math.max(dp2[i+1-2]+nums2[i],dp2[i+1-1]);
        }
        return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);

    }

}
