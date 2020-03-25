package BinarySearch;

/**
 * Question 74: Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int left = 0, right = matrix[0].length, row = 0;

        while (row < matrix.length) {
            while (left < matrix[0].length) {
                if (matrix[row][left] > target)
                    return false;
                else if (matrix[row][right-1] < target)
                    break;
                else {
                    int mid = (left + right) / 2;
                    if (matrix[row][mid] == target)
                        return true;
                    else if (matrix[row][mid] < target)
                        left = mid;
                    else
                        right = mid;
                }
                if (left == right)
                    break;
            }
            row++;
        }
        return false;
    }
}
