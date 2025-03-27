/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30204
 *
 * [76] 最小覆盖子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 滑动窗口
class Solution {
    public static String minWindow(String s, String t) {
        // 记录字符频数
        int[] hs = new int[128];
        int[] ht = new int[128];
        String res = "";
        int required = 0;// 待匹配的字符种类数，若t="aaabbcccc"，则待匹配字符种类数为3
        int matched = 0;// 已匹配的字符种类数
        for(char c:t.toCharArray()){// 记录字符频数、以及待匹配字符种类数
            if (ht[c]==0)
                required++;
            ht[c]++;
        }
        // 滑动窗口
        for(int left = 0, right = 0; right < s.length();right++){
            char rightChar = s.charAt(right);
            hs[rightChar]++;
            if (hs[rightChar]==ht[rightChar]) // 已经成功匹配字符种类+1
                matched++;
            // 尝试收缩左边界，要求满足hs[s.charAt(left)] > ht[s.charAt(left)]，所以收缩也不会使matched减小
            while (left < right && hs[s.charAt(left)] > ht[s.charAt(left)]) {
                hs[s.charAt(left)]--;
                left++;    
            }
            // 如果所有字符种类均匹配上，检查是否比之前的res长度更小
            if (matched==required) {
                if (res.isEmpty() || right-left+1 < res.length()) 
                    res = s.substring(left, right+1);
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "ADOBECODEBANC"\n"ABC"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"aa"\n
// @lcpr case=end

 */

