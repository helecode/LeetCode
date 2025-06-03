package study.step8_greed;

import java.util.Arrays;

/**
 * BM96 主持人调度（二）
 *
 * 有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 starti ,第 i 个活动的结束时间是 endi ,举办某个活动就需要为该活动准备一个活动主持人。
 * 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i 个活动，那么该主持人在 (starti,endi) 这个时间段不能参与其他任何活动。求为了成功举办这 n 个活动，最少需要多少名主持人。
 *
 * 具体做法：
 * step 1: 利用辅助数组获取单独各个活动开始的时间和结束时间，然后分别开始时间和结束时间进行排序，方便后面判断是否相交。
 * step 2: 遍历n个活动，如果某个活动开始的时间大于之前活动结束的时候，当前主持人就够了，当前主持人已经结束当前活动，可以复用主持人继续主持下一个活动j++
 * j指向最早可以复用的主持人
 * step 3: 若是出现之前活动结束时间晚于当前活动开始时间的，则需要增加主持人。
 *
 */
public class BM96_minmumNumberOfHost {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {

        //定义数组分别存储起始时间和终止时间
        int start[]=new int[n];
        int end[]=new int[n];
        for(int i=0;i<n;i++){
            start[i]=startEnd[i][0];
            end[i]=startEnd[i][1];
        }
        //对开始时间和结束时间进行排序
        Arrays.sort(start);
        Arrays.sort(end);
        int j=0;//指向最早可以复用的主持人
        int res=0;//需要主持人数
        for(int i=0;i<n;i++){
            //如果结束时间大于开始时间，则大表i活动开始时，j活动已经结束，所以主持人可以复用，不需要新增主持人，
            // 并且j++指向下一场活动结束的时间，end[j]代表当前执行的活动中最早结束的活动时间。
            //否则需要增加主持人
            if(start[i]>=end[j]){
                j++;
            }else {
                res++;
            }
        }
        return res;

    }
}
