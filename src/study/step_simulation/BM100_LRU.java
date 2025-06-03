package study.step_simulation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * BM101 设计LFU缓存结构
 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 capacity ，操作次数是 n ，并有如下功能:
 1. Solution(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 2. get(key)：如果关键字 key 存在于缓存中，则返回key对应的value值，否则返回 -1 。
 3. set(key, value)：将记录(key, value)插入该结构，如果关键字 key 已经存在，则变更其数据值 value，如果不存在，则向缓存中插入该组 key-value ，如果key-value的数量超过capacity，弹出最久未使用的key-value

 提示:
 1.某个key的set或get操作一旦发生，则认为这个key的记录成了最常使用的，然后都会刷新缓存。
 2.当缓存的大小超过capacity时，移除最不经常使用的记录。
 3.返回的value都以字符串形式表达，如果是set，则会输出"null"来表示(不需要用户返回，系统会自动输出)，方便观察
 4.函数set和get必须以O(1)的方式运行
 5.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 *
 * linkedHashMap可以保证元素的插入顺序
 * 使用linkedHashMap实现
 *
 *
 *
 */
public class BM100_LRU {

    LinkedHashMap<Integer,Integer> cache=null;
    int capacity=0;
    public BM100_LRU(int capacity) {
        //初始化容量
        new LinkedHashMap(capacity);
        this.capacity=capacity;
    }

    public int get(int key) {
        // write code here
        if(cache.containsKey(key)){
            int value=cache.get(key);
            //刷新缓存，将key放在最前面
            refreshCache(key,value);
            return value;
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        // write code here
        if(cache.containsKey(key)){
            refreshCache(key,value);
        } else{
            if(cache.size()>=this.capacity){
                //如果大于当前容量，则移除最老的元素
                int last = cache.keySet().iterator().next();
                cache.remove(last);
            }
            cache.put(key,value);
        }
    }

    //更新该数据到链表头
    public void refreshCache(int key,int value){
        cache.remove(key);
        cache.put(key,value);
    }
}
