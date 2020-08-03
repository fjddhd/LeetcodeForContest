import java.util.*;

public class contest1116 {
    public String encode(int num) {
        int i=1;
        if(num==0){
            return new String();
        }
        while (num>0){
            num-=Math.pow(2,i);
            i++;
        }
        num+=Math.pow(2,--i)-1;
        String s=Integer.toBinaryString(num);
        if(s.length()<i){
            StringBuilder sb=new StringBuilder();
            int k=0;
            while(k<i-s.length()){
                sb.append("0");
                k++;
            }
            sb.append(s);
            s=sb.toString();
        }
        return s;
    }
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        List<String> l= regions.get(0);
        FtTree root=new FtTree(l.get(0));
        ArrayList<FtTree> rootChildrens = root.childrens;
        for (int i=1;i<l.size();++i){
            rootChildrens.add(new FtTree(l.get(i)));
        }
        for (int i=1;i<regions.size();++i){
            List<String> list = regions.get(i);
            String needToFindString = list.get(0);
            FtTree FoundftTree = findNode(root, needToFindString);
            ArrayList<FtTree> foundChildrens = FoundftTree.childrens;
            for (int j=1;j<list.size();++j){
                foundChildrens.add(new FtTree(list.get(j)));
            }
        }
        return null;
    }
    public FtTree findNode(FtTree root,String needToFind){
        if (root==null){
            return null;
        }
        ArrayList<FtTree> childrens = root.childrens;
        Deque<FtTree> deque=new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            FtTree pop = deque.pop();
            deque.addAll(pop.childrens);
            for (int i=0;i<pop.childrens.size();++i){
                if (pop.childrens.get(i).value.equals(needToFind)){
                    return pop.childrens.get(i);
                }
            }
        }
        return null;
    }
    public void tra1(FtTree ftTree){
        if (ftTree==null){
            return;
        }
        ArrayList<FtTree> childrens = ftTree.childrens;
        for (int i=0;i<childrens.size();++i){

        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> l=new ArrayList<>();
        int n=grid.length,m=grid[0].length;
        List<Integer> ll=new ArrayList<>();
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i=0;i<grid.length;++i){
            for (int j=0;j<grid[i].length;++j){
                ll.add(grid[i][j]);
            }
        }
        for (int i=0;i<k;++i){
            Integer integer = ll.get(ll.size() - 1);
            ll.remove(ll.size()-1);
            ll.add(0,integer);
        }
        for (int i=0;i<ll.size();++i){
            System.out.print(ll.get(i));
        }
        for (int i=0;i<grid.length;++i){
            List<Integer> tempL=new ArrayList<>();
            for (int j=0;j<grid[i].length;++j){
                tempL.add(ll.get(j*i+j));
            }
            l.add(tempL);
        }
        return l;
    }

    public int maxSumDivThree(int[] nums) {
        int all=0;
        Arrays.sort(nums);
        for (int a:nums){
            all+=a;
        }
        if (isgood(all)){
            return all;
        }
        for (int i=0;i<nums.length;++i){

        }
        return 0;
    }
    public boolean isgood(int n){
        if (n%3==0)
            return true;
        return false;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[0][0]=0;
        dp[1][0]=1;
        dp[0][1]=1;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (i==0 && j==0 || j==1){
                    break;
                } else if (i==0 && j>1){
                    dp[i][j]=dp[i][j-1];
                }else if (j==0 && i==1){
                    break;
                }else if (j==0 && i>1){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
