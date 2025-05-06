/*
 * @lc app=leetcode.cn id=2360 lang=java
 * @lcpr version=30204
 *
 * [2360] 图中的最长环
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// hard每日一题
// 时间戳解法
// 初始时间为 curTime=1。遍历图，每访问到一个新的节点 x，就记录首次访问时间 visTime[x]=curTime，然后将 curTime 加一。

//假设我们从节点 i 开始。首先记录开始时间 startTime=curTime，然后继续走，如果走到死路，或者找到了一个之前访问过的点 x，则退出循环。
// 题目限定为单环图，若多环图还要比较不同环的大小
class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int res = -1;// 无环的默认返回值
        int curTime = 1;// 全局时间
        int[] visTime = new int[n];
        for (int i = 0; i < n; i++) {// 从不同节点开始遍历
            int x = i;
            int startTime = curTime;// 记录本次遍历开始的时间
            // 因为每个节点只有一条出边，所以如果该点在环中，本轮遍历一定还会二次访问该节点
            while (x!=-1 && visTime[x]==0) {// 首次访问x
                visTime[x] = curTime++;
                x = edges[x];// 访问下个节点
            }
            if (x!=-1 && visTime[x] >= startTime) // 第二次访问该节点
                res = Math.max(res, curTime - visTime[x]);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,3,4,2,3]\n
// @lcpr case=end

 */

