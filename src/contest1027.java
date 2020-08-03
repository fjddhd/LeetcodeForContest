import java.util.ArrayList;
import java.util.List;

public class contest1027 {
    public int maxLength(List<String> arr) {
        List<List<Integer>> l=new ArrayList();
        int min=-1;
        for (int i=0;i<arr.size();++i){
            String s=arr.get(i);
            min=Math.max(min,s.length());
            ArrayList<Integer> temp=new ArrayList<>();
            for (int j=0;j<26;++j){
                temp.add(0);
            }
            for (int j=0;j<s.length();++j){
                temp.set(s.charAt(j)-'a',1);
            }
            l.add(temp);
        }
        for (int i=0;i<l.size();++i){
            List<Integer> li=l.get(i);
            for (int j=0;j<l.size();++j){
                if (i==j){
                    continue;
                }
                List<Integer> lj=l.get(i);
                Boolean merge=true;
                for (int k=0;k<26;++k){
                    if (li.get(k)==1 && lj.get(k)==1){
                        merge=false;
                        break;
                    }
                }
                if (merge){

                }
            }
        }
        return 1;
    }

    public List<Integer> transformArray(int[] arr) {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<arr.length;++i){
            list.add(arr[i]);
        }
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        while (!isSame(list,list2)){
            list2=new ArrayList<>();
            if (list3.size()!=0){
                list=list3;
            }
            for (int i=0;i<list.size();++i){
                if (i==0 || i==list.size()-1){
                    list2.add(list.get(i));
                }else if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                    list2.add(list.get(i)-1);
                }
                else if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                    list2.add(list.get(i)+1);
                }else {
                    list2.add(list.get(i));
                }
                list3=new ArrayList<>(list2);
            }
        }
        return list;

    }

    public boolean isSame(List<Integer> l1,List<Integer> l2){
        if (l1.size()!=l2.size()){
            return false;
        }
        for (int i=0;i<l1.size();++i){
            if (l1.get(i)!=l2.get(i)){
                return false;
            }
        }
        return true;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0,right=0,single=0,count=0,mark=0;
        for(int i=0;i<nums.length;++i){
            if(single==0){
                if(nums[i]%2==0){
                    left++;
                }else{
                    left++;
                    single++;
                    mark=i;
                }
            }else if(single<k){
                if(nums[i]%2==0){
                }else{
                    single++;
                }
            }else if(single==k){
                if(nums[i]%2==0){
                    right++;
                }else{
                    right++;
                    single++;
                    count+=right*left;
                    right=0;
                    left=0;
                    single=0;
                    i=mark+1;
                }
            }
        }
        return count;

    }
    public int oddCells(int n, int m, int[][] indices) {
        List<List<Integer>> al=new ArrayList<>();
        for (int i=0;i<m;++i){
            al.add(new ArrayList<>());
            List<Integer> all = al.get(al.size() - 1);
            for (int j=0;j<n;++j){
                all.add(0);
            }
        }
        for (int i=0;i<indices.length;++i){
            int line=indices[i][0],col=indices[i][1];
            addline(al,line);
            addcol(al,col);
        }
        int count=0;
        for (int i=0;i<al.size();++i){
            List<Integer> all=al.get(i);
            for (int j=0;j<all.size();++j){
                if (all.get(j)%2!=0){
                    count++;
                }
            }
        }
        return count;
    }
    public void addline(List<List<Integer>> al,int line){
        for (int i=0;i<al.size();++i){
            List<Integer> all = al.get(i);
            all.set(line,all.get(line)+1);
        }
    }
    public void addcol(List<List<Integer>> al,int col){
        List<Integer> all=al.get(col);
        for (int i=0;i<all.size();++i){
            all.set(i,all.get(i)+1);
        }
    }
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int all=0;
        List<List<Integer>> al=new ArrayList<>();
        for (int c:colsum){
            all+=c;
        }
        if (all!=upper+lower){
            return al;
        }
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        for (int i=0;i<colsum.length;++i){
            List<Integer> al1= al.get(0);
            List<Integer> al2= al.get(1);
            if (colsum[i]==2){
                al1.add(1);
                al2.add(1);
                upper--;
                lower--;
            }else {
                al1.add(0);
                al2.add(0);
            }
        }
        for (int i=0;i<colsum.length;++i){
            List<Integer> al1= al.get(0);
            List<Integer> al2= al.get(1);
            if (colsum[i]==1){
                if (upper>0){
                    al1.set(i,1);
                    upper--;
                }else if (upper==0 && lower>0){
                    al2.set(i,1);
                    lower--;
                }
            }
        }
        return al;
    }

}
