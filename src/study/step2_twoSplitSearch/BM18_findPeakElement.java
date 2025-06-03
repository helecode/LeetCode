package study.step2_twoSplitSearch;

/**
 BM16 删除有序链表中重复的元素-II
 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 1-1-1-2-3
 2-3
 */
public class BM18_findPeakElement {
    public static void main(String[] args) {

        int a[]={4,4,4,4,4,4,4};
        int result = new BM18_findPeakElement().search(a);
        System.out.println();
    }

    /**
     * 因为题目将数组边界看成最小值，而我们只需要找到其中一个波峰，因此只要不断地往高处走，一定会有波峰。
     * 那我们可以每次找一个标杆元素，将数组分成两个区间，每次就较高的一边走，因此也可以用分治来解决，而标杆元素可以选择区间中点。
     *
     * 一个数组肯定存在波峰
     *
     * step 1：二分查找首先从数组首尾开始，每次取中间值，直到首尾相遇。
     * step 2：如果中间值的元素大于它右边的元素，说明往右是向下，则说明波峰在左边，且当前点可能是波峰。
     * step 3：如果中间值小于右边的元素，说明此时往右是向上，则说明波峰在右边，且当前点不可能是波峰。
     * step 4：最后区间收尾相遇的点一定就是波峰。
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int search (int[] nums) {
        if (nums==null && nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1]){
                //因为右边是下降，所以波峰在左边,且当前点可能是波峰
                right=mid;
            }else if(nums[mid]<=nums[mid+1]){
                //因为左边是上升，所以波峰可能在右边，且当前点不可能是波峰
                left=mid+1;
            }
        }
        return right;
    }
}
