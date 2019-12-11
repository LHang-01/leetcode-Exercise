package array;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Num349 {
    /**
     * 执行用时 :
     * 3 ms
     * , 在所有 java 提交中击败了
     * 96.83%
     * 的用户
     * 内存消耗 :
     * 36.3 MB
     * , 在所有 java 提交中击败了
     * 73.71%
     * 的用户
     *
     * 先遍历一个数组，将不重合的数保存到set中，
     * 然后遍历另一个数组，当另一个数组的值与set值相同时，从set中移除，并且添加到list中
     * 最后list保存的就是交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            if (!set.contains(nums1[i])){
                set.add(nums1[i]);
            }
        }
        for (int i=0;i<nums2.length;i++){
            if (set.contains(nums2[i])){
                set.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] ints = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i=0;
        while (it.hasNext()){
            ints[i]=it.next();
            i++;
        }
        return ints;
    }
}
