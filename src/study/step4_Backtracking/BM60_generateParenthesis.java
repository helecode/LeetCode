package study.step4_Backtracking;

import java.util.ArrayList;

/**
 *
 * BM60 括号生成
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * 也是使用回溯的思想实现
 * 对括号进行随机排序组合，再间断错误的分支
 * 例如，n=3时，生成的括号一定是三个左括号和三个右括号
 * 当右括号比左括号多时，则肯定是不合法的
 */
public class BM60_generateParenthesis {

    public static void main(String[] args) {

    }
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> res=new ArrayList<>();
        //左括号的使用个数
        int left=0;
        //右括号的使用个数
        int right=0;
        //当前结果
        StringBuilder str=new StringBuilder();
        dfs(n,left,right,str,res);
        return res;
    }

    private void dfs(int n, int left, int right, StringBuilder str, ArrayList<String> res) {
        if(left==n && right==n){
            res.add(str.toString());
            return;
        }

        //如果左括号还没加满，则可以添加左括号
        if(left<n){
            dfs(n,left+1,right,str.append("("),res);
            //执行完毕，进行回溯
//            left=left-1; 记录的个数不需要回溯，他是基础变量，是值传递，值不会被改变
            //而str是字符串引用传递，值会被改变，需要需要删除最后一个
            str.deleteCharAt(str.length()-1);
        }
        //如果左括号还没加满，并且右括号的个数小于左括号，则可以添加右括号
        if(right<n && right<left){
            dfs(n,left,right+1,str.append(")"),res);
            //执行完毕，进行回溯
//            right=right-1;
            str.deleteCharAt(str.length()-1);
        }

    }


}