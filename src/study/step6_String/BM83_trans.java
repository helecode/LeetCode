package study.step6_String;

/**
 * BM83 字符串变形
 *
 * 思路：
 *
 *
 * step 1：逆序遍历字符串，进行字符串反转，并且进行大小写转换
 * step 2：记录输出的字符，当遇到空格或遍历到最后一个字符时，则进行反转字符串，将反转后的字符串进行拼接
 */
public class BM83_trans {
    public static void main(String[] args) {
        new BM83_trans().trans("This is a sample",16);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans (String s, int n) {
        String res="";
        String ssRevet="";
        for(int i=n-1;i>=0;i--) {
            //进行大小写转换
            char cc = s.charAt(i);
            if (cc >= 'A' && cc <= 'Z') {
                cc = (char) (cc + 32);
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                cc = (char) (cc - 32);
            } else if (cc != ' ') {
                continue;
            }
            ssRevet = ssRevet + cc;
        }
        String ss="";

        for(int i=0;i<n;i++) {
            //进行大小写转换
            char cc = ssRevet.charAt(i);
            ss=ss+cc;

            if(ss.length()>0 && (cc==' ' || i==n-1)){
                String ssReverse="";

                //反转时去除空格，空格不需要反转
                ss=ss.replace(" ","");
                //字符串长度等于1不需要反转
                if(ss.length()>1){
                    StringBuilder ssBuilder=new StringBuilder(ss);
                    ssReverse=ssBuilder.reverse().toString();
                }else {
                    ssReverse=ss;
                }

                //反转后添加空格
                if(cc==' ' ){
                    res=res+ssReverse+" ";
                }else{
                    res=res+ssReverse;
                }

                ss="";
            }
        }
        return res;
    }

}
