public class Lc200_Island_Problem {
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int lines=grid.length,rows=grid[0].length;
        int res=0;
        for (int i=0;i<lines;++i){
            for (int j=0;j<rows;++j){
                if (grid[i][j]=='1'){
                    dfs(i,j,grid);
                    res++;
                }
            }
        }
        return res;

    }
    public void dfs(int l,int r,char[][] grid){
        int lines=grid.length,rows=grid[0].length;
        grid[l][r]='0';
        int[][] temp={{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] tempi:temp){
            int j=l+tempi[0],k=r+tempi[1];
            if (j<lines && k<rows && j>=0 && k>=0 && grid[j][k]=='1'){
                dfs(j,k,grid);
            }
        }
    }
}
