package study;

public class Test {
    public static void main(String[] args) {
        int a[]={54,234,12,65,76,34,3,1,5,33};
        //冒泡排序，两个元素之间相互排序，将最值冒到最后
        for(int i=0;i<a.length;i++){
            for (int j=0;j<a.length-i-1;j++){
                if(a[j]<a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        for (int b:a){
            System.out.print(b+ " ");
        }
        System.out.println();
        //选择排序,每一轮记录最大值的下标，后面的每个元素和前面1进行排序
        for(int i=0;i<a.length;i++){
            int k=i;
            for(int j=i+1;j<a.length;j++){
                if(a[k]>a[j]){
                    k=j;
                }
            }
            if(k!=i){
                int t=a[k];
                a[k]=a[i];
                a[i]=t;
            }
        }
        for (int b:a){
            System.out.print(b+ " ");
        }
    }

}
