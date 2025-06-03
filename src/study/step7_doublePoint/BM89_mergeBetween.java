package study.step7_doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * BM89 合并区间
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 *
 * step 1：先将所有区间按照起点位置先进行排序
 * step 2：排序后的第一个区间一定是起点值最小的区间，我们将其计入返回数组res，然后遍历后续区间。
 * step 3：后续遍历过程中，如果遇到起点值小于res中最后一个区间的末尾值的情况，那一定是重叠，取二者最大末尾值更新res中最后一个区间即可。
 * step 4：如果遇到起点值大于res中最后一个区间的末尾值的情况，那一定没有重叠，后续也不会有这个末尾的重叠区间了，因为后面的起点只会更大，因此可以将它加入res
 *
 */
public class BM89_mergeBetween {

    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        if(intervals.size()==0){
           return new ArrayList<>();
        }else if(intervals.size()==0){
            return intervals;
        }
        //对区间集合进行排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        //初始化集合中第一个元素是结果
        ArrayList<Interval> res=new ArrayList<>();
        res.add(intervals.get(0));
        for(int j=1;j<res.size();j++){
            Interval currInteger=intervals.get(j);
            //判断是否与前一个区间存在交叉，如果存在交叉则需要合并区间
            //通过判断后一个区间的最小值是否小于上一个区间的最大值
            Interval merge=res.get(res.size()-1);
            if(currInteger.start<=merge.end){
                //因为集合已经排序了，所以currInteger区间的起点小于merge，那么判断谁的区间终点大
                //当当前区间currInteger终点大于merge终点,则修改merge的终点值合并区间，小于则代表merge区间覆盖了currInteger区间，值不用改变
                if(currInteger.end>merge.end){
                    merge.end=currInteger.end;
                }
            }else{
                res.add(currInteger);
            }
        }
        return res;
    }


}

//"区间"定义
class Interval {
    int start; //起点
    int end;   //终点
}
