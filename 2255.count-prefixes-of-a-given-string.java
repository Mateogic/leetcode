/*
 * @lc app=leetcode.cn id=2255 lang=java
 * @lcpr version=30204
 *
 * [2255] 统计是给定字符串前缀的字符串数目
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(String word : words){
            if (s.startsWith(word)) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["a","b","c","ab","bc","abc"]\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// ["a","a"]\n"aa"\n
// @lcpr case=end

 */

