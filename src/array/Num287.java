package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Num287 {
    /**
     * 暴力求解
     * 执行用时 :
     * 126 ms
     * , 在所有 java 提交中击败了
     * 7.14%
     * 的用户
     * 内存消耗 :
     * 38 MB
     * , 在所有 java 提交中击败了
     * 82.27%
     * 的用户
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int ans = 0;
        for (int i =0 ;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]==nums[i]){
                    ans= nums[j];
                    break;
                }
            }
        }
        return ans;
    }


    /**
     *快慢指针
     * 当快指针（走两步）和慢指针（走一步）第一次相遇时，慢指针不变，快指针归零从nums[0]重新出发，并且快指针也变为慢指针，当两指针再一次相遇时的值就是重复的值，这与链表中找循环链表的入口是一种道理
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 37.1 MB
     * , 在所有 java 提交中击败了
     * 95.85%
     * 的用户
     */
    public int findDuplicate(int[] nums) {
        int slow =nums[0];
        int fast =nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        fast=nums[0];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
    /**
     *以nums中元素为index，并为index%n指向的元素+n。
     * 再次循环，但nums[i]>2n时，说明i为重复出现的数字
     *
     * 执行用时 :
     * 1 ms, 在所有 java 提交中击败了85.21%的用户
     * 内存消耗 :
     * 37.6 MB, 在所有 java 提交中击败了92.52%的用户
     */
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int ans=-1;
        for (int i = 1; i<=nums.length; i++) {
            int index = nums[i-1]%5-1;
            nums[index]+=n;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>2*n){
                ans=i;
                break;
            }
        }
        return ans;
    }

    /**
     * 排序
     */
    public int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
    /**
     * 哈希表
     */
    public int findDuplicate4(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

}
