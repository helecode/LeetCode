package study.step_simulation;

import java.util.*;

/**
 * BM101 设计LFU缓存结构
 * 一个缓存结构需要实现如下功能。
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入
 * 这个策略为：在缓存结构的K条记录中，哪一个key被调用的次数最少，就删掉这个key的记录；
 * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
 * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
 *
 * step 1：需要节点结构，需要频率，key值，val值
 * step 2：建立哈希表mp，在每个节点的key值与节点，建立第二个哈希表freq_mp，存储指定访问频率下所有的节点，会存在多个节点的访问频率相同，所以key对应的节点是一个链表，并自动会按照访问的先后顺序进行排序，移除时总是移除链表尾部元素
 * step 3：LFU的剩余容量和当前最小频率设置为全局变量，并初始化。
 * step 4：遍历函数的操作数组，检查第一个元素判断是属于set操作还是get操作。
 * step 5：对于set操作，如果哈希表中已经有了key值，说明它已经在LFU中了，直接修改节点频率和val即可。
 * step 6：如果哈希表中没有，此时要考虑还有没有容量，若是有容量，容量需要减1；若是没有容量，从第二个哈希表中根据当前最小频率取出最小频率的双向链表，链表最后一个就是使用频率最低且最久未使用的，将其取出：链表中删除，哈希表中也有删除，如果链表为空了，则相应频率在哈希表中也要删除。
 * step 7：加入的时候，添加新的节点，频次为1，节点加入第一个哈希表，同时加入第二个哈希表相应频率链表的首部。
 * step 8：对于get操作，直接看第一个哈希表key值有没有找到，有则可以访问，然后修改频率，没有则返回-1.
 * step 9：修改频率的时候，将该频率下该节点取出，放入哈希表该频率加1的链表首部。若是该频率下链表没有节点了，则哈希表中删除这个频率，同时若是修改前的链表频率与最低频率相等，说明最低已经增长了。
 *
 */
public class BM101_LFU {
    public static void main(String[] args) {
        int aa[][]=new int[][]{{1,1,1},{1,2,2},{1,3,3},{1,4,4},{2,4},{2,3},{2,2},{2,1},{1,5,5},{2,4}};

        int[] lfu = new BM101_LFU().LFU(aa, 4);
        System.out.println();
    }
    //定义结构
    class Node{
        int key;
        int value;
        int freq;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
    //定义Map存储缓存数据
    Map<Integer,Node> data=new LinkedHashMap<>();
    //定义当前数据访问最小的频率
    int minfreq=0;
    //记录缓存的剩余容量
    int reSize=0;
    //定义访问频率和缓存数据之间的映射关系，将所有频率相同的数据放入到同一个list中
    //且链表头部放最新的数据，尾部放最老的数据
    Map<Integer,LinkedList<Node>> freq_mp=new HashMap<>();
    public int[] LFU (int[][] operators, int k) {
        //初始化容量
        reSize=k;
        //得到所有的get操作，表示需要返回数组的个数
        int resCount = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 2) {
                resCount++;
            }
        }
        //需要返回的结果
        int res[] = new int[resCount];
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 2) {
                //get操作
                res[res.length-resCount]=get(operators[i][1]);
                resCount--;
            } else {
                //set操作
                set(operators[i][1],operators[i][2]);
            }
        }
        return res;
    }

    private int get(int key) {
        int res=-1;
        //如果不存在，则返回-1
        if(!data.containsKey(key)){
            res=-1;
        }else{
            //如果存在，则返回具体值
            Node node = data.get(key);
            res=node.value;
            //如果当前频率是最小频率，则判断该频率中是否还存在其他该频率的数据，如果不存在，则更改访问最小频率
            if(node.freq==minfreq){
                int size = freq_mp.get(minfreq).size();
                if(size==1){
                    minfreq++;
                }
            }
            //移除该数据的频率
            removeDataFreq(node);
            node.freq=node.freq+1;
            //更新该key的频率
            updateDataFreq(node);
        }
        return res;
    }

    public void set(int key,int value){
        //如果包含该key
        if(data.containsKey(key)){
            //更新该key
            update(key,value);
        }else{
            //插入该key
            add(key,value);
        }

    }

    private void update(int key, int value) {
        Node node = data.get(key);
        //如果当前频率是最小频率，则判断该频率中是否还存在其他该频率的数据，如果不存在，则更改访问最小频率
        if(node.freq==minfreq){
            int size = freq_mp.get(minfreq).size();
            if(size==1){
                minfreq++;
            }
        }
        //移除该数据的访问频率
        removeDataFreq(node);
        //更新该数据
        node.value=value;
        node.freq=node.freq+1;
        //更新该数据访问频率
        updateDataFreq(node);
    }

    public void add(int key,int value){
        //是否还有容量，不存在则移除元素
        if(reSize==0){
            //移除最少访问频率中的最后一个元素
            Node last =freq_mp.get(minfreq).removeLast();
            data.remove(last.key);
            reSize++;
        }
        minfreq=1;
        //添加元素
        Node addNode=new Node(key,value,1);
        data.put(key,addNode);
        reSize--;
        //更新数据的频率
        updateDataFreq(addNode);
    }

    //移除数据的频率
    public void removeDataFreq(Node node){
        freq_mp.get(node.freq).remove(node);
    }

    public void updateDataFreq(Node node){
       //判断是否存在该频率
        if(!freq_mp.containsKey(node.freq)){
            freq_mp.put(node.freq,new LinkedList<>());
        }
        //添加该数据到链表头部
        freq_mp.get(node.freq).addFirst(node);
    }


}
