class Solution {
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int total = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (isVisited(visited, row, col) || !isLand(grid, row, col)) {
                    continue;
                }
                total += 1;
                visitIsland(grid, row, col, visited);
            }
        }

        return total;
    }

    private boolean isVisited(boolean[][] visited, int row, int col) {
        return visited[row][col];
    }    

    private boolean isLand(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == '1';
    }    
    
    private void visitIsland(char[][] grid, int row, int col, boolean[][] visited) {
        if (!isLand(grid, row, col)) {
            return;
        }
        if (isVisited(visited, row, col)) {
            return;
        }
        setVisited(visited, row, col);
        visitIsland(grid, row-1, col, visited);
        visitIsland(grid, row, col-1, visited);
        visitIsland(grid, row+1, col, visited);
        visitIsland(grid, row, col+1, visited);
    }

    private void setVisited(boolean[][] visited, int row, int col) {
        visited[row][col] = true;
    }
}