/*
 * @lc app=leetcode.cn id=394 lang=java
 * @lcpr version=30204
 *
 * [394] 字符串解码
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.Stack;
/*
 * k[str]其中的str自身可能也是k[str]的格式，形成嵌套编码，因此需要逐对括号递归解码
 * 据此思路，本题可采用递归或辅助栈解决
 * 遇到[时，入栈此前的倍数k和此前拼接的字符串res，并且倍数k和字符串res归零
 * 在[和]之间，处理括号内部的数字和字符串
 * 对于数字，需要考虑多位数字连续的情况(整数的取值范围为 [1, 300] )
 * 对于字母，直接添加到res_tmp后面
 * 遇到]时，弹出栈顶的k用于倍乘括号内的字符串，弹出栈顶的res用于拼接倍乘后的字符串
 */
// 辅助栈
class Solution {
    public String decodeString(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> k_stk = new Stack<>();
        Stack<StringBuilder> res_stk = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '['){// k和res入栈且归零
                k_stk.push(k);
                res_stk.push(res);
                k = 0;
                res = new StringBuilder();
            }
            else if(c == ']'){
                int k_cur = k_stk.pop();
                StringBuilder res_tmp = new StringBuilder();
                // 倍乘括号内的字符串
                for(int i = 0;i<k_cur;i++)
                    res_tmp.append(res);
                // 拼接倍乘后的字符串
                res = res_stk.pop().append(res_tmp);
            }
            // 处理数字
            else if(c >='0' && c<='9')
                k = k*10 + c -'0';
            // 拼接括号内的字符串
            else
                res.append(c);
        }
        return res.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "3[a]2[bc]"\n
// @lcpr case=end

// @lcpr case=start
// "3[a2[c]]"\n
// @lcpr case=end

// @lcpr case=start
// "2[abc]3[cd]ef"\n
// @lcpr case=end

// @lcpr case=start
// "abc3[cd]xyz"\n
// @lcpr case=end

 */

