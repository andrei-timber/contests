class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the first row that starts with <= target integer
        int rt = 0, rb = matrix.length - 1, i = 0;
        while (rt <= rb) {
            i = (rb + rt) / 2;
            if (matrix[i][0] > target) {
                rb = i - 1;
            } else if (matrix[i][0] < target) {
                if (i + 1 < matrix.length && matrix[i + 1][0] <= target) {
                    rt = i + 1;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        // search for the element in the ith row
        int cl = 0, cr = matrix[i].length - 1, j = 0;
        while (cl <= cr) {
            j = (cl + cr) / 2;
            if (matrix[i][j] > target) {
                cr = j - 1;
            } else if (matrix[i][j] < target) {
                cl = j + 1;
            } else {
                return true;
            }
        }
        return matrix[i][j] == target;
    }
}