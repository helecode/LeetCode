package study.step4_Backtracking;

/**
 *
 * BM53 缺失的第一个正整数
 * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 *
 * 如果每个数字都正常出现，那么排序后下标i的值应该是i+1，通过对数组进行遍历，将数组中的值放在对应的下标也就是值-1的位置
 * 之后再对数组进行遍历，当出现第一个下标不等于下标+1的值，那么该数则是缺失的数
 */
public class BM53_minNumberDisappeared {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberDisappeared (int[] nums) {
        int res[]=new int[nums.length];
        int result=nums.length+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=nums.length){
                res[nums[i]-1]=-1;
            }
        }
        for(int i=0;i<res.length;i++){
            if(res[i]!=-1){
                result=i+1;
                break;
            }
        }
        return result;
    }

}
