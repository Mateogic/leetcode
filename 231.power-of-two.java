/*
 * @lc app=leetcode.cn id=231 lang=java
 * @lcpr version=30204
 *
 * [231] 2 的幂
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 若n>=0，判断：
    // 若n&(n-1) == 0，则n是2的幂，否则不是
// 原理：2的幂次最高位为1，其余位为0，(n-1)最高位为0，其余位为1
// 若n<0，则n不是2的幂次
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 16\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

 */

