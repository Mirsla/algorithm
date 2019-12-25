package com.alex.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *  给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * author: alex
 * date: 2019/12/25
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));

        nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit3(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if(null == nums) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        int left=0,right=0;
        while (right < nums.length){
           if(nums[left] != nums[right]) {
               left++;
               nums[left] = nums[right];
           }
            right++;
        }

        return left + 1;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        int min = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            if(prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }

        return profit;
    }

    private static int maxProfit2(int[] prices) {
        int len=prices.length;
        if(len==0){
            return 0;
        }
        int min=prices[0];
        int max=0;
        prices[0]=0;
        for(int i=1;i<len;i++){
            if(prices[i]<min){
                min=prices[i];
                prices[i]=0;
            } else {
                prices[i]=prices[i]-min;
            }
        }
        for(int i=0;i<len;i++){
            if(max<prices[i]){
                max=prices[i];
            }
        }
        return max;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        /**
         * 思路：结算数组相邻两个元素之间的差，然后相加即可（大于零的相加）
         */
        if(prices.length == 0) {
            return 0;
        }
        int left = 0, right = 1;
        int max = 0;
        while (right < prices.length) {
            if(prices[right] - prices[left] > 0) {
                max = max + prices[right] - prices[left];
            }
            left++;
            right++;
        }

        return max;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     *
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int left = 0, right = 1;
        int max = 0;
        int[] sums =new int[prices.length];
        int sum = 0;
        while (right < prices.length) {
            if(prices[right] - prices[left] > 0) {
                sum = sum + prices[right] - prices[left];
            } else {
                sums[left] = sum;
                sum = 0;
            }
            left++;
            right++;
        }

        // 求一个数组里面的最大两个数字之间的最大和

        return 0;
    }
}
