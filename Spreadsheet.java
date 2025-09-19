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