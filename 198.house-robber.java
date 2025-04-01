/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30204
 *
 * [198] 打家劫舍
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.Arrays;
// 动态规划 记忆化搜索，进阶题目为lc2140
// 记忆化搜索的作用:通过存储中间结果、避免重复计算降低时间复杂度
// 当代码执行到 if (memo[i] != -1) 时，若值不是 -1，说明之前已经计算过这个子问题，可以直接返回结果
// 若没有记忆化搜索，因为每个位置都有偷和不偷两种选择，时间复杂度为O(2^n)
// 使用记忆化搜索后，每个位置只会被计算一次，时间复杂度为O(n)
// dfs(i)定义为从nums[0] 到 nums[i] 能偷到的最大金额，无论是通过哪条递归路径到达 dfs(i)，其含义和计算逻辑都完全相同，故dfs(i)返回值固定
// 题目规定:不能偷位置连续的两个房子，因此，需要比较dfs(i - 1) 和 dfs(i - 2) + nums[i]
// 从dfs(n-1)开始递归，自上而下直至计算dfs(0)和dfs(1)，然后向上返回计算后续的值

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] memo = new int[n];
//         Arrays.fill(memo, -1);// 标记未计算过的位置为-1
//         return dfs(n-1,nums,memo);// 从n-1开始考虑，自上而下递归
//     }
//     private int dfs(int i,int[] nums,int[] memo){
//         if(i < 0)
//             return 0;
//         if(memo[i]!=-1)// 已经算过
//             return memo[i];
//         int res = Math.max(dfs(i-1, nums, memo), dfs(i-2, nums, memo)+nums[i]);
//         memo[i] = res;
//         return res;
//     }
// }


// 无记忆化搜索通过用例55/70，会发生TLE
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return dfs(n-1,nums);// 从n-1开始考虑，自上而下递归
//     }
//     private int dfs(int i,int[] nums){
//         if(i < 0)
//             return 0;
//         int res = Math.max(dfs(i-1, nums), dfs(i-2, nums)+nums[i]);
//         return res;
//     }
// }


// 记忆化搜索1:1翻译成递推
// 记忆化搜索的实质计算发生在归的过程，递的过程只是在不同状态之间建立联系
// 已知联系之后，可以砍掉递的过程，使用递归公式模拟归的过程，即自下而上
// dfs -> f数组，递归 -> 循环，递归边界 -> 递推数组初始化
// dfs(i) = max(dfs(i-1, nums), dfs(i-2, nums)+nums[i])，递归边界为i=0时返回0
// f[i] = max(f[i-1],f[i-2]+nums[i])，除nums[i]的索引i外，其余索引统一i+=2
// f[i+2] = max(f[i+1],f[i]+nums[i])，初始化条件为i=0时f[0] = f[1] = 0
// 为什么不用变成nums[i+2]?如此会导致nums[0]和nums[1]无法计入，且当 i=n−1 时，i+2=n+1，导致nums数组越界
// 此外，因为定义int[] f = new int[n+2]，相当于f[0]和f[1]冗余用作初始化
// f[2]相当于考虑nums[0]的最优解，f[i+2]相当于考虑从nums[0]到nums[i]的最优解，f[n+1]相当于考虑从nums[0]到nums[n-1]的最优解
// 因此，最终返回f[n+1]
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] f = new int[n+2];
//         for(int i = 0;i<n;i++){
//             f[i+2] = Math.max(f[i+1], f[i]+nums[i]);
//         }
//         return f[n+1];
//     }
// }

// 滚动优化空间复杂度
class Solution {
    public int rob(int[] nums) {
        int f0 = 0,f1 = 0,f2 = 0;
        for(int num:nums){
            f2 = Math.max(f1,f0+num);
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,7,9,3,1]\n
// @lcpr case=end

 */

