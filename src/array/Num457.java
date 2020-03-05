package array;

/**
 * 457. 环形数组循环
 * 给定一个含有正整数和负整数的环形数组nums。如果某个索引中的数 k为正数，则向前移动 k个索引。相反，如果是负数 (-k)，则向后移动 k个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 * 确定 nums中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 * 示例 1： 输入：[2,-1,1,2,2] 输出：true 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2： 输入：[-1,2] 输出：false 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 */
public class Num457 {
    public static void main(String[] arrs){
        circularArrayLoop(new int[]{-1,2});
    }

    /**
     * 快慢指针，对于查找数组或链表中有没有环的问题，多可以朝快慢指针的方向去想，本题也不例外。
     *
     * 执行用时 : 29 ms , 在所有 Java 提交中击败了 25.97% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 5.26% 的用户
     */
    public static boolean circularArrayLoop(int[] nums) {
        if(nums.length == 0 || nums.length == 1 || nums == null) return false;//处理特殊情况
        for (int i = 0; i < nums.length; i++) {
            //慢指针j从i的位置开始移动(类似 slow = node)，快指针k从i移动一次以后的位置开始移动（类似 fast =node.next)
            int slow = i;
            int fast = next(nums,i);
            //保证快慢指针以及快指针的下一个指针始终向着nums[i]表示的同一个方向移动
            while(nums[i]*nums[fast]>0&&nums[i]*nums[slow] > 0 && nums[i]*nums[next(nums,fast)] > 0){
                if(slow == fast){//快慢指针相遇(在循环中相遇，类似于在环形链表中相遇)
                    if(slow== next(nums, fast)){break;}//循环长度未1不能true
                    return true;
                }
                slow = next(nums,slow);//移动慢指针 类似于slow=slow.next;
                fast = next(nums,next(nums,fast));//移动快指针，类似于fast= fast.next.next;
            }
        }
        return false;
    }

    //计算下一个位置时，避免越界
    private static int next(int[] nums, int i) {
        int next = nums[i]+i;
        if(next >= 0){
            return next%nums.length;
        }else{
            return nums.length+next%nums.length;
        }
    }
}
