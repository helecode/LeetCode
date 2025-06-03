package study.step_simulation;

/**
 *BM97 旋转数组
 * 一个数组A中存有 n 个整数，在不允许使用另外数组的前提下
 * 将每个整数循环向右移 M（ M >=0）个位置
 * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）
 * （最后 M 个数循环移至最前面的 M 个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 通过三次三次翻转实现
 *
 * 循环右移相当于从第m个位置开始，左右两部分视作整体翻转
 * 即abcdefg右移3位efgabcd可以看成AB翻转成BA(可以用到reverse函数。)
 *
 * 具体步骤:
 * step1：第一次将整个数组翻转，得到数组的逆序，它已经满足了右移的整体出现在了左边。
 * step2：第二次就将左边的m个元素单独翻转，因为它虽然移到了左边，但是逆序了。
 * step3：第三次就将右边的n−mn−m个元素单独翻转，因此这部分也逆序了。
 */
public class BM97_rotateArray {

    public static void main(String[] args) {
        new BM97_rotateArray().solve(1,5,new int[]{5});
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        //防止m超过n的长度
        m=m%n;
        if(m==0) return a;
        // write code here
        //翻转数组
        for(int i=0;i<n/2;i++){
            int t=a[i];
            a[i]=a[n-1-i];
            a[n-1-i]=t;
        }
        //以k位置为两边，分别进行翻转
        //翻转前半部分
        swap(0,m-1,a);
        //翻转后半部分
        swap(m,n-1,a);
        return a;
    }

    /**
     * 局部翻转数组
     */
    public void swap(int begin,int end,int[] a){
        for(int i=begin;i<=(begin+end)/2;i++){
            int t=a[i];
            a[i]=a[begin+end-i];
            a[begin+end-i]=t;
        }
    }

}
