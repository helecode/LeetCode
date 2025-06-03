package study.step2_twoSplitSearch;

/**
 BM21 旋转数组的最小数字
 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转
 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 请问，给定这样一个旋转数组，求数组中的最小值。
 */
public class BM21_minNumberInRotateArray {
    public static void main(String[] args) {

//        int a[]={4,4,4,4,4,4,4};
        int a[]=new int[]{2,3,4,5,6,7,1};
        int result = new BM21_minNumberInRotateArray().minNumberInRotateArray(a);
        System.out.println();
    }

    /**
     *
     *  数组旋转之后，旋转之后的数据会破坏有效
     *  采用二分法，取数组中间值，与两边值进行比较，如果那边不满足递增，
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public static int minNumberInRotateArray (int[] nums) {
        // write code here
        int left=0;
        int right=nums.length-1;
        while (left!=right){
            int mid=(left+right)/2;
            //左侧值大于中间值，代表数组左侧不是递增，所以最小值在左边，且当前值小于左侧值，当前中间值有可能是最小值
            if(nums[left]>nums[mid]){
                right=mid;
            }else if(nums[right]<nums[mid]){
                //右侧值小于中间值，代表数组右侧不是递增，所以最小值在右边，因为右侧的值小于中间值，所以当前中间值不可能是最小值
                left=mid+1;
            }if(nums[right]==nums[mid]){
                //如果等于右边，那右边不可能是最小值
                right=right-1;
            }else if(nums[right]==nums[mid]){
                left=left-1;
            }else{
                //如果既满足大于左侧，也满足小于右侧，那么这个区间的数组是有序的，最左侧的值就是最小值
                return nums[left];
            }
        }
        return nums[left];
    }


}
