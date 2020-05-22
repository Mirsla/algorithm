package com.alex.string;

/**
 * 罗马数字转int型数字
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 */
public class RomeNum2IntNum {

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    /**
     * 解题思路：
     *
     *
     * 从座到有遍历字符串数组
     *  如果： 左边的比右边的小，那么使用减法（减去左边字符对应的值）
     *  如果： 左边的比右边的大，直接相加
     *
     *  这里字符和数字的对应关系可以使用Map来进行存储，也可以使用switch方法，实际效果来看，使用Map不管是在空间上还是在效率上都比不上使用switch，
     *  当然，这个是在数据量比较小的时候。只是针对于这道题
     */
    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int preNum = getValue(chars[0]);

        for(int i = 1; i < chars.length; i++) {
            int num = getValue(chars[i]);
            if(preNum < num) {
                sum -= preNum;
            } else  {
                sum += preNum;
            }
            preNum = num;
        }

        sum += preNum;
        return sum;
    }


    private static int getValue(char _char) {
        switch (_char) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
