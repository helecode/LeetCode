package study.step5_dynamic_planning;

/**
 * BM69 把数字翻译成字符串
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 *
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 *现在给一串数字，返回有多少种可能的译码结果
 *
 step1：用辅助数组dp表示前i个数的译码方法有多少种。
 step2：对于一个数，我们可以直接译码它，也可以将其与前面的1或者2组合起来译码：
    如果直接译码，则dp[i]=dp[i−1]dp[i]=dp[i−1]；如果组合译码，则dp[i]=dp[i−2]dp[i]=dp[i−2]。
 step3：但当最后两个数字大于25时，对于只有一种译码方式的
 选上种dp[i−1]dp[i−1]即可，对于满足两种译码方式（10，20不能）则是dp[i−1]+dp[i−2]dp[i−1]+dp[i−2]
 step4：依次相加，最后的dp[length]dp[length]即为所求答案。
 *
 */
public class BM69_numberToString {
    public static void main(String[] args) {
        int solve = new BM69_numberToString().solve("10");
        System.out.println("ss");

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        //如果开头含有0，则无法解析
        if (nums == null || nums.length() == 0 || nums.charAt(0) == '0') {
            return 0;
        }

        int a[]=new int[nums.length()];
        //如果开头不为0，则第一个一定可以解析
        a[0] = 1; // 空字符串的解码方式为 1（初始条件）
        for(int i=1;i<a.length;i++){
            int num1=Integer.parseInt(nums.substring(i-1,i));
            int num2=Integer.parseInt(nums.substring(i,i+1));
            int num=Integer.parseInt(nums.substring(i-1,i+1));
//            dp表达式  a[i]=a[i-1]+a[i-2];
            //排除特殊情况
            //当00无法转换的，直接返回与0
            //当大于26且为30-90是无法转换的，直接返回与0
            if(num==0){
                a[i]=0;
            }else if(num>26 && num2==0){
                a[i]=0;
                //或者小于26但0开头或者0结尾，只有一种可能
            }else if(num>26){
                a[i]=a[i-1];
            }else  if(num<26 && (num1==0 || num2==0)){
                a[i]=a[i-1];
            }
            else{
                //其余情况都有两种可能
                if(i==1){
                    a[i]=2;
                }else {
                    a[i]=a[i-1]+a[i-2];
                }
            }

        }
        return a[a.length-1];
    }


}
