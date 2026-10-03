class Solution {
    public boolean isValidSudoku(char[][] arr) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == '.') continue;
                int currVal = arr[i][j] - '0';
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i][currVal] || cols[j][currVal] || boxes[boxIndex][currVal]) {
                    return false;
                }
                rows[i][currVal] = true;
                cols[j][currVal] = true;
                boxes[boxIndex][currVal] = true;
            }
        }
        return true;
    }
}
