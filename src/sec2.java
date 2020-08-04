import java.util.*;

public class sec2 {
    public int minCostToMoveChips(int[] chips) {
        int cost,mincost=101;
        for (int i=0;i<chips.length;++i){
            cost=0;
            for (int j=0;j<chips.length;++j){
                if (i==j){
                    continue;
                }
                if (Math.abs(chips[j]-chips[i])%2==0){

                }else {
                    cost++;
                }
            }
            mincost=Math.min(mincost,cost);
        }
        return mincost;
    }

    public int longestSubsequence(int[] arr, int difference) {
        int maxLen=1;
        for (int i=0;i<arr.length;++i){
            maxLen=Math.max(maxLen,dfs1(arr,i,difference,1));
        }
        return maxLen;

    }
    public int dfs1(int[] arrr,int start,int difference,int count){
        int temp=arrr[start]+difference;
        int i;
        for (i=start+1;i<arrr.length;++i){
            if (arrr[i]==temp){
                start=i;
                break;
            }
        }
        if (i==arrr.length){
            return count;
        }else {
            return dfs1(arrr,start,difference,count+1);
        }
    }

    public int balancedStringSplit(String s) {
        int temp=0,count=1;
        for (int i=0;i<s.length();++i){
            if (s.charAt(i)=='R'){
                temp++;
            }else{
                temp--;
            }
            if (temp==0){
                count++;
            }
        }
        return count;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result=new ArrayList<>();//0~7
        List<List<Integer>> temp=new ArrayList<>(8);
        int kingx=king[0],kingy=king[1];
        int[] distances=new int[8];
        for (int i=0;i<8;++i){
            distances[i]=Integer.MAX_VALUE;
            temp.add(new ArrayList<>());
        }
        for (int i=0;i<queens.length;++i){
            int queenx=queens[i][0],queeny=queens[i][1];
            if (queenx==kingx){
                if (queeny>kingy){
                    if (queeny-kingy<distances[0]){
                        distances[0]=queeny-kingy;
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(0,al);
                    }

                }else {
                    if (kingy-queeny<distances[4]){
                        distances[4]=kingy-queeny;
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(4,al);
                    }
                }
            }else if (queeny==kingy){
                if (queenx>kingx){
                    if (queenx-kingx<distances[2]){
                        distances[2]=queenx-kingx;
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(2,al);
                    }

                }else {
                    if (kingx-queenx<distances[6]){
                        distances[6]=kingx-queenx;
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(6,al);
                    }
                }
            }else  if (Math.abs(queenx-kingx)==Math.abs(queeny-kingy)){
                if (queenx-kingx>0 && queeny-kingy>0){
                    if (Math.abs(queenx-kingx)+Math.abs(queeny-kingy)<distances[1]){
                        distances[1]=Math.abs(queenx-kingx)+Math.abs(queeny-kingy);
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(1,al);
                    }
                }else if (queenx-kingx>0 && queeny-kingy<0){
                    if (Math.abs(queenx-kingx)+Math.abs(queeny-kingy)<distances[3]){
                        distances[3]=Math.abs(queenx-kingx)+Math.abs(queeny-kingy);
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(3,al);
                    }
                }else if (queenx-kingx<0 && queeny-kingy<0){
                    if (Math.abs(queenx-kingx)+Math.abs(queeny-kingy)<distances[5]){
                        distances[5]=Math.abs(queenx-kingx)+Math.abs(queeny-kingy);
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(5,al);
                    }
                }else if (queenx-kingx<0 && queeny-kingy>0){
                    if (Math.abs(queenx-kingx)+Math.abs(queeny-kingy)<distances[7]){
                        distances[7]=Math.abs(queenx-kingx)+Math.abs(queeny-kingy);
                        ArrayList al=new ArrayList();
                        al.add(queenx);al.add(queeny);
                        temp.set(7,al);
                    }
                }
            }
        }
        for (int i=0;i<temp.size();++i){
            if (temp.get(i).size()==2){
                result.add(temp.get(i));
            }
        }
        return result;
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        return null;
    }
    public int[] jiao(int a,int b,int c,int d){
        int[] res=new int[2];
        res[0]=0;res[1]=0;
        if (c>b){
            return res;
        }
        res[0]=Math.max(a,c);
        res[1]=Math.min(b,d);
        return res;
    }

}
