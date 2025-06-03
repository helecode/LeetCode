package study.step7_doublePoint;

/**
 * BM88 判断是否为回文字符串
 * 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 * 字符串回文指该字符串正序与其逆序逐字符一致。
 *
 * 使用双指针实现
 * step 1：创建两个指针，一个在字符串首，一个在字符串尾。
 * step 2：在首的指针往后走，在尾的指针往前走，依次比较路过的两个字符是否相等，若是不相等则直接就不是回文。
 *
 */
public class BM88_judge {

    public static void main(String[] args) {
        new BM88_judge().judge("abaa");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        //定义两个指针，一个指向首一个指向尾
        int begin=0;
        int end=str.length()-1;
        while (end>=begin){
            if(str.charAt(begin)!=str.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

}
