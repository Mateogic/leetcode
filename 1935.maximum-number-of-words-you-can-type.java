/*
 * @lc app=leetcode.cn id=1935 lang=java
 * @lcpr version=30204
 *
 * [1935] 可以输入的最大单词数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Set;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        for(char c:brokenLetters.toCharArray())
            set.add(c);
        boolean flag;

        for(String word : words){
            flag = true;
            for(char c : word.toCharArray()){
                if(set.contains(c)){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                cnt ++;
        } 
        return cnt;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "hello world"\n"ad"\n
// @lcpr case=end

// @lcpr case=start
// "leet code"\n"lt"\n
// @lcpr case=end

// @lcpr case=start
// "leet code"\n"e"\n
// @lcpr case=end

 */

