package study.step7_doublePoint;

import java.util.*;

/**
 * BM92 最长无重复子数组
 *
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 *
 * 使用双指针实现
 * 利用双指针模拟一个滑动窗口
 * 初始化该窗口为(left, right]。所以left从-1开始。窗口不断往右扩大。因为我们要的是无重复子数组，因此，遇到有重复的数字，在窗口左侧进行缩小。
 * 在每次滑动时，对窗口的大小进行比较，保留最大的长度。
 */
public class BM92_maxLength {

    public static void main(String[] args) {
        new BM92_maxLength().maxLength(new int[]{9,9});
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        if(arr.length<=1) return  arr.length;
        //定义指针
        int left=0;
        int right=0;
//        维护当前窗口里每个元素最后一次出现的位置
        Map<Integer,Integer> windows=new HashMap<>();
        int max=1;
        while (right<arr.length){
            int curr=arr[right];
            //如果包含则向左移动左指针
            //得到重复元素的下标，移动left指针移动到重复元素下标的后一个元素，这样窗口中才能保证没有重复元素
            if(windows.containsKey(curr)) {
                //防止指针往回走，即如果的是窗口范围前出现相同的数，则窗口不移动
                left = Math.max(left, windows.get(curr) + 1);
            }
            //替换重复元素，也就是去除之前的重复元素，加入新的重复元素
            windows.put(curr,right );
            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }


}

