package study.step2_twoSplitSearch;

import java.util.Arrays;

/**
 BM20 数组中的逆序对
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 */
public class BM20_InversePairs {
    public static void main(String[] args) {

//        int a[]={4,4,4,4,4,4,4};
//        int result = new BM20_InversePairs().InversePairs(a);
        int a[]=new int[]{7,5,6,4};
        int result = new BM20_InversePairs().InversePairs(a);
        System.out.println();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 如果把一个数组的升序看做是有序的，那么逆序对的个数就是排序时需要进行对换位置的个数
     * 所以对数组进行归并排序，当前面的数大于后的数时，则代表存在逆序对，逆序对的个数取决于该数后面有几个数
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    static int inversePairsCount=0;
    public static int InversePairs (int[] nums) {
        //对数组进行归并
        sort(nums);
        return inversePairsCount;
    }

    public static int[] sort (int[] nums) {
        if(nums==null) return nums;
        if(nums.length==1) return nums;
        int mid=nums.length/2;
        return mergeSort(sort(Arrays.copyOfRange(nums,0,mid)),sort(Arrays.copyOfRange(nums,mid,nums.length)));
    }

    //对两个有序数据进行排序
    public static int[] mergeSort(int a[],int b[]){
        //a数组的指针
        int i=0;
        //数组的指针
        int j=0;
        //合并后有序的数据的指针
        int sortArr[]=new int[a.length+b.length];
        int k=0;
        //逆序对的个数
        while (i<a.length && j<b.length){
            if(a[i]<b[j]){
                sortArr[k]=a[i];
                i++;
            }else{
                //a、b数组是升序的，本身不存在逆序对
                //当a当前值数组大于b数组当前值时，则存在逆序对，并且a当前值之后的值夜大于b当前值
                //所以a位置逆序对的个数为a.length-i
                sortArr[k]=b[j];
                j++;
                inversePairsCount=inversePairsCount+a.length-i;
            }
            k++;
        }
        //当其中一个数组排完成之后，另外一个数组就是有序的，直接追加到拍完的数组后面就行

        for(;i!=a.length;i++){
            sortArr[k]=a[i];
        }
        for(;j!=b.length;j++){
            sortArr[k]=b[j];
            k++;
        }
        return sortArr;
    }
}
