package cn.com.leetcode;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:

        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
*/

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    public static int[] twoNums(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return null;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return null;
    }

    public static int[] twoNums_map(int[] nums, int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff))
                return new int[]{map.get(diff),i};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 7};
        int target = 9;
        int[] result=twoNums_map(nums, target);
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]+" ");
    }
}
