package study.step6_String;

/**
 * BM86 大数加法
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 *
 * 将字符串拆分为字符数组，依次去数组中取最后元素进行计算
 * 直到两个数组下标都小于0，并且通过一个全局变量处理进位问题
 *
 */
public class BM86_bigNumberAdd {

    public static void main(String[] args) {
        new BM86_bigNumberAdd().solve("1","99");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        if((s==null || s.length()==0) && (t==null || t.length()==0))
            return  "";
        if(s==null || s.length()==0) 
            return  t;
        if(t==null || t.length()==0)
            return  s;
        char sc[]=s.toCharArray();
        char tc[]=t.toCharArray();
        StringBuilder res=new StringBuilder();
        //需要进位的数字
        int up=0;
        for(int i=0;i<sc.length || i<tc.length;i++){
            //个为在最后面，所有需要进行逆序
            char scc='0';
            char tcc='0';
            if(sc.length-i-1>=0){
                scc=sc[sc.length-i-1];
                if(scc<'0' && scc>'9'){
                    return "";
                }
            }
            if(tc.length-i-1>=0){
                tcc=tc[tc.length-i-1];
                if(tcc<'0' || tcc>'9'){
                    return "";
                }
            }
            int sccNumber=Integer.parseInt(String.valueOf(scc));
            int tccNumber=Integer.parseInt(String.valueOf(tcc));
            res.append((sccNumber+tccNumber+up)%10);
            up=(sccNumber+tccNumber+up)/10;
        }
        //如果最后计算时有进位也需要加上
        if(up!=0){
            res.append(up);
        }
        return res.reverse().toString();
    }
}
