class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in board:
            
            for j in range(len(row)):
                if row[j] != '.': 
                    if row[j] in row[j+1:]:
                        return False
                    for column in board:
                        if not column is row:
                            if column[j] == row[j]:
                                return False
        squares = {}
        sector = 1
        y_min, y_max, x_min, x_max = 0, 3, 0, 3
        while sector < 10:
            squares[sector] = []
            for i in range(y_min, y_max):
                squares[sector] += board[i][x_min:x_max]
            sector += 1
            if x_max == 9:
                x_min, x_max, y_min, y_max = 0, 3, y_min + 3, y_max + 3
            else:
                x_min, x_max = x_min + 3, x_max + 3
        for i in range(1,10):
            for j in range(9):
                if squares[i][j] != '.':
                    if squares[i][j] in squares[i][j+1:]:
                        return False
        return True
        
        