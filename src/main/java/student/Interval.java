package student;

public class Interval {

    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    public static int[] sort1(int a[],int str,int end){
        int i = str;
        int j = end;
        int key = a[str];
        while (i<j){
            while (i<j && a[j]>=key){
                j--;
            }
            if (a[j]<=key){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
            while (i<j && a[i]<=key){
                i++;
            }
            if (a[i]>=key){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (i>str)sort1( a,str,i-1 );
        if (j<end)sort1( a,j+1,end );
        return a;
    }



    public static void quicksort(int a[],int str,int end){
        int i = str;
        int j = end;
        int key = a[str];
        while (i<j){
            while (i<j && a[j]>=key){
                j--;
            }
            if (a[j]<=key){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
            while (i<j && a[i]<=key){
                i++;
            }
            if (a[i]>=key){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }


        }


        if (i>str)quicksort( a,str,i-1 );
        if (j<end)quicksort( a,j+1,end );
    }




  public static void main(String[] args){

      int a[] ={6,2,4,7,2,1,5,1,4};

     quicksort(a,0,a.length-1);
  }

}
