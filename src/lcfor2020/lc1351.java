package lcfor2020;

public class lc1351 {
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] y=new int[m];
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (grid[i][j]<0){
                    y[i]=j+1;
                    System.out.println(y[i]);
                    break;
                }
            }
        }
        int count=0;
        for (int i=0;i<m;++i){
            if (y[i]==0){
                continue;
            }
            count+=n-(y[i]-1);
        }
        return count;
    }
}
