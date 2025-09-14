/*
 * @lc app=leetcode.cn id=966 lang=java
 * @lcpr version=30204
 *
 * [966] 元音拼写检查器
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        Set<String> origin = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerToOrigin = new HashMap<>(n);
        Map<String, String> vowelToOrigin = new HashMap<>(n);
        for(int i = n-1;i>=0;i--){// 倒序遍历保留最早(靠左侧)出现的单词
            String s = wordlist[i];
            String lower = s.toLowerCase();
            lowerToOrigin.put(lower, s);// 例如 kite -> KiTe
            vowelToOrigin.put(replaceVowels(lower), s);// 例如 k?t? -> KiTe
        }
        for(int i = 0;i<queries.length;i++){
            String q = queries[i];
            if(origin.contains(q))// 完全匹配
                continue;
            String lower = q.toLowerCase();
            if(lowerToOrigin.containsKey(lower))// 不区分大小写的匹配
                queries[i] = lowerToOrigin.get(lower);
            else if(vowelToOrigin.containsKey(replaceVowels(lower)))// 不区分大小写+元音模糊匹配
                queries[i] = vowelToOrigin.get(replaceVowels(lower));
            else
                queries[i] = "";
        }
        return queries;
    }

    public String replaceVowels(String s){// 将s种的元音全换成? kite->k?t?
        char[] schar = s.toCharArray();
        for(int i = 0;i<schar.length;i++){
            char c = schar[i];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                schar[i] = '?';
            }
        }
        return new String(schar);
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["KiTe","kite","hare","Hare"]\n["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]\n
// @lcpr case=end

// @lcpr case=start
// ["yellow"]\n["YellOw"]\n
// @lcpr case=end

 */

