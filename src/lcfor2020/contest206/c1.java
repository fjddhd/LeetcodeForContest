package lcfor2020.contest206;

public class c1 {
    public int numSpecial(int[][] mat) {
        int[] lines=new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int count=0;
            for (int j = 0; j < mat[0].length; j++) {
                count+=mat[i][j];
            }
            if (count==1){
                lines[i]=1;
            }
        }
        int[] cols=new int[mat[0].length];
        for (int i = 0; i < mat[0].length; i++) {
            int count=0;
            for (int j = 0; j < mat.length; j++) {
                count+=mat[j][i];
            }
            if (count==1){
                cols[i]=1;
            }
        }
        int ans=0;
        int len=Math.min(cols.length, lines.length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==1){
                    if (lines[i]==1 && cols[j]==1){
                        ans++;
                    }
                }
            }
        }
        System.out.println(1);
        return ans;
    }

    public static void main(String[] args) {
        c1 cc=new c1();
        cc.numSpecial(new int[][]{{0,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}});
    }
}
