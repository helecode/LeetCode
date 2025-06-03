package study.step7_doublePoint;

import java.util.HashMap;
import java.util.Map;

/**
 * BM93 盛水最多的容器
 *
 * 给定一个数组height，长度为n，每个数代表坐标轴中的一个点的高度，height[i]是在第i点的高度，请问，从中选2个高度与x轴组成的容器最多能容纳多少水
 * 1.你不能倾斜容器
 * 2.当n小于2时，视为不能形成容器，请返回0
 * 3.数据保证能容纳最多的水不会超过整形范围，即不会超过231-1
 *
 *
 * 实现思路：
 * 初始状态：双指针分别指向数组的首尾（left = 0，right = n - 1），此时容器的宽度最大。
 * 移动指针：每次移动高度较小的指针。因为容器的容量由较矮的高度决定，移动较高的指针不会增加容量（因为高度不会增加，而宽度在减少），而移动较矮的指针可能遇到更高的高度，从而可能增加容量。
 * 容量计算：每次移动指针后，计算当前容器的容量（min(height[left], height[right]) * (right - left)），并与之前的最大容量比较，更新最大容量。
 * 终止条件：当 left 和 right 指针重合时，遍历结束。
 *
 *
 */
public class BM93_maxArea {

    public static void main(String[] args) {
        new BM93_maxArea().maxArea(new int[]{1,7,3,2,4,5,8,2,7});
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param height int整型一维数组
     * @return int整型
     */
    public int maxArea (int[] height) {
        if(height.length<=1){
            return 0;
        }
        int res=0;
        //初始状态：双指针分别指向数组的首尾（left = 0，right = n - 1），此时容器的宽度最大。
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int minHeight=Math.min(height[left],height[right]);
            //每次移动指针后，计算当前容器的容量（min(height[left], height[right]) * (right - left)），并与之前的最大容量比较，更新最大容量。
            max=Math.max(minHeight*(right-left),max);
            //每次移动高度较小的指针。因为容器的容量由较矮的高度决定，移动较高的指针不会增加容量（因为高度不会增加，而宽度在减少），而移动较矮的指针可能遇到更高的高度，从而可能增加容量。
            if(height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }


}

