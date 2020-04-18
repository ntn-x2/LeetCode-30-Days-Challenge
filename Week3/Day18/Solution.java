class Solution {
    
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int[][] cache = new int[grid.length][grid[0].length];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }

        return minPathSum(grid, 0, 0, cache);
    }

    private int minPathSum(int[][] grid, int row, int col, int[][] cache) {
        if (row >= grid.length || col >= grid[0].length) {
            return -1;
        }
        
        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        int downNextPath = minPathSum(grid, row+1, col, cache);
        int rightNextPath = minPathSum(grid, row, col+1, cache);
        int minFromHere = grid[row][col];

        if (rightNextPath != -1 && downNextPath != -1) {
            minFromHere += Math.min(downNextPath, rightNextPath);
        } else if (downNextPath+rightNextPath > -2) {
            minFromHere += downNextPath == -1 ? rightNextPath : downNextPath;
        }
        cache[row][col] = minFromHere;

        return minFromHere;
    }
}