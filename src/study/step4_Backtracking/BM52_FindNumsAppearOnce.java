package study.step4_Backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * BM52 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 使用map实现，key放数字，value放出现的次数,再统计只出现过一次的数字
 */
public class BM52_FindNumsAppearOnce {

    public int[] FindNumsAppearOnce (int[] numbers) {
        Map<Integer,Integer> keyMap=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(keyMap.containsKey(numbers[i])){
                keyMap.put(numbers[i],keyMap.get(numbers[i])+1);
            }else{
                keyMap.put(numbers[i],1);
            }
        }

        int res[]=new int[2];
        int i=0;
        for(Integer a:keyMap.keySet()){
            if(keyMap.get(a)==1){
                res[i]=a;
                if(i==1){
                    break;
                }
                i++;

            }
        }

        Arrays.sort(res);
         return res;


    }

}
