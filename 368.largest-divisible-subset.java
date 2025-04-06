/*
 * @lc app=leetcode.cn id=368 lang=java
 * @lcpr version=30204
 *
 * [368] 最大整除子集
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 子集中的任意两数，要求满足较大者为较小者的倍数
// 动态规划:某个状态的转移依赖于与前一个状态的关系，即nums[i]能否接在nums[j]后面取决于是否满足nums[i]%nums[j]==0条件
// 定义f[i]表示考虑前i个数字，且以第i个数字作为结尾的最长整数子集的长度
    // 若不存在j<j且nums[i]%nums[j]==0，则f[i]=1
    // 若存在j<i且nums[i]%nums[j]==0，取符合条件的f[j]的最大值，将nums[i]接到nums[j]之后，更新f[i]=f[j]+1
// 定义g[i]记录f[i]从哪个状态转移而来，若f[i]=f[j]+1，则g[i]=j
// 算法流程
    // 排序数组
    // 尝试将nums[i]接到nums[j]之后，得出所有状态转移关系
    // 遍历f[i]数组，记录最长整数子集的长度f[i]和该子集末尾元素的索引i
    // 利用g[]数组回溯，从nums[i]开始将所有先前状态(nums[j])加入res集合

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.sort(nums);
        // 尝试将nums[i]接到nums[j]之后，更新所有状态转移关系
        for(int i = 0;i<n;i++){
            // 初始化
            f[i] = 1;
            g[i] = i;
            for(int j = 0;j<i;j++){// 更新状态
                if(nums[i] % nums[j]==0 && f[j] + 1 > f[i]){
                    f[i] = f[j] + 1;
                    g[i] = j;
                }
            }
        }
        // 遍历f[i]数组，记录最长整数子集的长度f[i]和该子集末尾元素的索引i
        int maxlen = -1,idx = -1;
        for(int i = 0;i<n;i++){
            if(f[i] > maxlen){
                maxlen = f[i];
                idx = i;
            }
        }
        // 利用g[]数组回溯，从nums[i]开始将所有先前状态加入res集合
        List<Integer> res = new ArrayList<>();
        while(res.size()!=maxlen){
            res.add(nums[idx]);
            idx = g[idx];
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,4,8]\n
// @lcpr case=end

 */

