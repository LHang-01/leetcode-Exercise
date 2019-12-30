package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num102 {
    //先把根节点放入队列中，然后循环
    //（大）循环时，1.1首先记录当前队列中共有size个节点（也就是树的这一层一共有多少个节点）,然后出队size次节点，并依次把出队节点的非空左右节点入队，并用list记录出队的节点值。（小循环）
    //       1.2 出队size次后，list就保存了第i层的所有节点的值，并且，此时队列中的节点就是第i+1层的所有节点。
    //      1.3 当list的尺寸为0时，说明，这一层全是空节点，已经遍历完成，那么就可以跳出循环；当list的尺寸！=0时，那么还没遍历完成，把list结果加入到lists里面，然后继续（大）循环。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        //当传入的节点为空时，返回空的链表
        if(root==null) return lists;
        //层次遍历是广度优先搜索，用到队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                root = queue.poll();
                list.add(root.val);
                if (root.left!=null) queue.offer(root.left);
                if (root.right!=null) queue.offer(root.right);
                size--;
            }
            if (list.size()==0){
                //加这个判断是为了当遇到最后一层时（权为空）加入空的链表。
                return lists;
            }else {
                lists.add(list);
            }
        }
    }


    //和levelOrder方法差不多
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                root = queue.poll();
                list.add(root.val);
                if (root.left!=null) queue.offer(root.left);
                if (root.right!=null) queue.offer(root.right);
                size--;
            }
            lists.add(list);
            //加这个判断是为了当遇到本层不为空，但下一层为空时，提前结束循环。
            // 因为如果此处不加判断，就进入了下一层循环，但下一层没有节点，list就为空，就会把空的链表加入到lists里面，就出现了错误。
            if (queue.size()==0){
                return lists;
            }
        }
    }
}
