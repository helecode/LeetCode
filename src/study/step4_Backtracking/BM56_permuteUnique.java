package study.step4_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * BM55 没有重复项数字的全排列
 * 给出一组数字，返回该组数字的所有排列
 *
 * 使用回溯实现
 * 状态变量
 * 1.递归到第几层 depth
 * 2.已经选了哪些数 path
 * 3.布尔数组 used
 *
 * 在回溯的基础上进行去重，修剪枝叶
 * 先对数组进行排序，将重复的值紧挨在一起
 * 如果当前值和上一个值相同，并且在同一层级，则代表被使用过，需要进行剪掉
 * 如果上一个值没有被使用（说明我们还在同一个 for 循环中，没有向下递归）
 */
public class BM56_permuteUnique {

    public static void main(String[] args) {
        new BM56_permuteUnique().permuteUnique(new int[]{1,2,3});
    }
    public ArrayList<ArrayList<Integer>> permuteUnique (int[] num) {
        //存储结果
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        int depth=0;
        Stack<Integer> path=new Stack<>();
        boolean []used=new boolean[num.length];
        Arrays.sort(num);
        dfs(num,depth,path,used,res);
        return res;

    }

    private void dfs(int[] num, int depth, Stack<Integer> path, boolean[] used,ArrayList<ArrayList<Integer>> res) {
        //递归终止条件
        if(depth==num.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<num.length;i++){
            //如果该数字已经被使用，则跳过
            if(used[i]){
                continue;
            }
//             * 如果当前值和上一个值相同，并且在同一层级，则代表被使用过，需要进行剪掉
//             * 如果上一个值没有被使用（说明我们还在同一个 for 循环中，没有向下递归）
            if(i>0 && num[i]==num[i-1] && !used[i-1]){
                continue;
            }
            //如果没有被使用，则使用该数字，并标记为使用状态
            path.add(num[i]);
            used[i]=true;
            depth=depth+1;
            //然后进行递归调用
            dfs(num,depth,path,used,res);
            //如果数字都被使用完，进弹出一个数字，并进行回溯
            path.pop();
            depth=depth-1;
            used[i]=false;
        }
    }


}
