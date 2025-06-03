package study.step7_doublePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * BM91 反转字符串
 *
 * 使用双指针进行处理
 * 第一个指针指向第一个字符，第二个指针指向第二个字符，然后交换他们的位置
 * 直到第二个指针大于第一个指针代表交换结束
 *
 */
public class BM91_reverseString {

    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        if(str.length()==0 || str.length()==1) return  str;
        StringBuilder res=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            res.append(str.charAt(i));
        }
        return res.toString();
    }


}

