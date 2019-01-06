package student;

public class aa {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] longestPath = new int[1];
            getUnivaluePathCount(root, longestPath);
            return longestPath[0];
        }

        private int getUnivaluePathCount(TreeNode node, int[] longestPath) {
            int left = 0;
            if (node.left != null) {
                left += getUnivaluePathCount(node.left, longestPath);
                if (node.val == node.left.val) {
                    /* 如果本节点和左节点值相同，路径能继续，再累加1 */
                    left += 1;
                } else {
                    /* 否则，就说明左边的路径已经断开，本节点的左方向的单向路径值清零 */
                    left = 0;
                }
            }

            int right = 0;
            if (node.right != null) {
                right += getUnivaluePathCount(node.right, longestPath);
                if (node.val == node.right.val) {
                    /* 如果本节点和右节点值相同，路径能继续，再累加1 */
                    right += 1;
                } else {
                    /* 否则，就说明右边的路径已经断开，本节点的右方向的单向路径值清零 */
                    right = 0;
                }
            }
            int currentLongestPath;
            if (node.left != null && node.right != null && node.left.val == node.right.val) {
                /* 如果左右节点的值相同，那么可以相加连接起来。但如果左右相同但和本节点值不同，那么left和right的值都是0 */
                currentLongestPath = left + right;
            } else {
                /* 否则，最大的路径值只能是左右路径的最大值 */
                currentLongestPath = Math.max(left, right);
            }
            if (currentLongestPath > longestPath[0]) {
                /* 最终返回的结果在这里，每次递归都是以当前节点为核心，计算最大路径值，在多次递归当中，仅保留最大的值 */
                longestPath[0] = currentLongestPath;
            }
            /* 递归返回的是本节点与左右两个子节点的同值路径的最大值，注意，如果本节点的值与左右节点的值都不同，那么返回的是0 */
            return Math.max(left, right);
        }


    public static int findTwoPoint(int[] array,int key){
        int start = 0;
        int last = array.length-1;
        while(start <= last){
            int mid = (last-start)/2+start;//防止直接相加造成int范围溢出
            if(key == array[mid]){//查找值等于当前值，返回数组下标
                return mid;
            }
            if(key > array[mid]){//查找值比当前值大
                start = mid+1;
            }
            if(key < array[mid]){//查找值比当前值小
                last = mid-1;
            }
        }
        return -1;
    }

    /**
     *
     * @param Array
     * @param len
     */

    public static  void reSortArray(int Array[], int len)
    {

        int NextNegPos = 0;
        for (int idx = 0; idx < len; idx++)
        {
            if (Array[idx] < 0)
            {
                int tmp = Array[idx];

                for (int j = idx-1; j >= NextNegPos; j--)
                {
                    Array[j+1] = Array[j];
                }
                Array[NextNegPos] = tmp;
                NextNegPos++;
            }
        }

        int NextZeroPos = NextNegPos;
        for (int idx = NextZeroPos; idx < len; idx++)
        {
            if (Array[idx] == 0)
            {
                for (int j = idx-1; j >= NextZeroPos; j--)
                {
                    Array[j+1] = Array[j];
                }
                Array[NextZeroPos] = 0;
                NextZeroPos++;
            }
        }

    }

    //快排序
    public static final void quickSort(int[] a, int low, int hign ) {
        if(hign <= low) return; // 如果hign 小于等于 low ,说明待排序队列只包含一个元素，无法再排序

        int keyIdx = asort(a, low, hign);

        if( ! (keyIdx == low && low == hign) ) { // keyIdx == low && low == hign 则说明不可分
            if(keyIdx == low ) { //说明左边已经排好序了
                quickSort(a, low + 1, hign);
            } else if  (keyIdx == hign ) {  // 说明右边已经排序好了
                quickSort(a, low, hign -1);
            } else {
                quickSort(a, low , keyIdx -1); // 关键字左边排序
                quickSort(a, keyIdx + 1, hign); // 关键字右边排序
            }
        }

    }

    private static final int asort(int[] a, int low, int hign) {
        int key = a[low];

        loop :
        while (true) { // low 与 hign 相等时退出
            while( hign > 0 ) {

                if( a[hign] < key ) {
                    swap(a, low, hign);   // 从后向前找，找到第一个比关键字小的元素后交换元素后跳出本次比较
                    break;
                }

                hign --;

                if(low == hign) break loop;
            }

            low ++;
            if(low == hign) break loop;

            while( low < a.length ) {
                if( a[low] > key ) {   // 从前向后找，找到第一个比关键字大的元素时交换元素后跳出本次比较
                    swap(a, low, hign);

                    break;
                }

                low ++;
                if(low == hign) break loop;
            }
        }
        return low;//关键字所在的位置
    }

    /**
     * 交换数组中两个元素的位置
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 快排序
     * @param
     */

        public static void sort(int[] a, int low, int high) {
            if(low>=high)
                return;
            int i = low;
            int j = high;
            int key = a[i];
            while (i < j) {
                while (i < j && a[j] >= key)
                    j--;
                a[i++] = a[j];
                while (i < j && a[i] <= key)
                    i++;
                a[j--] = a[i];
            }
            a[i] = key;
            sort(a,low,i-1);
            sort(a,i+1,high);
        }

        public static void quickSort(int[] a) {
            sort(a, 0, a.length-1);
            for(int i:a)
                System.out.print(i+" ");
        }





        public static void main(String[] args){
//           aa aa = new aa();
//           String str = "[3,9,20,null,null,15,7]"
//           TreeNode t = new TreeNode(str.length());
//           // TreeNode node = TreeNode..mkTree(str);
//           aa.longestUnivaluePath(t);
//        int a[] = {2,2,3,4,5,6};
//       findTwoPoint(a,1);
//       int a[]={-1,3,5,2,-1,-12,-2,0};
//       reSortArray(a,8);

       int[] a = new int[] {1,3,4,12,32,9,4,8,22};
            sort(a, 0, a.length -1);
       System.out.println("排序后结果：");
       for(int i : a) {
           System.out.print(i + " ");
       }






   }



}
