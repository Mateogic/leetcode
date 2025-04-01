/*
 * @lc app=leetcode.cn id=2140 lang=java
 * @lcpr version=30204
 *
 * [2140] 解决智力问题
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 与lc198打家劫舍类似，采取记忆化搜索方案
// 打家劫舍不能选择连续两个位置的数dfs(i) = max(dfs(i-1),dfs(i-2)+nums[i])
    // dfs(i)若选nums[i]，则下一步是dfs(i-2)+nums[i]
    // dfs(i)若不选nums[i]，则下一步是dfs(i-1)
// 打家劫舍dfs从后向前考虑，本题dfs从前向后考虑，dfs(i)表示从题目i开始考虑可以获得的最大分数，dfs(0)是原问题也是答案
    // 若选做questions[i]，则得分questions[i][0]，且要跳过接下来的questions[i][1]个问题，即下一步dfs(i+questions[i][1]+1)+questions[i][0]
    // 若不做questions[i],则不得分，下一步为dfs(i+1)
    // 递归边界条件:当i>=n时表示无题可做，返回0
    // dfs(i) = max(dfs(i+1), dfs(i+questions[i][1]+1)+questions[i][0])
// 打家劫舍相当于questions[i][1] = 1，且不要求从前向后做，故考虑方向不一样

// 方法一:记忆化搜索
// class Solution {
//     private int n;
//     public long mostPoints(int[][] questions) {
//         n = questions.length;
//         long[] memo = new long[n];// 记录每个位置的最大得分，由于得分全都大于0，所以无需初始化为-1
//         return dfs(0,questions,memo);
//     }
//     private long dfs(int i,int[][]questions, long[] memo){
//         if(i>=n)
//             return 0;
//         if(memo[i]!=0)
//             return memo[i];
//         long res = Math.max(dfs(i+1,questions,memo), dfs(i+questions[i][1]+1,questions,memo)+questions[i][0]);
//         memo[i] = res;
//         return res;
//     }
// }

// 方法二:递推
// dfs(i) = max(dfs(i+1), dfs(i+questions[i][1]+1)+questions[i][0])
// f[i] = max(f[i+1],f[j]+questions[i][0])，其中j = i+questions[i][1]+1
// 初始化条件:f[n] = 0;由于j = i+questions[i][1]+1可能越界，所以应该取j = min(i+questions[i][1]+1, n)
class Solution{
    public long mostPoints(int[][] questions){
        int n = questions.length;
        long[] f = new long[n+1];// 用到初始条件f[n] = 0，防止越界
        f[n] = 0;
        for(int i = n-1;i>=0;i--){
            int j = Math.min(i+questions[i][1]+1, n);// 取较小值，防止越界
            f[i] = Math.max(f[i+1], f[j] + questions[i][0]);
        }
        return f[0];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[3,2],[4,3],[4,4],[2,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[2,2],[3,3],[4,4],[5,5]]\n
// @lcpr case=end

 */

