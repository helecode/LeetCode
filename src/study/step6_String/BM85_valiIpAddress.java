package study.step6_String;

/**
 * BM85 验证IP地址
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
 * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
 *
 */
public class BM85_valiIpAddress {

    public static void main(String[] args) {
        new BM85_valiIpAddress().solve("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        // write code here
        String res="Neither";
        if(IP.contains(":")){
            //ipv6地址
            res=isIpv6(IP);
        }else{
            //ipv4地址
            res=isIpv4(IP);
        }
        return res;
    }

    public String isIpv4(String IP){
        String IPArr[]=IP.split("\\.",-1);
        String res="IPv4";
        //长度为4
        if(IPArr.length!=4){
            res="Neither";
        }else{
            for(int i=0;i<res.length();i++){
                String ip1=IPArr[i];
                for(int j=0;j<ip1.length();j++){
                    char c=ip1.charAt(j);
                    //由1-9组成
                    if(c < '0' || c > '9'){
                        res="Neither";
                        return res;
                    }
                }
                //内容不能为空，最大值不能超过255
                if(ip1.length()==0 || Integer.parseInt(ip1)>255){
                    res="Neither";
                    break;
                }else if(ip1.length()>1 && ip1.startsWith("0")){
                //不为0时不可以0开头
                    res="Neither";
                    break;
                }
            }
        }
        return res;
    }

    public String isIpv6(String IP){
        String IPArr[]=IP.split(":", -1);
        String res="IPv6";
        //长度为8
        if(IPArr.length!=8){
            res="Neither";
        }else{
            for(int i=0;i<IPArr.length;i++){
                String ip1=IPArr[i];
                //内容不能为空，且长度不能大于4
                if(ip1.length()==0 || ip1.length()>4){
                    res="Neither";
                }
                for(int j=0;j<ip1.length();j++){
                    char c=ip1.charAt(j);
                    //存在字母的话不能超过f，而且需要考虑大小写
                    if((c >= 'A' && c <= 'Z') &&  c>'F'){
                        res="Neither";
                    }else  if((c>='a' && c<='z') &&  c>'f'){
                        res="Neither";
                    }
                }
            }
        }
        return res;
    }
}
