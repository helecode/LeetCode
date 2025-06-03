package study.step5_dynamic_planning;

/**
 * BM66 最长公共子串
 *给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 *
 * 和65题一样的思路，不同的是子串中相同的字符是需要连续的
 * 如果当前字符相等，则最长公共子串等于两个字符串的前一个字符的字符串的公共子串长度加一，再与当前最大子串长度相比，是否是最长子串，是的话则记录下边，
 * 便于后续获取子串的内容
 * 如果不是，则当前子串中相同子串的长度为0
 */
public class BM67_LCSString {
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
        //扩大数组，方式字数组溢出和复杂判断问题，方便处理边界
        int c[][]=new int[s1.length()+1][s2.length()+1];
        //记录最大子串的长度
        int maxLength=0;
        //记录最大子串长度是s1的下标
        int index=0;
        //从1开始，避免数组下标越界
        for (int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                //如果当前字符相等，则最长公共子串等于两个字符串的前一个字符的字符串的公共子串长度加一
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                    if(c[i][j]>maxLength) {
                        maxLength=c[i][j];
                        index=i;
                    }
                }
            }
        }

        return s1.substring(index-maxLength,index);
    }


}
