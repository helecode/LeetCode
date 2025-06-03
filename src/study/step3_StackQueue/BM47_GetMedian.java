package study.step3_StackQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * BM48 数据流中的中位数
 *如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 当向数据流中插入值时，将值插入到指定位置保证数据有序，这样就能快速与计算出数据的中位数
 */
public class BM47_GetMedian {

    //定义数据流域
    List<Integer> dataList=new ArrayList<>();
    public void Insert(Integer num) {
        //从小到大进行排序
        int i=0;
        for(;i<dataList.size();i++){
            if(num<dataList.get(i)){
                break;
            }
        }
        dataList.add(i,num);
    }

    public Double GetMedian() {
        //如果数据是偶数个，则中位数则是中间
        double result=0;
        if(dataList.size()%2==1){
            result=dataList.get(dataList.size()/2);
        }else{
            result=(dataList.get(dataList.size()/2)+dataList.get(dataList.size()/2-1))/2.0;
        }
        return result;
    }

}
