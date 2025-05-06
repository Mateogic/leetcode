/*
 * @lc app=leetcode.cn id=2873 lang=java
 * @lcpr version=30204
 *
 * [2873] 有序三元组中的最大值 I
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// lc2873数据增强版
// 下标三元组(i,j,k)取值为(nums[i]-nums[j])*nums[k]
// 固定中间索引j，只需要找到从nums[0]到nums[j-1]的最大值，以及从nums[j+1]到nums[n-1]的最大值，即求三元组取值
// 要找到下标三元组的最大值，需要从1到n-2枚举中间索引j(i<j<k)，维护更新最大值
// 计算后缀最大值suf_max[i] = max(suf_max[i+1],nums[i])，表示从nums[i]到nums[n-1]的最大值
    // 细节:需要访问i+1索引取值，因此初始化suf_max[n-1]=nums[n-1]，然后从n-2倒序处理出来后缀最大值
// 类似地，处理前缀最大值pre_max[i] = max(pre_max[i-1], nums[i])
// 针对索引j，其下标三元组取值为(pre_max[j-1]-nums[j])*suf_max[j+1]
// 注意res数据类型与返回值类型一致为long，否则可能会溢出
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        // 处理后缀最大值
        int[] suf_max = new int[n];
        suf_max[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--)
            suf_max[i] = Math.max(suf_max[i+1], nums[i]);
        // 处理前缀最大值
        int[] pre_max = new int[n];
        pre_max[0]  = nums[0];
        for(int i = 1;i<=n-1;i++)
            pre_max[i] = Math.max(pre_max[i-1], nums[i]);
        for(int j = 1;j<n-1;j++){
            res = Math.max(res, (long)(pre_max[j-1] - nums[j])*suf_max[j+1]);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [12,6,1,2,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,10,3,4,19]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

