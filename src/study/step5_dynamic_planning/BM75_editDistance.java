package study.step5_dynamic_planning;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定两个字符串 str1 和 str2 ，请你算出将 str1 转为 str2 的最少操作数。
 * 你可以对字符串进行3种操作：
 * 1.插入一个字符
 * 2.删除一个字符
 * 3.修改一个字符。
 *
 * 类似BM65最长公共子序列
 * 同样使用一个二维数组存储结果
 * dp[i][j]表示从两个字符串首部各自到str1[i]和str2[j]为止的子串需要的编辑距离
 * 那么dp[str1.length][str2.length]就是我们要求的编辑距离
 * step1：初始条件：假设第二个字符串为空，那很明显第一个字符串子串每增加一个字符，编辑距离就加1，这步操作是删除；
 *       同理，假设第一个字符串为空，那第二个字符串每增加一个字符，编剧距离就加1，这步操作是添加
 * step2：状态转移：状态转移肯定是将dp矩阵填满，那就遍历第一个字符串的每个长度，对应第二个字符串的每个长度
 *      如果遍历到str1[i]和str2[j]的位置，这两个字符相同，这多出来的字符就不用操作，操作次数与两个子串的前一个相同，因此有dp[i][j]=dp[i−1][j−1]
 *      如果这两个字符不相同，那么这两个字符需要编辑，但是此时的最短的距离不一定是修改这最后一位，也有可能是删除某个字符或者增加某个字符
 *      因此我们选取这三种情况的最小值增加一个编辑距离
 *      假如我们只对s1进行操作
 *      如果s1插入，那么i+1处和j处相等 则 dp[i][j]=a[i][j-1]+1
 *      如果s2插入，那么i处和j+1处相等 则 dp[i][j]=a[i-1][j]+1
 *      如果是修改 那么i处和j处相等 则 dp[i][j]=a[i-1][j-1]+1
 *      即dp[i][j]=min(dp[i−1][j−1],min(dp[i−1][j],dp[i][j−1]))+1。
 *
 */
public class BM75_editDistance {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5,6};
       new BM75_editDistance().editDistance("nowcoder","new");
        System.out.println("ss");

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return int整型
     */
    public int editDistance (String str1, String str2) {
       int dp[][]=new int[str1.length()+1][str2.length()+1];
       //初始化边界
        for(int i=0;i<dp.length;i++){
          for(int j=0;j<dp[0].length;j++){
              if(j==0 && i==0){
                  dp[i][j]=0;
              }
              else if(i==0){
                  dp[i][j]= j;
              }
              else if(j==0){
                  dp[i][j]=i;
              }

          }
        }
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[i].length;j++){
               if(str1.charAt(i-1)==str2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1];
               }else{
                   dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
               }
           }
       }
       return dp[str1.length()][str2.length()];
    }


}
