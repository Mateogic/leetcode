/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Set<Character> set = new HashSet<Character>();
        int res = 0;
        for(int l = 0,r = 0;r < len;r++){
            // 窗口中已存在相同字符，收缩左边界
            while (set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }
            // 出循环条件：符合题意，即窗口内不含重复字符
            set.add(arr[r]);
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

