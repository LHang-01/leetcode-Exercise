package array;

/**
 * 457. 环形数组循环
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 * 示例 1：
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 */
public class Num457 {
    public static void main(String[] arrs){
        circularArrayLoop(new int[]{-1,2});
    }
    public static boolean circularArrayLoop(int[] nums) {
        if (nums.length<2) return false;
        int pre=0;
        int now=0;
        for (int i =0; i<nums.length;i++){
            pre=i;
            now=i;
            if (nums[now]==0){
                continue;
            }else if (nums[now]>0){
                int count =nums.length;
                int temp;
                do {
                    temp =now;
                    now=(nums[now]+now)%nums.length;
                    nums[temp]=0;
                    if(now==temp){
                        break;
                    }
                    if (nums[now]<=0) break;
                    count--;
                }while (now!=pre&&count>=0);
                if (now==pre&&now!=temp){
                    return true;
                }
            }else {
                int count =nums.length;
                int temp;
                do {
                    temp =now;
                    now=nums[now]+now;
                    nums[temp]=0;
                    if (now<0){
                        now=now+nums.length;
                    }
                    if(now==temp){
                        break;
                    }
                    if (nums[now]>=0) break;
                    count--;
                }while (now!=pre&&count!=0);
                if (now==pre&&now!=temp){
                    return true;
                }
            }

        }
        return false;
    }
}
