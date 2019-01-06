package student;

import java.util.ArrayList;
import java.util.List;

//输入: ["flower","loww","flight"]
//输出: "fl"
public class longestCommonPrefix {

    public static String test(String[] strs){
        String temp = "";
        if (strs.length == 0 || strs[0].equals("")){
            return "";
        }

        temp = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() == 0){
                return "";
            }else
                if(strs[i].length() < temp.length()){
                boolean flag = false;
                for (int j = 0; j < strs[i].length(); j++) {
                    System.out.println( temp.charAt(j) );

                    System.out.println(strs[i].charAt(j));
                    if (temp.charAt(j) != strs[i].charAt(j)) {
                        temp = strs[i].substring(0, j);
                        flag = true;
                        break;
                    }
                    if(flag || j == strs[i].length()-1)
                        temp = strs[i];
                }
            }else{
                System.out.println( "ssss" );
                for (int j = 0; j < temp.length(); j++)
                    if (temp.charAt(j) != strs[i].charAt(j)) {
                        temp = strs[i].substring(0, j);
                        break;
                    }else {
                        System.out.println( "qqqq" );
                    }
            }

        }

        return temp;
    }


    public static String test1(String[] strs){
        if (strs.length==0||strs[0].equals( "" )){
            return "";
        }
        String temp = strs[0];
        for (int i=1;i<strs.length;i++){
            if (strs[i].length()==0){
                return "";
            }else
            if (temp.length() > strs[i].length()){
                //boolean flag = false;
                for (int j=0;j<strs[i].length();j++){
                    System.out.println( temp.charAt(j) );

                    System.out.println(strs[i].charAt(j));
                    if (temp.charAt(j) != strs[i].charAt(j)){
                        temp = strs[i].substring( 0,j );
                        //flag=true;
                        break;
                    }
                    if(j == strs[i].length()-1)
                        temp = strs[i];
                    }

                }else {
                for (int j=0;j<temp.length();j++){
                    if (temp.charAt( j )!=strs[i].charAt( j )){
                        temp=strs[i].substring( 0,j );
                        break;
                    }
                }


            }
        }


        return temp;

    }
    public static String test2(String[] strs){
        String temp = "";
        if(strs.length==0||strs[0].equals("")){
            return "";
        }
        temp = strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<temp.length()){
                for(int j=0;j<strs[i].length();j++){
                    if(temp.charAt(j)!=strs[i].charAt(j)){
                        temp=strs[i].substring(0,j);
                        break;
                    }
                    if(j==strs[i].length()-1){
                        temp = strs[i];
                    }
                }
            }else{
                for(int j=0;j<temp.length();j++){
                    if(temp.charAt(j)!=strs[i].charAt(j)){
                        temp=strs[i].substring(0,j);
                        break;
                    }

                }
            }
        }

        return temp;

    }



    public static void main(String[] args){
        String ss[] = {"abab","aba",""};
        System.out.println(  test(ss) );
    }
}
