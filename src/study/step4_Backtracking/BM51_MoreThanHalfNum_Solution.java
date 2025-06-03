package study.step4_Backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 * 使用map实现，key放数字，value放出现的次数，再统计出现最多次数的key
 */
public class BM51_MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution (int[] numbers) {
        Map<Integer,Integer> keyMap=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(keyMap.containsKey(numbers[i])){
                keyMap.put(numbers[i],keyMap.get(numbers[i])+1);
            }else{
                keyMap.put(numbers[i],1);
            }
        }

        int maxCount=0;
        int value=0;
        for(Integer a:keyMap.keySet()){
            if(keyMap.get(a)>maxCount){
                maxCount=keyMap.get(a);
                value=a;
            }
        }
        if(maxCount>numbers.length/2){
            return value;
        }
        return 0;

    }

}
