package array;

public class Num75 {
    public static void main(String[] arrs){
        sortColors2(new int[]{2,0,2,1,1,0});
    }
    /**
     * 执行用时 :
     * 0 ms , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :
     * 35.3 MB, 在所有 java 提交中击败了36.15%的用户
     * 方法：两次遍历
     * 第一次:记录0的个数zero和1的个数one
     * 第二次：依次填入zero个0，one个1，剩下的全填2
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int zero = 0;
        int one =0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]==0){
                zero++;
            }else if (nums[i]==1){
                one++;
            }
        }
        for (int i = 0;i<nums.length;i++){
            if (i<zero){
                nums[i]=0;
            }else if (i<zero+one){
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }
    }

    /**
     *方法:双指针
     * 本解法的思路是沿着数组移动 now 指针，若nums[now] = 0，则将其与 nums[zero+1]互换；若 nums[now] = 2 ，则与 nums[two-1]互换。
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 35.3 MB
     * , 在所有 java 提交中击败了
     * 36.15%
     * 的用户
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int zero = -1;
        int now =0;
        int two=nums.length;
        while (now>zero&&now<two){
            if (nums[now]==0){
                if (now!=zero+1){
                    nums[zero+1]=0;
                    nums[now]=1;
                }
                zero++;
                now++;
            }else if (nums[now]==2){
                if (now!=two-1){
                    int temp = nums[two-1];
                    nums[two-1]=2;
                    nums[now]=temp;
                }else {
                    return;
                }
                two--;
            }else {
                now++;
            }
        }
    }

}
