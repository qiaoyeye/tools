package student;

import java.util.*;

public class test {
    public static void main(String[] args){
      //getMaxChar("my name name name name name name is is is is is is aa aa aa aa aa aa aa aa aa ");

      System.out.println(compressString("aaaaaaaabbbccdddeeebbba"));




    }
//    public static  int lengthOfLongestSubstring(String s) {
//
//        if(s.length()==1) return 1;
//        if(s.length()==0) return 0;
//        int i=0;
//        int j=i+1;
//        int max = 0;
//        int length =0;
//        char ch[] = s.toCharArray();
//        while(i<ch.length){
//            for(int k=i;k<j;k++){
//                if(ch[k] != ch[j]){
//                    length ++;
//                }
//            }
//            if(length>max){
//                max = length;
//            }
//        }
//        return max;
//    }
public static  int longestSubstring(String A, int n) {//abcabcff

    //charPosition统计A中每种字符之前出现的位置

    Map<Character, Integer> charPosition = new HashMap<Character, Integer>();

    //preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度

    int[] preArr = new int[A.length()];


    char[] str2charArr = A.toCharArray();

    //从头到尾遍历str2charArr，统计出以每个字符为当前位置的向前最长无重复子串的长度

    for (int i = 0; i < A.length(); i++) {

        Integer lastPosOfChar = charPosition.get( str2charArr[i] );

        if (lastPosOfChar == null) {//说明当前字符第一次出现

            //更新最长无重复子串的长度

            preArr[i] = i == 0 ? 1 : preArr[i - 1] + 1;

            //记录当前字符出现的位置

            charPosition.put( str2charArr[i], i );

        } else {//当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符

            //获取前一个字符最长无重复子串的长度

            int aPos = lastPosOfChar + 1;

            int unRepeatLen = preArr[i - 1];

            int bPos = i - unRepeatLen;

            if (aPos >= bPos) {

                //当前位置的最长无重复子串长度

                preArr[i] = i - aPos + 1;

            } else {

                //当前位置的最长无重复子串长度

                preArr[i] = i - bPos + 1;

            }

            //跟新当前字符出现的位置

            charPosition.put( str2charArr[i], i );

        }

    }

    //遍历preArr,最大值即为所求

    int max = preArr[0];

    for (int i : preArr) if (i > max) max = i;


    return max;

}

    public static int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<Character>();

        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right));
                right++;
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

  public static int lengthOfLongSubString(String s){
        if (s.length()==0)return 0;
        if (s.length()==1)return 1;
        int i = 0,j = i+1,max = 0;
        char str[] = s.toCharArray();
        boolean  t = true;
        while(i < s.length() - 1){
              int length = 1;
              //检测是否重复
              if(j == s.length()) break;
              for(int k = i; k < j;k++){
                  if(str[j] != str[k] ){
                      length++;

                  }else{
                      t = false;
                      break;
                  }
              }
              if(length > max){
                  max = length;
              }
              //如果检测成功，j指针右移一次
              if(t) j++;
                  //检测失败，i指针右移一次，j指针回到i+1的位置
              else{
                  t = true;
                  i++;
                  j = i + 1;
                  length = 1;
              }
          }
      return max;
  }

  public static int test(String s){
        if (s.length()==0) return 0;
        if (s.length()==1)return 1;
        int i=0,j=i+1,max=0;
        boolean  t = true;
        char str[] = s.toCharArray();
        while (i<s.length()-1){
            int length = 1;
            if (j==s.length()){
                break;
            }
            for (int k=0;k<j;k++){
                if (str[k]!=str[j]){
                    length++;
                }else {
                    t=false;
                    break;
                }
            }
            if (length>max){
                max=length;
            }
            if (t){
                j++;
            }else {
                t = true;
                i++;
                j=i+1;
            }
        }
      return max;
  }



  public static void getMaxChar(String str){
      Map<String,Integer> map = new HashMap<String, Integer>();
      String s[] = str.split( " " );
      int counter = 0;
      String target = null;
      for (String ss:s){
          int wcount = 1;
          if (map.containsKey(ss)){
              wcount+=map.get( ss );
          }
          map.put(ss, wcount);

          System.out.println(ss+": "+wcount);
      }
  }


    public static String reduceString(String str) {
        StringBuffer result = new StringBuffer();
        final int count = str.length();
        char c1 = str.charAt(0);
        int sum = 1;
        for (int i = 1; i < count; i++)  {
            char c2 = str.charAt(i);
            if (c1 == c2)
            {
                sum++;
                continue;
            }
            result.append(c1).append(sum);
            c1 = c2;
            sum = 1;
        }
        result.append(sum).append(c1);
        return result.toString();
    }

    public static String compressString(String str){
        StringBuilder builder = new StringBuilder();
        char[] c2 = str.toCharArray();
        char c1 = c2[0];
        int sum =1;
        for(int i=1;i<c2.length;i++){
            if (c1 == c2[i]){
                sum++;
                continue;
            }
            builder.append( c1 ).append( sum );

        }


        return builder.toString();
    }

}
