package hashTable.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1: 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]
 * 示例 2: 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [9,4]
 * 说明: 输出结果中的每个元素一定是唯一的。
 *       我们可以不考虑输出结果的顺序。
 */
public class Num349 {
    /**
     * 执行用时 : 3 ms , 在所有 java 提交中击败了 96.83% 的用户
     * 内存消耗 : 36.3 MB , 在所有 java 提交中击败了 73.71% 的用户
     *
     * 法1：先遍历一个数组，将不重合的数保存到set中，
     * 然后遍历另一个数组，当另一个数组的值与set值相同时，从set中移除，并且添加到list中
     * 最后list保存的就是交集
     *
     * 时间复杂度：O(m+n)，其中 n 和 m 是数组的长度。O(n) 的时间用于转换 nums1 在集合中，O(m) 的时间用于转换 nums2 到集合中，并且平均情况下，集合的操作为O(1)。
     * 空间复杂度：O(m+n)，最坏的情况是数组中的所有元素都不同。
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        //1先遍历一个数组，将不重合的数保存到set中
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }
        //2.然后遍历另一个数组，当另一个数组的值与set值相同时，从set中移除，并且添加到list中
        for (int i:nums2){
            if (set.contains(i)){
                set.remove(i);
                list.add(i);
            }
        }
        //3.把list转换为数组返回
        int[] ans = new int[list.size()];
        int i=0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            ans[i]=it.next();
            i++;
        }
        return ans;
    }

    /**
     *  2.内置函数：Java 提供了 retainAll() 函数求交集.
     *
     *  时间复杂度：一般情况下是O(m+n)，最坏情况下是O(m×n)。
     *  空间复杂度：最坏的情况是O(m+n)，当数组中的元素全部不一样时。
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i:nums2){
            set2.add(i);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int index = 0;
        for (int i:set1){
            ans[index++] = i;
        }
        return ans;
    }
}
