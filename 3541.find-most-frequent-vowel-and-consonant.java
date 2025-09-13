/*
 * @lc app=leetcode.cn id=3541 lang=java
 * @lcpr version=30204
 *
 * [3541] 找到频率最高的元音和辅音
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Set;

class Solution {
    public int maxFreqSum(String s) {
        int maxy = 0, maxf = 0;// maxy元音最大频率，maxf辅音最大频率
        int[] hash = new int[26];
        for(char c:s.toCharArray()){
            hash[c-'a']++;
        }
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(int i = 0;i<26;i++){
            if(set.contains((char)(i+'a')) && hash[i] > maxy){
                maxy = hash[i];
            }
            else if(!set.contains((char)(i+'a')) && hash[i] > maxf)
                maxf = hash[i];
        }
        return maxf + maxy;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "successes"\n
// @lcpr case=end

// @lcpr case=start
// "aeiaeia"\n
// @lcpr case=end

 */

