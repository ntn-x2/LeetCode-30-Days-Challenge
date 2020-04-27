class Solution {
    
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] auxiliaryMatrix = new int[rows][cols];
        int maxSquareLength = 0;

        for (int i = 0; i < rows; i++) {
            auxiliaryMatrix[i][0] = matrix[i][0] - '0';
            maxSquareLength = Math.max(auxiliaryMatrix[i][0], maxSquareLength);
        }

        for (int j = 0; j < cols; j++) {
            auxiliaryMatrix[0][j] = matrix[0][j] - '0';
            maxSquareLength = Math.max(auxiliaryMatrix[0][j], maxSquareLength);
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    int leftElement = auxiliaryMatrix[row][col-1];
                    int topElement = auxiliaryMatrix[row-1][col];
                    int topLeftElement = auxiliaryMatrix[row-1][col-1];
                    int maxLocalSquareLength = Math.min(topElement, Math.min(leftElement, topLeftElement)) + 1;
                    auxiliaryMatrix[row][col] = maxLocalSquareLength;
                    maxSquareLength = Math.max(maxSquareLength, maxLocalSquareLength);
                } else {
                    auxiliaryMatrix[row][col] = 0;
                }
            }
        }
        return (int) Math.pow(maxSquareLength, 2);
    }
}