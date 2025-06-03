package study.step6_String;

/**
 * BM84 最长公共前缀
 * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 *
 * 解法二：横向扫描
 * 默认公共前缀为第一个字符串
 * 确定公共字符与第1个字符串子串相同的公共前缀
 * 将上面找到的前缀K与第2个子串进行对比，得到他们的公共前缀K1
 * 重复上述步骤，最终得到字符串的最长公共前缀
 *
 */
public class BM84_longestCommonPrefix {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        // write code here
        if(strs.length==0){
            return "";
        }
        else if(strs.length==1){
            return strs[0];
        }
        //默认公共前缀是第一个字符串
        String commonStr=strs[0];
        for(int i=1;i<strs.length;i++){
            commonStr=getStrCommon(commonStr,strs[i]);
            if(commonStr.length()==0){
                break;
            }
        }
        return commonStr;
    }

    /**
     * 获取两个字符串的公共前缀
     * @param s1
     * @param s2
     * @return
     */
    public String getStrCommon(String s1,String s2){
        int maxLen=Math.min(s1.length(),s2.length());
        String commonStr="";
        for(int i=0;i<maxLen;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                commonStr=commonStr+s1.charAt(i);
            }
        }
        return commonStr;
    }
}
