package study.step5_dynamic_planning;

/**
 * BM62 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 * 斐波那契数列是一个满足 fib(x−1)+fib(x−2)
 *
 */
public class BM61_Fibonacci {


    public int Fibonacci (int n) {
       if(n==1 || n==2){
           return 1;
       }
      return Fibonacci(n-1)+Fibonacci(n-2);
    }



}
