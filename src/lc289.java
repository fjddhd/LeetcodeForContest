public class lc289 {
    public void gameOfLife(int[][] board) {
        int[] a=new int[]{-1,0,1};
        int[][] asistBoard=new int[board.length][board[0].length];
//        int[][] nextBoard=new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==1){
                    for (int k = 0; k < a.length; k++) {
                        for (int l = 0; l < a.length; l++) {
                            if (k==1 && l==1){
                                continue;
                            }
                            int x=i+a[k],y=j+a[l];
                            if (x>=0 && x<board.length && y>=0 && y<board[0].length){
                                asistBoard[x][y]++;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==1){
                    if (asistBoard[i][j]<2 || asistBoard[i][j]>3){
                        board[i][j]=0;
                    }
                }else {
                    if (asistBoard[i][j]==3){
                        board[i][j]=1;
                    }
                }
            }
        }

    }

}
