package com.github.hcsp.algorithm;

// compareTo的使用回顾：https://zhuanlan.zhihu.com/p/362757389
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "bbb"));
        System.out.println(binarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy"));
        System.out.println(recursiveBinarySearch(new String[]{"aaa", "ccc", "fff", "yyy", "zzz"}, "yyy", 0, 5));
    }

    // 给定一个按照字符串升序升序排好序的用户数组，寻找目标字符串的位置，返回其索引值
    // 如果未找到，返回-1
    // 我们鼓励你使用递归和非递归两种方式
    public static int binarySearch(String[] strings, String target) {
        int start = 0; // 记录区间开始元素的下标
        int end = strings.length - 1; // 记录区间最后一个元素下标
        while (start <= end) {
            // 数组是线性表，随机寻址复杂度是O(1)
            if (target.equals(strings[start])) {
                return start;
            }
            // 数组是线性表，随机寻址复杂度是O(1)
            if (target.equals(strings[end])) {
                return end;
            }
            // 二分查找算法，时间复杂度O(log(n))
            int mid = (start + end) / 2;
            if (target.compareTo(strings[mid]) < 0) {
                end = mid - 1;
            } else if (target.compareTo(strings[mid]) > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(String[] strings, String target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target.compareTo(strings[mid]) < 0) {
                return recursiveBinarySearch(strings, target, start, mid + 1);
            } else if (target.compareTo(strings[mid]) > 0) {
                return recursiveBinarySearch(strings, target, mid - 1, end);
            } else {
                return mid;
            }
        }
        return -1;
    }


}
