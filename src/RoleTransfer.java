import java.util.ArrayList;
import java.util.List;

public class RoleTransfer {
    /***
     * Input: AnM × N matrix S that is the role repository matrix.
     * Output: TRUE if S has partitions; and FALSE if it has no partition.
     * 如：{{1,1,0,0},{1,1,0,0},{0,1,1,1},{0,0,1,1},{0,0,0,1}}
     * 为：
     * 1,1,0,0
     * 1,1,0,0
     * 0,1,1,1
     * 0,0,1,1
     * 0,0,0,1
     * * */
    public boolean CheckPartition(int[][] S_Matrices){
        int M=S_Matrices.length,N=S_Matrices[0].length;//M:size of agents;N:size of roles

        ArrayList<Integer> A=new ArrayList<>();//size:M
        for (int tempi=0;tempi<M;++tempi){
            A.add(0);
        }
        ArrayList<Integer> R=new ArrayList<>();//size:N
        for (int tempi=0;tempi<N;++tempi){
            R.add(0);
        }
        int i=0,j=0,asist=0;
        for (;i<M;++i){
            if (asist==1){
                i--;
                break;
            }
            for (;j<N;++j){
                if (S_Matrices[i][j]==1){
                    asist=1;
                    break;
                }
            }
        }
        if (i>0){
            return true;
        }
        A.set(i,1);
        R.set(j,1);
        int T=1;
        List<Integer> Crba=CRBA(S_Matrices,i);
        while (T==1){
            T=0;
        }
        return true;

    }
    public List<Integer> CRBA(int[][] S_Matrices,int i){
        List<Integer> L=new ArrayList<>();
        for (int j=0;j<S_Matrices[0].length;++j){
            if (S_Matrices[i][j]==1){
                L.add(j);
            }
        }
        return L;
    }
    public List<Integer> CABR(int[][] S_Matrices,int j){
        List<Integer> L=new ArrayList<>();
        for (int i=0;i<S_Matrices.length;++i){
            if (S_Matrices[i][j]==1){
                L.add(i);
            }
        }
        return L;
    }

}
