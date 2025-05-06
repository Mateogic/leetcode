/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30204
 *
 * [146] LRU 缓存
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 需要用到哈希表和双向链表维护所有在缓存中的键值对
// 自定义双链表实现
// 双向链表按照被使用的顺序存储键值对，靠近头部的键值为最近使用的，靠近尾部的键值是最久未使用的
// 哈希表通过缓存数据的键映射到其在双向链表的位置
// 使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，即可在 O(1) 的时间内完成 get 或者 put 操作

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class DLinkNode{// 双向链表节点类
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(){}
        public DLinkNode(int key,int val){
            this.key = key;
            this.value = val;
        }
    }
    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
    private int size;
    private int capacity;
    private DLinkNode head,tail;// 使用伪头部和伪尾部标记界限

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node==null) // 不存在
            return -1;
        // 存在
        moveToHead(node);// 移至头部
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node==null) {// 不存在
            DLinkNode newNode = new DLinkNode(key,value);// 新增节点
            cache.put(key,newNode);// 添加到哈希表
            addToHead(newNode);// 插到当前头部之前
            size++;
            if (size>capacity) {
                DLinkNode deletedTail = removeTail();
                cache.remove(deletedTail.key);// 删除哈希表中的键值对
                size--;
            }
        }
        else{// 存在
            node.value = value;// 更新值
            moveToHead(node);// 移至头部
        }
    }

    private void addToHead(DLinkNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail(){
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;// 返回用于查询删除哈希表
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end



