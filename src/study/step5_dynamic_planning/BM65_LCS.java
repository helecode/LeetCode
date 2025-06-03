package study.step5_dynamic_planning;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * BM65 最长公共子序列(二)
 *
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
 *
 * 如果当前字符相等，那么当前字符串的最长的字符序列等于两个字符串的前一个字符的字符串的公共子序列加1
 * 如果当前字符不相等，那么当前字符串的最长字符序列等于字符串1前一个字符和字符串2字符的公共子序列的最大长多
 * 字符串2前一个字符和字符串1字符的公共子序列的最大长度  的最大值
 */
public class BM65_LCS {
    public static void main(String[] args) {
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        //定义二维字符数组，分别表示字符串中各个子字符串的最长子序列
        if(s1.length()==0 || s2.length()==0){
            return "";
        }
        //扩大数组，方式字数组溢出和复杂判断问题，方便处理边界，表示字符1前i个数和字符2前j个数的最长公共子序列
        int c[][]=new int[s1.length()+1][s2.length()+1];
        //从1开始，避免数组下标越界
        for (int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                //如果c1[i]==c2[j]，那么当前字符串的最长的字符序列等于两个字符串的前一个字符的字符串的公共子序列加1
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                }else{
                    //如果c1[i]!=c2[j]那么当前字符串的最长字符序列等于字符串1前一个字符和字符串2字符的公共子序列的最大长多
                    // * 字符串2前一个字符和字符串1字符的公共子序列的最大长度  的最大值
                    c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
                }
            }
        }

        // 回溯找出 LCS 内容
        StringBuilder sb = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (c[i - 1][j] >= c[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        if (sb.length() == 0) {
            return "-1";
        }
        return sb.reverse().toString(); // 注意倒序

    }




}
