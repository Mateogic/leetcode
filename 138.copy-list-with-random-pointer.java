/*
 * @lc app=leetcode.cn id=138 lang=java
 * @lcpr version=30204
 *
 * [138] 随机链表的复制
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// filepath: [138.copy-list-with-random-pointer.java](http://_vscodecontentref_/0)
// 结合328拆分奇偶链表学习
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        // 建立交错链表
        for(Node cur = head;cur!=null;cur = cur.next.next) {
            cur.next = new Node(cur.val,cur.next);
        }
        // 遍历交错链表，拷贝随机连接关系
        for(Node cur = head;cur!=null;cur = cur.next.next) {
            if (cur.random!=null) 
                cur.next.random = cur.random.next;
        }
        // 拆分交错链表
        Node even_head = head.next, even = even_head;
        Node odd = head;
        while (odd.next!=null && even.next!=null) {
            // 因奇节点总在偶节点前面，所以此处应该先构造奇链，否则会造成节点丢失问题
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
// 讨论出循环的情况odd.next==null || even.next!=null
    // 若链表有偶数个节点:odd到达倒数第二个节点， even到达倒数第一个节点
    // 若链表有奇数个节点:odd到达倒数第一个节点， even到达null，因此不会形成环
        odd.next = null;// 恢复原始链表的指向，将最后一个节点指向null
        // 因为所构造的交错链表包含偶数节点，出循环后even到达倒数第一个节点，但本就指向null，无需额外操作
        return even_head;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[7,null],[13,0],[11,4],[10,2],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,null],[3,0],[3,null]]\n
// @lcpr case=end

 */

