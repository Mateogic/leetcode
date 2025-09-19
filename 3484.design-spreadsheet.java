/*
 * @lc app=leetcode.cn id=3484 lang=java
 * @lcpr version=30204
 *
 * [3484] 设计电子表格
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
public class Spreadsheet {
    private Map<String, Integer> cellValues = new HashMap<>();

    public Spreadsheet(int size) {

    }

    public void setCell(String cell, int value) {
        cellValues.put(cell, value);
    }

    public void resetCell(String cell) {
        cellValues.remove(cell);
    }

    public int getValue(String formula) {
        int i = formula.indexOf('+');
        String cell1 = formula.substring(1, i);
        String cell2 = formula.substring(i + 1);
        int val1 = Character.isLetter(cell1.charAt(0)) ? cellValues.getOrDefault(cell1, 0) : Integer.parseInt(cell1);
        int val2 = Character.isLetter(cell2.charAt(0)) ? cellValues.getOrDefault(cell2, 0) : Integer.parseInt(cell2);
        return val1 + val2;
    }
}
/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
// @lc code=end



/*
// @lcpr case=start
// 5+7"], ["A1", 10]\nA1+6"], ["B2", 15]\nA1+B2"], ["A1"]\nA1+B2"]]\n
// @lcpr case=end

 */

