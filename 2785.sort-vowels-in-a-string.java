/*
 * @lc app=leetcode.cn id=2785 lang=java
 * @lcpr version=30204
 *
 * [2785] 将字符串中的元音字母排序
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String sortVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList(
        'a','A','e','E','i','I','o','O','u','U'));
        List<Character> list = new ArrayList<>();
        int n = s.length();
        char c;

        for(int i = 0;i<n;i++){
            c = s.charAt(i);
            if(set.contains(c))
                list.add(c);
        }
        Collections.sort(list);
        char[] t = new char[n];
        for(int i = 0;i<n;i++){
            c = s.charAt(i);
            if(set.contains(c))
                t[i] = list.remove(0);
            else
                t[i] = c;
        }
        return new String(t);
    }
}
// @lc code=end



/*
// @lcpr case=start
// "lEetcOde"\n
// @lcpr case=end

// @lcpr case=start
// "lYmpH"\n
// @lcpr case=end

 */

