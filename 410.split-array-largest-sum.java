/*
 * @lc app=leetcode.cn id=410 lang=java
 * @lcpr version=30204
 *
 * [410] 分割数组的最大值
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0, res = 0, mid = 0;
        for(int num:nums){// left为最大值，right为累加和
            right+=num;
            if(num > left)
                left = num;
        }
        while(left <= right){
            mid = left + (right - left)/2;
            if(check(nums, mid) <= k){// 符合要求，但区间累加和的最大值还能更小，向左二分
                res = mid;
                right =  mid - 1;
            }
            else// 不符合要求，向右二分
                left = mid + 1;
        }
        return res;
    }
    public int check(int[] nums, int sum){
        int parts = 1, tmp = 0;// 初始化为1段
        for(int num:nums){
            tmp+=num;
            if(tmp > sum){
                tmp = num;
                parts++;
            }
        }
        return parts;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [7,2,5,10,8]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,4,4]\n3\n
// @lcpr case=end

 */

