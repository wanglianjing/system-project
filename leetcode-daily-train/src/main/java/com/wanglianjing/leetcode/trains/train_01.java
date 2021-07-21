package com.wanglianjing.leetcode.trains;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class train_01 {
    public static void main(String[] args) {
//        输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        int[] realResult = {0,1};

        Assert.assertArrayEquals(result, realResult);

        System.out.println("qiaozi");
    }

    public static int[] twoSum(int[] nums, int target) {
        int count = nums.length;
        int[] result = new int[2];
        // 双重for循环太耗时，性能较差
        // for(int i = 0; i < count; i++){
        //     for(int j = i + 1; j < count; j++){
        //         if(nums[i] + nums[j] == target){
        //             result[0] = i;
        //             result[1] = j;
        //         }
        //     }
        // }
        // 采用hash表来优化解答
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < count; i++) {
            if(hash.containsKey(nums[i])){
                result[0] = hash.get(nums[i]);
                result[1] = i;
                return result;
            }
            // 否则将数据存入hash表中，key为target与nums[i]的补数，value为下标i
            hash.put(target - nums[i], i);
        }

        return result;
    }

}

