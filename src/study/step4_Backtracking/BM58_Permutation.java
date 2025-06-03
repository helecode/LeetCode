package study.step4_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * BM58 字符串的排列
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
 *
 * 使用回溯，和56题一样的思路
 * 将字符串差分为字符数组进行处理
 */
public class BM58_Permutation {

    public static void main(String[] args) {

    }
    public ArrayList<String> Permutation (String str) {
        // write code here
        ArrayList<String> res=new ArrayList<>();
        char[] charArr=str.toCharArray();
        Arrays.sort(charArr);
        //记录已经组合的字符形成的字符串
        StringBuilder stringBuilder=new StringBuilder();
        //记录已经记录的数据
        boolean used[]=new boolean[charArr.length];
        dfs(charArr,stringBuilder,used,res);
        return res;
    }

    private void dfs(char[] charArr, StringBuilder stringBuilder, boolean[] used, ArrayList<String> res) {
        //如果字符串长度和字符长度相同，则代表已经组装完毕
        if(stringBuilder.length()==charArr.length){
            res.add(stringBuilder.toString());
            return;
        }
        for(int i=0;i<charArr.length;i++){
            //如果已经被使用，则跳过
            if(used[i]){
                continue;
            }
            if(i>0 && charArr[i]==charArr[i-1] && !used[i-1]){
                continue;
            }
            used[i]=true;
            stringBuilder=stringBuilder.append(charArr[i]);
            dfs(charArr,stringBuilder,used,res);
            //如果已经执行到最后，则进行回溯
            used[i]=false;
            stringBuilder=stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }


}
