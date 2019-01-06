package student;

import java.util.*;

public class solution {
    public static  boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();//3
        int l2 = s2.length();//4
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }
        for (int i=0;i<c1.length;i++){
            System.out.print( c1[i] );
        }
         System.out.println( "" );
        for(int i=0;i<l2;i++)
        {
            if(i>=l1){
                --c2[s2.charAt(i-l1)-'a'];//先把坐标查过的
            }
            c2[s2.charAt(i)-'a']++;
            for (int j=0;j<c2.length;j++){
                System.out.print( c2[j] );
            }
            System.out.println(  );
            if(Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }

    //类似冒泡（非冒泡）
    public static void  bubbleSort(int a[]){
        if (a.length<=1){
            return ;
        }
        int temp;
        for (int i=0;i<a.length-1;i++){
            for (int j=i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    temp = a[i];
                    a[i]= a[j];
                    a[j]=temp;
                }
            }
        }
        for (int i=0;i<a.length;i++){
            System.out.print( a[i]+"," );
        }


    }
    //冒泡
    public static void  bubbleSort1(int a[]){
        if (a.length<=1){
            return ;
        }
        int temp;
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a.length-1;j++){
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j]= a[j+1];
                    a[j+1]=temp;
                }
            }

        }
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" "  );
        }

    }

    //插入排序
    public static  void doInsertSort(int a[]){

        for(int index = 1; index<a.length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = a[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && a[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                a[leftindex+1] = a[leftindex];
                leftindex--;
            }
            a[leftindex+1] = temp;//把temp放到空位上
        }
    }


    /**
     * 选择排序算法
     */
    public static void chooseSort(int a[]){
        for(int i=0; i<a.length-1; i++){
            int min = i;
            for(int j=min+1;j<a.length;j++){
                if(a[j]<a[min]){
                     min=j;
                }
            }
                int tem = a[i];
                a[i] = a[min];
                a[min] = tem;
        }
        for (int i=0;i<a.length;i++){
            System.out.println( a[i]+"" );
        }
    }



    public List<List<Integer>> get3Sum(int[] S){
        List<List<Integer>> list  = new ArrayList<>();

        List<List<Integer>> list2  = new ArrayList<>();


        if(S.length<3 || S==null){
            return null;
        }
        //接收拼接的字符串
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<S.length; i++){
            for(int j=0; j<S.length; j++){
                for(int z=0; z<S.length; z++){
                    //筛选出不是递减的一组元素
                    if(S[i]<=S[j] && S[j]<=S[z]) {
                        int sum = S[i] + S[j] + S[z];
                            if (sum == 0) {
                                List<Integer> list1 = new ArrayList<Integer>();
                                list1.add( S[i] );
                                list1.add( S[j] );
                                list1.add( S[z] );
                                list.add( list1 );
                        }
                    }
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>(  );
          for (int i=0;i<list.size();i++ ){
              set.add( list.get( i ) );
          }

        for (List<Integer> str : set) {
            list2.add( str );
        }

        return list2;
    }

    /**
     * @Title: threeSum
     * @Description: 参考
     * @param @param nums
     * @param @return
     * @return List<List<Integer>>
     * @throws
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums != null && nums.length > 2) {
            // 先对数组进行排序
            Arrays.sort(nums);

            // i表示假设取第i个数作为结果
            for (int i = 0; i < nums.length - 2; ) {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;

                while (j < k) {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] == -nums[i]) {
                        // 将结果添加到结果含集中
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        // 移动到下一个位置，找下一组解
                        k--;
                        j++;

                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和大于0
                    else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和小于0
                    else {
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }

                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }



    public Set<String> get3Sum1(int[] S){

        if(S.length<3 || S==null){
            return null;
        }

        //接收拼接的字符串
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<S.length; i++){
            for(int j=0; j<S.length; j++){
                for(int z=0; z<S.length; z++){
                    //筛选出不是递减的一组元素
                    if(S[i]<=S[j] && S[j]<=S[z]){
                        int sum = S[i] + S[j] + S[z];
                        if(sum==0){
                            String str = "("+S[i]+","+S[j]+","+S[z]+")";
                            sb.append(str+";");
                        }
                    }
                }
            }
        }

        String s = sb.toString();
        s = s.substring(0, sb.length()-1);
        String[] arr = s.split(";");

        Set<String> set = new HashSet<String>();
        //将所筛选出来的元素放入Set集合中，去重
        for (int k = 0; k < arr.length; k++) {
            set.add(arr[k]);
        }
        System.out.println(set);
        return set;
    }



    public static void main(String[] args){

        int[] S = {-1, 0, 1, 2, -1, -4,-3,-4,4,3};
      System.out.print( new solution().get3Sum(S) );


        // chooseSort( new int[]{333, 0, 3, 12, 5, 0, 1} );

      //System.out.println(checkInclusion("qwe","rqwe"));
   }
}
