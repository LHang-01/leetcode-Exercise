package hashTable;

import java.util.HashMap;

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
        System.out.println(singleNumber(n));
    }

    public static int singleNumber(int[] nums) {
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
