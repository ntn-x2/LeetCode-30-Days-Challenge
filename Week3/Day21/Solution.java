/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int numberOfRows = binaryMatrix.dimensions().get(0);
        int numberOfColumns = binaryMatrix.dimensions().get(1);

        int currentColumn = numberOfColumns-1;
        int currentRow = 0;
        int minColumn = -1;

        while (currentColumn >= 0 && currentRow < numberOfRows) {
            if (binaryMatrix.get(currentRow, currentColumn) == 0) {
                currentRow++;
            } else {
                minColumn = currentColumn;
                currentColumn--;
            }
        }

        return minColumn;
    }
}