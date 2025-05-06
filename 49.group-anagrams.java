/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30204
 *
 * [49] 字母异位词分组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 以排序后的字符串作为map的key，value为该key对应的异位词list

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<String, List<String>>();
        for(String str:strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = res.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            res.put(key, list);
        }
        return new ArrayList<List<String>>(res.values());
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["eat", "tea", "tan", "ate", "nat", "bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */

