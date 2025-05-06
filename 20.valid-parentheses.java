/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30204
 *
 * [20] 有效的括号
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 不用map，仅在遍历到左括号的时候入栈对应的右括号
// 遍历到右括号的时候，判断是否空栈或栈顶括号不同，return false
// 最后return stk.isEmpty()

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)// 长度必是偶数
            return false;
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){// 遍历字符数组
            if(c=='(')// 入栈对应的右括号
                stk.push(')');
            else if(c=='[')
                stk.push(']');
            else if(c=='{')
                stk.push('}');
            else if(stk.isEmpty() || stk.pop()!=c)
                return false;
        }
        return stk.isEmpty();
    }
}
// 使用map
// class Solution {
//     public boolean isValid(String s) {
//         if(s.length()%2!=0)
//             return false;
//         Stack<Character> stk = new Stack<>();
//         Map<Character,Character> mp = new HashMap<>();
//         mp.put(')', '(');
//         mp.put(']', '[');
//         mp.put('}', '{');
//         for(char c:s.toCharArray()){
//             if(!mp.containsKey(c))// c是某种左括号，入栈
//                 stk.push(c);
//             else if(stk.isEmpty() || stk.pop()!=mp.get(c))// c是某种右括号，判断是否空栈，或括号不匹配
//                 return false;
//         }
//         return stk.isEmpty();
//     }
// }
// @lc code=end



/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "()[]{}"\n
// @lcpr case=end

// @lcpr case=start
// "(]"\n
// @lcpr case=end

// @lcpr case=start
// "([])"\n
// @lcpr case=end

 */

