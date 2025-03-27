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
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        int sLen = sarr.length, pLen = parr.length;
        List<Integer> res = new ArrayList<Integer>();
        if (sLen < pLen)// 特殊情况1
            return res;
        // 哈希统计[0,pLen-1]子串包含字符情况
        int[] shash = new int[26];
        int[] phash = new int[26];
        for(int i = 0;i<pLen;i++){
            shash[sarr[i]-'a']++;
            phash[parr[i]-'a']++;
        }
        if (Arrays.equals(shash, phash))// 特殊情况2
            res.add(0);
        // 处理一般情况
        for(int i = 0;i<sLen - pLen;i++){// 枚举从i+1开始的子串
            shash[sarr[i]-'a']--;// 去除i位置元素
            shash[sarr[i+pLen]-'a']++;// 添加i+pLen位置元素
            if (Arrays.equals(shash, phash))
                res.add(i+1);
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

