package graph;

public class LC_200_NumberofIslands {

    static int[] drow = new int[] { 0, 1, -1, 0 };
    static int[] dcol = new int[] { 1, 0, 0, -1 };

    /*
     * TC: O(n * m) - where n is the number of rows and m is the number of
     * columns in the grid
     * SC: O(n * m) - for the visited array
     */

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, rows, cols, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void dfs(int row, int col, int totalRows, int totalCols, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];

            if (newRow >= 0 && newRow < totalRows
                    && newCol >= 0 && newCol < totalCols
                    && !visited[newRow][newCol]
                    && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, totalRows, totalCols, grid, visited);
            }
        }
    }

    /**
     * Space optimized version:
     * 
     * int[] drow = new int[] { 0, 1, -1, 0 };
     * int[] dcol = new int[] { 1, 0, 0, -1 };
     * 
     * public int numIslands(char[][] grid) {
     * 
     * int rows = grid.length;
     * int cols = grid[0].length;
     * int islands = 0;
     * // boolean[][] visited = new boolean[rows][cols];
     * 
     * for (int i = 0; i < rows; i++) {
     * for (int j = 0; j < cols; j++) {
     * if (grid[i][j] == '1') {
     * dfs(i, j, rows, cols, grid);
     * islands++;
     * }
     * }
     * }
     * 
     * return islands;
     * 
     * }
     * 
     * private void dfs(int row, int col, int totalRows, int totalCols, char[][]
     * grid) {
     * 
     * grid[row][col] = '#';
     * 
     * for (int i = 0; i < 4; i++) {
     * int newRow = row + drow[i];
     * int newCol = col + dcol[i];
     * 
     * if (newRow >= 0 && newRow < totalRows
     * && newCol >= 0 && newCol < totalCols
     * && grid[newRow][newCol] == '1') {
     * dfs(newRow, newCol, totalRows, totalCols, grid);
     * }
     * 
     * }
     * 
     */

    public static void main(String[] args) {
        char[][] grid1 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid1)); // Output: 3

        char[][] grid2 = {
                { '1', '1', '1' },
                { '0', '1', '0' },
                { '1', '1', '1' }
        };
        System.out.println(numIslands(grid2)); // Output: 1

        char[][] grid3 = {
                { '0', '0', '0' },
                { '0', '0', '0' },
                { '0', '0', '0' }
        };
        System.out.println(numIslands(grid3)); // Output: 0

        char[][] grid4 = {
                { '1' }
        };
        System.out.println(numIslands(grid4)); // Output: 1

        char[][] grid5 = {
                { '0' }
        };
        System.out.println(numIslands(grid5)); // Output: 0
    }
}
