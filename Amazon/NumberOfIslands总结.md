# NumberOfIslands I

time O(m*n)  for dfs space O(1)
访问过一个点 就把他变为0 再去访问别的点 直到附近都没有相连的1
## bfs
```
class Solution {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static final int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        for(int i=0; i< grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void bfs(char[][] grid, int i, int j){
        Queue<Point> q =  new LinkedList<>();
        q.offer(new Point(i,j));
        grid[i][j] = '0';
        //initialize
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int[] dir : dirs){
                int x = cur.x+ dir[0];
                int y = cur.y+ dir[1];
                if( x < 0 || y< 0 
                   || x >= grid.length || y>= grid[0].length 
                   || grid[x][y] == '0'){
                    continue;
                }
                q.offer(new Point(x,y));
                grid[x][y] = '0';//每发现一个点 就变为'0' 否则在bfs周围点时 会重复寻找
            }
        }
    }
}
```

## dfs
```
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        for(int i =0; i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int x, int y){
        if(x< 0 || y< 0||x >= grid.length || y >= grid[0].length || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        
        dfs(grid, x+1, y);
        dfs(grid, x-1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }

}
```

## unionFind
