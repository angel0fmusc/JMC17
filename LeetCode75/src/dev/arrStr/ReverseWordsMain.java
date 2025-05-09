package dev.arrStr;

import java.util.Arrays;

public class ReverseWordsMain {

    public static void main(String[] args) {
        String str1 = "the sky is blue";
        String str2 = "  hello world  ";
        String str3 = "a good   example";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        str1 = str1.trim();
        str2 = str2.trim();
        str3 = str3.trim();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        String[] str1Array = str1.split("\s+");
        String[] str2Array = str2.split("\s+");
        String[] str3Array = str3.split("\s+");

        System.out.println(Arrays.toString(str1Array));
        System.out.println(Arrays.toString(str2Array));
        System.out.println(Arrays.toString(str3Array));

    }

    public static String reverseWords(String s){
        if(s.length() == 1){
            return s;
        }

        StringBuilder newString = new StringBuilder();


        return  newString.toString();
    }
}
