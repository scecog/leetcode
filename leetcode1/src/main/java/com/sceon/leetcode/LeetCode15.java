package com.sceon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *   满足要求的三元组集合为：
 *   [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 *   ]
 */
public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.size());

    }
    /*
     * 解题思路，数组排序，然后双指针
     * 首先，当数组的值大于0时，此时三数之和肯定不等于0
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < len ; i++){
            // 如果nums[i] > 0 直接跳出循环
            if (nums[i] > 0)
                break;
            // 去除重复
            if (i > 0 && nums[i] == nums[i-1] )
                continue;
            int L = i+1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[R] + nums[L];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L+1]) L++;
                    // 去重
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                // 如果 和 小于0 ，说明需要去找更大的边
                if (sum < 0)
                    L++;
                // 如果和大于0 说明需要从右向左移动
                if (sum > 0)
                    R--;
            }
        }
        return result;
    }
}
