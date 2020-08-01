package com.sceon.leetcode;

import java.util.HashMap;

public class LeetCode2 {
    public static void main(String[] args) {
        String s = "b";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int result = 0;
        //int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int right = 0,left = 0; right < s.length() ; right ++){
            if (map.containsKey(s.charAt(right))){
                //result = Math.max(right - left,result);
                left = Math.max(left,map.get(s.charAt(right)));

            }
            result = Math.max(right - left + 1,result);
            map.put(s.charAt(right),right + 1);
        }
        return result;
    }
}
