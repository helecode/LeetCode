package study.step3_StackQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * BM47 寻找第K大
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 *
 * 使用快速排序的思想实现
 */
public class BM47_findKth {

    public int findKth (int[] a, int n, int m) {
        int result=0;
        //选择排序，将最值放在左边
//        for(int i=0;i<n;i++){
//            int k=i;
//            for(int j=i+1;j<n;j++){
//                if(a[k]<a[j]){
//                    k=j;
//                }
//            }
//            if(k!=i){
//                int t=a[k];
//                a[k]=a[i];
//                a[i]=t;
//            }
//        }
//        冒泡排序，将最值放在右边
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int t=a[j+1];
                    a[j+1]=a[j];
                    a[j]=t;
                }
                if(i+1==m){
                    result=a[n-i-1];
                    break;
                }
            }
        }
        return result;
    }
}
