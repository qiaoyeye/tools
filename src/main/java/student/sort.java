package student;

public class sort {

    public static int quickSort(int []array,int lo,int hi){
        //固定的切分方式 //6,2,4,7,2,1,5,1,4
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=quickSort(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]  );
        }
        System.out.println();

    }

    //6,2,4,7,2,1,5,1,4
    public static void fastsort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

    public static void sort1(int a[],int str,int end){

        int i  =  str;
        int j = end;
        int key = a[str];

        while (i<j){

        }


    }



    public static void main(String[] args){
        int a[] ={6,2,4,7,2,1,5,1,4};
        fastsort(a,0,a.length-1);
    }
}
