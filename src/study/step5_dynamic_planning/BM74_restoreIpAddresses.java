package study.step5_dynamic_planning;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * BM74 数字字符串转化成IP地址
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 *
 * 使用回溯的思想来处理解决
 * 对于IP地址每次取出一个数字和一个点后，对于剩余的部分可以看成是一个子问题，因此可以使用递归和回溯将点插入数字中。
 * 具体做法：
 * step 1：使用step记录分割出的数字个数，index记录递归的下标，结束递归是指step已经为4，且下标到达字符串末尾。
 * step 2：在主体递归中，每次加入一个字符当数字，最多可以加入三个数字，剩余字符串进入递归构造下一个数字。
 * step 3：然后要检查每次的数字是否合法（不超过255且没有前导0）.
 * step 4：合法IP需要将其连接，同时递归完这一轮后需要回溯。
 *
 */
public class BM74_restoreIpAddresses {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5,6};
       new BM74_restoreIpAddresses().restoreIpAddresses("25525522135");
        System.out.println("ss");

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return int整型
     */
    public ArrayList<String> restoreIpAddresses (String s) {
        //长度小于3则无法复原
        ArrayList<String> res=new ArrayList<>();
        if(s==null || s.length()<4) return res;

        dfs(s,1,0,"",res);
        return res;
    }

    private void dfs(String a, int step,int index, String ip,List<String> res) {
        //递归返回条件，当i==5时，则返回
        if(step==5){
            if(index==a.length()){
                res.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        //当剩余字符个数小于ip地址段数
        //或者剩余字符个数大于ip地址段数*3，则直接返回，因为ip地址的最大值是255
        int remain=a.substring(index,a.length()).length();
        if(remain<5-step || remain>(5-step)*3) return;
        for (int len=1;len<4;len++){
            if(index+len>a.length()) continue;
            String ipSub=a.substring(index,index+len);
            int ipSubValue=Integer.parseInt(ipSub);
            //排除长度大于1且0开头不合法的部分
            if(ipSub.length()>1 && ipSub.startsWith("0")){
                continue;
            }
            if(ipSubValue>255){
                continue;
            }
            //没有改变当前循环的全局变量，所以不需要回溯
            dfs(a,step+1,index + len,ip+ipSub+".",res);
        }
    }


}
