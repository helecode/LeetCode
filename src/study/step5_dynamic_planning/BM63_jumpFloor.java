package study.step5_dynamic_planning;

/**
 * BM63 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 因为一次可以上1级或者两级，所以当前台阶=上一级台阶的跳法+上上一级台阶的跳法
 */
public class BM63_jumpFloor {
    public static void main(String[] args) {
        new BM63_jumpFloor().jumpFloor2(7);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param number int整型
     * @return int整型
     */
    public int jumpFloor (int number) {
        // write code here
        if(number<=1){
            return number;
        }
        return jumpFloor(number-1)+jumpFloor(number-2);

    }


    /**
     * 将之前的结果存起来，从下往上计算，避免多次重复计算
     * @param number
     * @return
     */
    public int jumpFloor2 (int number) {
        // write code here
        int count[]=new int[number+1];
        for(int i=0;i<number;i++){
            if(i==0 || i==1 ){
                count[i]=i+1;
            }else{
                count[i]=count[i-1]+count[i-2];
            }

        }
        return count[number-1];
    }

}
