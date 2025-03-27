/*
 * @lc app=leetcode.cn id=238 lang=java
 * @lcpr version=30204
 *
 * [238] 除自身以外数组的乘积
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 左右乘积列表
// L[i]代表i左侧所有数字的乘积，L[0]=1
// R[i]代表i右侧所有数字的乘积，L[len-1]=1
// 降低空间复杂度：将输出数组(不算空间复杂度)当作左乘积数组计算
// 不必构造R数组，维护变量R跟踪右侧元素的乘积
// 之后，更新:res[i]=res[i]*R，R=R*nums[i]
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {// 计算左乘积数组
            res[i] = res[i-1] * nums[i-1];
        }
        int R = 1;
        for (int i = len-1; i >=0; i--) {// 更新res数组和右乘积变量
            res[i] *= R;
            R *=nums[i];
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [-1,1,0,-3,3]\n
// @lcpr case=end

 */

