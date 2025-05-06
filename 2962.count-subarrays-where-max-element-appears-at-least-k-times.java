/*
 * @lc app=leetcode.cn id=2962 lang=java
 * @lcpr version=30204
 *
 * [2962] 统计最大元素出现至少 K 次的子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 滑动窗口
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = 0;
        for(int num:nums)// 寻找最大值
            mx = Math.max(mx,num);

        long res = 0;
        int left = 0, mxCnt = 0;
        for(int num:nums){
            if(num==mx){
                mxCnt++;
            }
            while(mxCnt >= k){// 收缩左边界
                if(nums[left++]==mx)
                    mxCnt--;
            }
            res+=left;// 从0到左边界上一个(left-1)的索引作为子数组的左边界，均满足条件
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,2,3,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,4,2,1]\n3\n
// @lcpr case=end

 */

