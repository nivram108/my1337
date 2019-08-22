//TAG BFS DFS
class Solution {
    public int numIslands(char[][] grid) {
        return BFS(grid);
    }

    int BFS(char[][] grid) {
        int islandCount = 0;
        if (grid == null || grid.length == 0) {
              return 0;
        }
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        for(int row = 0; row < rowLength; row ++) {
            for(int column = 0; column < columnLength; column ++) {
                Queue<Integer> landToVisit = new LinkedList<>();
                if(grid[row][column] == '1') {
                    landToVisit.add(row * columnLength + column);
                    islandCount ++;
                    grid[row][column] = '0';
                    while(!landToVisit.isEmpty()) {
                        int land = landToVisit.remove();
                        int r = land / columnLength;
                        int c = land % columnLength;

                        if(isValid(grid, r, c - 1))  {
                            grid[r][c - 1] = '0';
                            landToVisit.add(r * columnLength + c - 1);
                        }
                        if(isValid(grid, r, c + 1))  {
                            grid[r][c + 1] = '0';
                            landToVisit.add(r * columnLength + c + 1);
                        }
                        if(isValid(grid, r - 1, c))  {
                            grid[r - 1][c] = '0';
                            landToVisit.add((r - 1) * columnLength + c);
                        }
                        if(isValid(grid, r + 1, c))  {
                            grid[r + 1][c] = '0';
                            landToVisit.add((r + 1) * columnLength + c);
                        }
                    }
                }
            }
        }
        return islandCount;
    }

    void DFS(char[][] grid, int row, int column) {

    }

    boolean isValid(char[][] grid, int row, int column) {
        if(row < 0 || column < 0 || row >= grid.length || column >= grid[0].length)  {
            return false;
        }
        if(grid[row][column] == '0') {
            return false;
        }
        return true;
    }
}
