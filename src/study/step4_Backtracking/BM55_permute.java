package study.step4_Backtracking;

import java.util.*;

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
 */
public class BM55_permute {

    public static void main(String[] args) {
        new BM55_permute().permute(new int[]{1,2,3});
    }
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        //存储结果
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        int depth=0;
        Stack<Integer> path=new Stack<>();
        boolean []used=new boolean[num.length];
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
