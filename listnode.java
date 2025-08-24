import java.io.*;
import java.util.*;
// 链表定义
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    // 通过数组构造链表
    static ListNode build(int[] arr){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for(int v: arr){
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // 迭代反转链表
    static ListNode reverse(ListNode head){
        ListNode prev = null, cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    // 打印链表
    static void print(ListNode head){
        StringBuilder sb = new StringBuilder();
        for(ListNode p=head; p!=null; p=p.next){
            sb.append(p.val).append(" ");
        }
        if(sb.length()>0) sb.setLength(sb.length()-1);// 删除最后一个空格
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = build(arr);
        System.out.print("原链表: ");
        print(head);// 原链表: 1 2 3 4 5

        ListNode reversed = reverse(head);
        System.out.print("反转后: ");
        print(reversed);// 反转后: 5 4 3 2 1
    }
}
