class Solution: # 10
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        l, r = 0, rows * cols - 1 # 3*4-1 = 11
        while (l <= r):
            mid = (l + r) // 2 # 5, 2, 3, 4
            i = mid // cols # 1, 0, 0, 1
            j = mid % cols # 1, 2, 3, 0
            if (matrix[i][j] == target): 
                return True
            elif (matrix[i][j] > target):
                r = mid - 1 # 4
            else:
                l = mid + 1 # 3, 4
        return False

        