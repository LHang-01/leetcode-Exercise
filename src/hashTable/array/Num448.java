package hashTable.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Handler;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在1 ≤ a[i] ≤ n (n = 数组大小) 的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:   输入: [4,3,2,7,8,2,3,1]   输出: [5,6]
 */
public class Num448 {
    public static void main(String[] arrs){
        findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1});
    }
    /**
     * 法1：哈希表
     * 先数字装到hashset中，删除集合重复数字
     * 然后遍历1到n的整数，判断set中是否含有。
     *
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)。
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =1;i<=nums.length;i++){
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
        /*上面代码比下面的高效、简洁。
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        for (int i = 1;i<=nums.length;i++){
            if (list.contains(i)){
                //注意当List存Integer时，若要删除集合中的某一个数字，要先把该数字封装成Integer对象传入删除，否则List会把传入的数字作为index,可能会导致下标越界的产生。
                list.remove((Integer)i);
            }else {
                list.add(i);
            }
        }
        return list;
        */
    }

    /**
     * 法2：原地修改
     * 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
     * 举个例子：
     * 原始数组：[4,3,2,7,8,2,3,1]
     * 重置后为：[-4,-3,-2,-7,8,2,-3,-1]
     * 结论：[8,2] 分别对应的index为[5,6]（消失的数字）
     *
     * 执行用时 : 8 ms , 在所有 java 提交中击败了 75.71% 的用户
     * 内存消耗 : 47.2 MB , 在所有 java 提交中击败了 95.93% 的用户
     *
     * 时间复杂度：O(N)。
     * 空间复杂度：O(1)，因为我们在原地修改数组，没有使用额外的空间。
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i<=nums.length;i++){
            int index = Math.abs(nums[i-1])-1;
            nums[index]=-Math.abs(nums[index]);
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
