package study.step5_dynamic_planning;

/**
 *
 * BM73 最长回文子串
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 *
 * 中心扩散
 * 每个字符都尝试作为中心点
 * 从left到right开始向两边扩散、比较，如果相等则继续扩散比较
 * 如果不相等不用再继续扩散比较
 * 可能会出现两种情况，
 * 1.中心点为1个
 * left=i-1，right=i+1
 * 2.中心点为多个
 * left=i-1，right=i+n
 * 如果中心点为多个，则将中心右侧的起始位置进行后移
 * 如果不相等则剪枝，不用再继续扩散比较
 * 计算每次比较的回文子串长度，取最大
 *
 */
public class BM73_getLongestPalindrome {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5,6};
        int solve = new BM73_getLongestPalindrome().getLongestPalindrome("bb");
        System.out.println("ss");

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A string字符串
     * @return int整型
     */
    public int getLongestPalindrome (String A) {
        if(A==null || A.length()==0){
            return 0;
        }
        //拆分为字符
        char[] arr=A.toCharArray();
        //存储回文子串的最大长度
        int max=1;
        //遍历数组，将每个字符都作为子串，得到最大长度的子串
        for(int i=0;i<arr.length;i++){
            int res=1;
            int right=i;
            //中心点的个数，中心点可能有好几个,得到中心点的个数
            for(int ii=i+1;ii<arr.length;ii++){
                if(arr[ii]==arr[i]){
                    res++;
                    right++;
                }else {
                    break;
                }
            }
            //从中心点开始往前和往后进行匹配
            for(int j=1;j<=i;j++){
                if(right+j<arr.length && arr[i-j]==arr[right+j]){
                    res=res+2;
                }else{
                    break;
                }
            }

            if(res>max){
                max=res;
            }

        }
        return max;
    }


}
