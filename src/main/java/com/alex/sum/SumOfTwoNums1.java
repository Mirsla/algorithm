package com.alex.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求两个数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 *
 * 示例： 给定 nums = [2, 7, 11, 15], target = 9  因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class SumOfTwoNums1 {

    /**
     * 解法 1： 一次循环， 利用list提供的一些方法来解决，不过效率不高 来解决
     *
     * 先将一个nums转换为一个list，然后利用list的特性来check是否有满足条件的数据
     *
     * 这里转换list不用 Arrays.asList， 这个方法返回的不是一个真正的list,是Arrays中的一个内部类
     *
     * 还可以直接用两个for循环来求解，不过这次方式先不实现了。
     */
    public static int[] twoSum_01(int[] nums, int target) {
        List list = new ArrayList(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            int index = 0;
            int diff = target - nums[i];
            if(list.contains(diff)) {
                index = list.indexOf(diff);
                if(diff != i) { // 确定当前数组不是同一个
                    return new int[]{i, index};
                }
            }
        }
        return null;
    }


    /**
     *  解法2： 利用HashMap来解决。用空间换效率
     *
     *  将下标和值放入HashMap中，其中值为key，下标为value
     *
     *  也可以直接用两个HashMap来完成，直接先将nums分别放入HashMap中，（以上面的方式）判断效率是否如下所示就行了。
     */
    public static int[] twoSum_02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) { // 如果HashMap中有这个元素 的差值，直接返回，没有继续
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        /**
         * 测试用例
         */
        int nums[] = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum_02(nums, target);
        if(null != result) {
            System.out.println(result[0] + "," +result[1]);
        }
    }
}
