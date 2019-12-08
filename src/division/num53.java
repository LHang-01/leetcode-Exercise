package division;

/**
 * 53.最大子序和
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class num53 {
    public static void main(String[] arrs){
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //System.out.println(fun1(arr));
        System.out.println(fun2(arr));
        //System.out.println(fun3(arr));
    }


    //分治法
    public static int fun3(int[] arr) {
        int min = 0;
        int max = arr.length-1;
        return fun4(arr,min,max);
    }

    public static int fun4(int[] arr, int min, int max) {
        //终止条件
        if(min==max){
            return arr[min];
        }

        //求左部分最大
        int left = fun4(arr,min,(min+max)/2);

        //求右部分最大子序列
        int right = fun4(arr,(min+max)/2+1,max);

        //求跨中点最大子序列
        int sum=arr[(min+max)/2];
        int leftHalfMax =arr[(min+max)/2];
        for(int i= (min+max)/2-1;i>=0;i--){
            sum=sum+arr[i];
            if(sum>leftHalfMax){
                leftHalfMax=sum;
            }
        }
        sum=arr[(min+max)/2+1];
        int rightHalfMax =arr[(min+max)/2+1];
        for(int i= (min+max)/2+2;i<arr.length;i++){
            sum=sum+arr[i];
            if(sum>rightHalfMax){
                rightHalfMax=sum;
            }
        }

        //综合：求最大子序列和
        return Math.max((left>right?left:right),leftHalfMax+rightHalfMax);
    }

    /**贪心算法
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 99.98%
     * 的用户
     * 内存消耗 :
     * 38.2 MB
     * , 在所有 java 提交中击败了
     * 86.42%
     * 的用户
     * @param arr
     * @return
     */
    private static int fun2(int[] arr) {
        if(arr==null){
            return -1;
        }
        int preSum = arr[0];
        for (int i=0;i<arr.length;i++){
            int nowSum =arr[i];
            if (nowSum>preSum){
                preSum = nowSum;
            }
            while (i+1<arr.length&&nowSum>=0){
                nowSum += arr[i+1];
                if (nowSum>preSum){
                    preSum=nowSum;
                }
                i++;
            }
        }
        return preSum;


        /*int ans = arr[0];
        int sum;
        int j;
        for(int i=0;i<arr.length;i=j){
            j=i+1;
            sum=arr[i];
            if(sum>ans){
                ans=sum;
            }
            while(sum>0&&j<arr.length){
                sum=sum+arr[j];
                if(sum>ans){
                    ans=sum;
                }
                j++;
            }
        }
        return ans;
        */

    }

    //暴力法
    public static int fun1(int[] arr) {
        if(arr.length==0&&arr==null){
            return -1;
        }
        int ans = arr[0];
        int sum;
        for(int i=0;i<arr.length;i++){
            sum= arr[i];
            if(sum>ans){
                ans=sum;
            }
            for(int j=i+1;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum>ans){
                    ans=sum;
                }
            }
        }
        return ans;
    }




}
