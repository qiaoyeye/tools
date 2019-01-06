package student;


import java.util.ArrayList;
import java.util.List;

public class Subsets {

  //  给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//    nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//    输出： True
//    说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。


    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++)
            sum += nums[i];

        if(sum % k != 0 ) return false;
        int avg = sum / k;
        boolean[] flag = new boolean[len];
        return  test(nums,flag,k,avg,avg,0);
        // return help(nums,flag,avg,k,avg,0);
    }

    public static boolean help(int[] nums, boolean[] flag, int avg, int k, int temp, int index ){

        if (k == 0 ) return true;

        if (temp == 0)
            return help(nums,flag,avg,k-1,avg,0);

        for (int i = index; i < nums.length; i++) {
            if (flag[i] == true) continue;

            flag[i] = true;
            System.out.println( temp-nums[i] );
            if(temp-nums[i]>=0 && help(nums,flag,avg,k,temp-nums[i],index+1)){
                return true;
            }
            flag[i] = false;

        }

        return false;
    }

    public static boolean test(int[] nums,boolean[] flag,int k,int avg,int temp,int index){
        if(k==0){return true;}
        if(temp==0){
           return test(nums,flag,k-1,avg,avg,0);
        }
        for(int i=index;i<nums.length;i++){
            if(flag[i] == true) continue;
            flag[i] = true;
            if(temp-nums[i]>=0 && test(nums,flag,k,avg,temp-nums[i],i+1)){
                return true;
            }
            flag[i] = false;

        }

        return false;
    }
    public static void main(String[] args){
//        int[] a = {4, 3, 2, 3, 5, 2, 1};[[1,3],[2,6],[8,10],[15,18]]
//       System.out.println(  canPartitionKSubsets(a,4 ) );
        List<Interval> intervals = new ArrayList<Interval>(  );
        Interval ss = new Interval(  );
        Interval ss1 = new Interval(  );
        Interval ss2 = new Interval(  );
        Interval ss3 = new Interval(  );
        ss.start=1;
         ss.end=3;
        intervals.add(ss);
        ss1.start=2;
        ss1.end=6;
        intervals.add(ss1);
        ss2.start=8;
        ss2.end=10;
        intervals.add(ss2);
        ss3.start=15;
        ss3.end=18;
        intervals.add(ss3);

       System.out.println(  merge(intervals  ).get( 0 ).end);


    }

/*************************************************************************************************************/

//    输入      [[1,3],[2,6],[8,10],[15,18]]
//    输出: [[1,6],[8,10],[15,18]]
//    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].


    public static List<Interval> merge(List<Interval> intervals) {
        int index=0;

        List<Interval> list   = new ArrayList<Interval>();
        List<Integer> stlist = new ArrayList<Integer>(  );
        List<Integer> edlist = new ArrayList<Integer>(  );
        for(int i=0;i<intervals.size();i++){
            stlist.add(intervals.get(i).start);
            edlist.add(intervals.get(i).end);
        }
        for (int i = 0;i<stlist.size()-1;i++){
            Interval interval = new Interval(  );
            if (edlist.get( i )>=stlist.get( i + 1 )){
                System.out.println( edlist.get( i ) );
                System.out.println(stlist.get( i + 1 ));
                interval.start = stlist.get( i );
                interval.end = edlist.get( i+1 );
                i = i+1+1;
                list.add( interval );
            }else {
                System.out.println( edlist.get(i) );
                System.out.println(stlist.get(i));
                interval.start = stlist.get( i );
                interval.end = edlist.get( i );
                list.add( interval );
            }
        }

       return list;
    }


}
