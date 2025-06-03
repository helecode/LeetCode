package study.step5_dynamic_planning;

import java.util.Arrays;

/**
 * BM71 最长上升子序列(一)
 *  给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
 *  所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列。
 *  我们定义一个序列是 严格上升 的，当且仅当该序列不存在两个下标
 *
 * 状态定义，如果dp[i] 表示前 i 项的的长上升子序列的长度
 * 无法确定当前i是不是序列的最后的一个值
 *
 * 状态定义
 * dp[i]表示以第 i 项头结尾的最长上升子序列的长度
 * 为前面比他小的序列的最长子序列长度加一
 * 如果有 j<i 且 a[j]< a[i],那么就可以把 a[i]接在 a[j]的后面，dp[i]= dn[j]+ 1
 *
 */
public class BM71_LIS {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5,6};
        int solve = new BM71_LIS().LIS(a);
        System.out.println("ss");

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public int LIS (int[] arr) {
        if(arr.length==0 || arr.length==1){
            return arr.length;
        }
        //dp[i]表示以第 i 项头结尾的最长上升子序列的长度
        int dp[]=new int[arr.length];
        //初始化所有的最长子序列为1
        Arrays.fill(dp,1);
//         dp[i]表示以第 i 项头结尾的最长上升子序列的长度
//        为前面比他小的序列的最长子序列长度加一
//        如果有 j<i 且 a[j]< a[i],那么就可以把 a[i]接在 a[j]的后面，dp[i]= dn[j]+ 1
        int max=1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }


}
