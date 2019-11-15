package division;

import java.util.HashMap;
import java.util.Stack;

/**
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class num169 {
    public static void main(String[] arrs){
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(fun1(arr));
        System.out.println(fun2(arr));
    }

    //摩尔投票法
    private static int fun2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else if(stack.peek().equals(arr[i])){
                stack.push(arr[i]);
            }else {
                stack.pop();
            }
        }
        return stack.peek();
    }

    //哈希表
    private static int fun1(int[] arr) {
        int ans=arr[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.replace(arr[i],map.get(arr[i])+1);
                if(map.get(arr[i])>arr.length/2){
                    ans = arr[i];
                    break;
                }
            }else {
                map.put(arr[i],1);
            }
        }
        return ans;
    }

}
