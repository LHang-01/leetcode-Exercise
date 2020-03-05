package hashTable.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 */
public class num136 {

    public static void main(String[] arrs){
        int[] n =new int[]{1000};
        System.out.println(singleNumber1(n));
    }

    /**
     * 法1.哈希表
     * 出现两次元素的先添加后再删除；
     * 只出现一次元素的，只能添加，由于没有第二个相同元素，所以删除不了，那么set里面就只剩这个只出现了一次的元素了
     *
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了  29.88% 的用户
     * 内存消耗 : 41.7 MB , 在所有 Java 提交中击败了 5.04% 的用户
     */
    public static int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            if (set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        //取出set中的第一个元素（也是唯一的元素）返回
        return set.iterator().next();
    }

    /**
     * 法1.哈希表(第一次写的，比较笨)
     */
    public static int singleNumber2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.remove(nums[i]);
            }
        }
        for (Integer i : map.keySet()) {
            return i;
        }
        return -1;
    }

}
