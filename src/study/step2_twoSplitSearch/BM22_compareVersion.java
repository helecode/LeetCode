package study.step2_twoSplitSearch;

/**
 * BM22 比较版本号
 牛客项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
 现在给你2个版本号version1和version2，请你比较他们的大小
 版本号是由修订号组成，修订号与修订号之间由一个"."连接。1个修订号可能有多位数字组成，修订号可能包含前导0，且是合法的。例如，1.02.11，0.1，0.2都是合法的版本号
 每个版本号至少包含1个修订号。
 修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。

 比较规则：
 一. 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。比如"0.1"和"0.01"的版本号是相等的
 二. 如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，"1.1"的版本号小于"1.1.1"。因为"1.1"的版本号相当于"1.1.0"，第3位修订号的下标为0，小于1
 三.  version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
 */
public class BM22_compareVersion {
    public static void main(String[] args) {
        int result = new BM22_compareVersion().compareVersion("1.0.1","1");
        System.out.println();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     * 将版本号的每个修订号进行拆分，分别比较每个修订号的大小，大于值胜出
     */
    public static int compareVersion (String version1, String version2) {
        if(version1==null && version2==null) return 0;
        else if(version1==null) return -1;
        else if(version2==null) return 1;
        //第一个版本号的指针
        int a=0;
        int b=0;
        //只有当两个都遍历完才算结束
        while (a<version1.length() || b<version2.length()){
            //默认值为0，防止存在空值，例如1和1.0
            String aVersion="0";
            String bVersion="0";
            while ( a<version1.length() && version1.charAt(a)!='.' ){
                aVersion=aVersion+version1.charAt(a);
                a++;
            }
            while (b<version2.length() && version2.charAt(b)!='.' ){
                bVersion=bVersion+version2.charAt(b);
                b++;
            }

            if(Integer.parseInt(aVersion)>Integer.parseInt(bVersion)){
                return 1;
            }else if(Integer.parseInt(aVersion)<Integer.parseInt(bVersion)){
                return -1;
            }else {
                b++;
                a++;
            }
        }
        return 0;
    }

}
