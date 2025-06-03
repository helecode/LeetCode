package study.step2_twoSplitSearch;

/**
 BM16 删除有序链表中重复的元素-II
 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 1-1-1-2-3
 2-3
 */
public class BM17_twoSplitSearch {
    public static void main(String[] args) {

        int a[]={-1,0,3,4,6,10,13,14};
        int result = new BM17_twoSplitSearch().search(a,-100);
        System.out.println();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        if(nums==null || nums.length==0) return -1;
        int result=-1;
        int begin=0;
        int end=nums.length-1;
        while (end<=nums.length-1 && begin>=0 && end>=begin){
            int currIndex=(begin+end)/2;
            if(nums[currIndex]>target){
                end=currIndex-1;
            }else if(nums[currIndex]<target){
                begin=currIndex+1;
            }else{
                result=currIndex;
                break;
            }
        }
        return result;
        }
}
