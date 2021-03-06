package com.sceon.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shichenchong@inspur.com
 * date   2020/8/5 11:14
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
  */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints);

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }

}
