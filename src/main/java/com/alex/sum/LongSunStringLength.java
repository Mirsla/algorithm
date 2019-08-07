package com.alex.sum;

import java.util.*;

/**
 * 求给定字符串的不含重复字符的最长字符串的长度。
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LongSunStringLength {

    /**
     * 解法1： 通过ArrayList来解决。
     *      将str分解为字符数组，循环遍历，将不存在的字符放入到ArrayList中，如果ArrayList中已经存在了这个字符，那么返回ArrayList的size为长度
     *      直到遍历完所有的字符，结束循环。
     *
     *      使用这种接法内存和效率都不高；
     */
    public static int getLength_01(String str) {
        if(null == str) {
            return 0;
        }
        if(str.length() == 0) {
            return 0;
        }
        int max_length = 0;
        int str_length = str.length();
        List<Character> list = new ArrayList<>(str_length);

        //将字符串转换为字符数组
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 剩余需要遍历的字串长度要大于
            if(max_length < chars.length - i) {
                for (int j = i; j < chars.length; j++) {
                    if(!list.contains(chars[j])) {
                        list.add(chars[j]);
                    } else {
                        max_length = list.size() > max_length? list.size(): max_length;
                        list = new ArrayList<>(str_length);
                        break;
                    }
                }
                max_length = list.size() > max_length? list.size(): max_length;
            } else {
                return max_length;
            }
        }
        return max_length;
    }

    /**
     * 和上面的思路一样，只不过将ArrayList换位HashMap； 但是效率依旧是不高
     * @param s
     * @return
     */
    public static int getLength_02(String s) {
        if(null == s) {
            return 0;
        }
        if(s.length() == 0) {
            return 0;
        }
        int max_length = 0;
        int str_length = s.length();
        Map<Character, String> map = new HashMap<>(str_length);

        //将字符串转换为字符数组
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 剩余需要遍历的字串长度要大于
            if(max_length < chars.length - i) {
                for (int j = i; j < chars.length; j++) {
                    if(!map.containsKey(chars[j])) {
                        map.put(chars[j], "");
                    } else {
                        max_length = map.size() > max_length? map.size(): max_length;
                        map = new HashMap(str_length);
                        break;
                    }
                }
                max_length = map.size() > max_length? map.size(): max_length;
            } else {
                return max_length;
            }
        }
        return max_length;
    }

    /**
     *  解法三： 不使用ArrayList来存储字符串，感觉有点消耗内存。
     *          采用滑动算法。
     *
     *          示例： abcdbcd 将输入放入set中，这次只遍历两遍（放入List或者是数组中都是可以的，主要的算法逻辑如下）
     *          set:  a ->  a  1
     *              b -> ab     2
     *              c -> abc    3
     *              d -> abcd   4
     *              b -> （因为set中已经有b了，需要将b和b之前的字母移除出去） bcd -> cd -> cdb     3
     *              c -> (c在set中也存在，那么需要将c及C之前的数据移除出去) db -> dbc    3
     *              d -> bc -> bcd  3
     *          所以最大的就是的子字符串就是4
     *
     *          具体实现如下：
     *
     *          36ms    36.18%
     *          40.6M   71.95%
     */
    public static int getLength_03(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 此方法是对上面的方法进行一个优化
     *      用List来维护一个队列， 先进先出，每次有一个重复的，将重复的和之前的全部移除。
     *
     *      27ms    63.18%
     *      39.1M    82.96%
     *
     */
    public static int getLength_04(String s) {
        List<Character> list = new ArrayList<>(s.length());
        int ans = 0, i = 0;
        for(i = 0; i < s.length(); i++) {
            if(!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                ans = Math.max(ans, list.size());
            } else {
                list.add(s.charAt(i));
                list.subList(0, list.indexOf(s.charAt(i)) + 1).clear();
            }
        }
        return ans;
    }

    /**
     *  TODO ASCII 128 方式，目前没有一个好的思路，这个下来在看
     * @param s
     * @return
     */
    public static int getLength_05(String s) {
        return 0;
    }


    public static void main(String[] args) {
        String str = "aabaab!bb";
        System.out.println(getLength_04(str));
        System.out.println();
    }
}
