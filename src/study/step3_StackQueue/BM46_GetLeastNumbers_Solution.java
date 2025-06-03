package study.step3_StackQueue;

import java.util.*;

/**
 * BM46 最小的K个数
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)
 *
 * 使用大顶堆的方式进行处理，将前面4个值放在大顶堆中，如果存在值小于大顶堆中的值，则将顶堆的值进行弹出，将该值进行放入
 */
public class BM46_GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<input.length;i++){
            if(i<k){
                maxHeap.add(input[i]);
            }else{
                if(input[i]<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        while (!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        Collections.sort(result);
        return result;
    }
}
