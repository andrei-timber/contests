class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        l, r = 0, rows * cols - 1
        while (l <= r):
            mid = (l + r) // 2
            i = mid // cols
            j = mid % cols
            if (matrix[i][j] == target): 
                return True
            elif (matrix[i][j] > target):
                r = mid - 1
            else:
                l = mid + 1
        return False

        