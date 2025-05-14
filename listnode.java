public class listnode {
    // 构造链表
    int val;
    listnode next;
    listnode(){}
    listnode(int val){this.val = val;}
    listnode(int val, listnode next){
        this.val = val;
        this.next = next;
    }
    // 主函数
    public static void main(String[] args) {
        listnode head = new listnode(0);
        listnode cur = head;
        for(int i = 0;i<5;i++){
            cur.next = new listnode(i+1);
            cur = cur.next;
        }
        // 反转链表
        listnode tmp = null, pre = null;
        cur = head;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        while (pre!=null) {
            System.out.printf("%d, ", pre.val);
            pre = pre.next;
        }
    }
}
