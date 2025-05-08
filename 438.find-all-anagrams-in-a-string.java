/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30204
 *
 * [438] 找到字符串中所有字母异位词
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[26];
        for(char c : p.toCharArray())
            cnt[c-'a']++;
        char[] ss = s.toCharArray();
        int n = ss.length;
        for(int l = 0, r = 0;r<n;r++){
            char c = ss[r];
            cnt[c-'a']--;
            while(cnt[c-'a'] < 0)
                cnt[ss[l++]-'a']++;
            if(r-l+1 == p.length())
                res.add(l);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */

