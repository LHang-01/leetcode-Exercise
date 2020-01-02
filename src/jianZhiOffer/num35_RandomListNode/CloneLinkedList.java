package jianZhiOffer.num35_RandomListNode;

/**
 * 剑指offer面试题35--复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 插入、连接、拆分三步法。
 * 插入：在原始链表的每个结点后插入一个值和它一样的新结点；则有oriNode.next == cloneNode这样的关系；
 * 连接随机结点：遍历插入新结点后的链表，在访问原始链表中的那些结点时，判断其是否有随机结点，有的话cloneNode.random = oriNode.random.next这里oriNode.random.next表示原始链表随机结点的下一个结点，其实就是复制链表的随机结点。
 * 拆分原始链表和复制链表：将奇数结点相连就是原始链表，将偶数结点相连就是我们想要的复制链表。返回复制链表的头结点即可。
 */

public class CloneLinkedList {

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) return null;
        copyNode(pHead);
        setCloneRandomNode(pHead);
        return splitList(pHead);
    }

    //1. 为每个结点的next插入一个和该结点的值一样的结点
    // (注意：对于链表要插入一个节点，例如a->b: 需要让待插入点c->b和让a->c，这样才算插入成功)
    private void copyNode(RandomListNode head) {
        RandomListNode now = head;
        while (now!=null){
            //插入节点
            RandomListNode node = new RandomListNode(now.label);
            node.next=now.next;
            now.next = node;
            //更新节点
            now = node.next;
        }
    }

    // 2. 设置每个复制结点的random
    private void setCloneRandomNode(RandomListNode head) {
        RandomListNode now = head;
        while (now!=null){
            //当前节点的random不为空时，复制random；当前节点.random=null,不复制。
            if (now.random!=null){
                now.next.random=now.random.next;
            }
            //更新当前节点
            now = now.next.next;
        }
    }

    // 3. 拆分链表
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode cloneHead = head.next;
        while (head!= null) {
            //3.1分离原节点，让原节点的下一个节点跳过克隆节点，指向克隆节点的下一个节点
            RandomListNode clonenode = head.next;
            head.next = head.next.next;
            //3.2分离克隆节点，当克隆节点不是尾节点时，让克隆节点的下一个节点跳过原节点，指向原节点的下一个节点
            if (clonenode.next != null) {
                clonenode.next = clonenode.next.next;
            }
            head = head.next;
        }
        return cloneHead;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}

