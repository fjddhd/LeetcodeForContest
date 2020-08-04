import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Contest1030 {
    public String toHexspeak(String num) {
        Long lo=Long.valueOf(num);
        String hexs=Long.toHexString(lo);
        hexs=hexs.replaceAll("1","I");
        hexs=hexs.replaceAll("0","O");
        hexs=hexs.toUpperCase();
        ArrayList<String> al=new ArrayList<>();
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        al.add("F");
        al.add("I");
        al.add("O");
        for (int i=0;i<hexs.length();++i){
            String temp= String.valueOf(hexs.charAt(i));
            if (!al.contains(temp)){
                return "ERROR";
            }
        }
        return hexs;

    }
    public String toBinary(String str){
        //把字符串转成字符数组
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            //toBinaryString(int i)返回变量的二进制表示的字符串
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        return result;
    }
    public String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null){
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    public String tictactoe(int[][] moves) {
        int[][] table=new int[3][3];
        int i=1;
        for (int[] move:moves){
            table[move[0]][move[1]]=i%2==1?1:-1;
            i++;
        }
        for (int ii=0;ii<3;++ii){
            int x=0,y=0,xx=0,yy=0;
            for (int j=0;j<3;++j){
                x+=table[ii][j];
                y+=table[j][ii];
                xx+=table[j][j];
                yy+=table[2-j][j];
            }
            if (x==3){
                return "A";
            }else if (x==-3){
                return "B";
            }
            if (y==3){
                return "A";
            }else if (y==-3){
                return "B";
            }
            if (xx==3){
                return "A";
            }else if (xx==-3){
                return "B";
            }
            if (yy==3){
                return "A";
            }else if (yy==-3){
                return "B";
            }
        }
        if (moves.length<9){
            return "Pending";
        }
        return "Draw";
    }
    public int subtractProductAndSum(int n) {
        ArrayList<Integer> al=new ArrayList<>();
        String s=String.valueOf(n);
        for (int i=0;i<s.length();++i){
            al.add(s.charAt(i)-30);
        }
        int dot=0,sum=0;
        for (int i=0;i<al.size();++i){
            dot*=al.get(i);
            sum+=al.get(i);
        }
        return dot-sum;
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int[] asist=new int[500];
        List<List<Integer>> L_Res=new ArrayList<>();
        List<List<Integer>> L_Temp=new ArrayList<>();
        for (int i=0;i<500;++i){
            L_Temp.add(null);
        }
        for (int i=0;i<groupSizes.length;++i){
            int temp=groupSizes[i];
            if (asist[temp]==0){

                L_Temp.set(temp,new ArrayList<>());
                asist[temp]=groupSizes[i];
                ArrayList<Integer> al_temp= (ArrayList<Integer>) L_Temp.get(temp);
                al_temp.add(i);
                asist[temp]--;
                if (asist[temp]==0){
                    L_Res.add(al_temp);
                    L_Temp.set(temp,null);
                }

            } else if (asist[temp]>1) {
                ArrayList<Integer> al_temp= (ArrayList<Integer>) L_Temp.get(temp);
                al_temp.add(i);
                asist[temp]--;
            }else {
                ArrayList<Integer> al_temp= (ArrayList<Integer>) L_Temp.get(temp);
                al_temp.add(i);
                asist[temp]--;
                L_Res.add(al_temp);
                L_Temp.set(temp,null);
            }
        }
        for (int i=0;i<L_Temp.size();++i){
            if (L_Temp.get(i)!=null){
                ArrayList<Integer> al_temp= (ArrayList<Integer>) L_Temp.get(i);
                L_Res.add(al_temp);
            }
        }
        return L_Res;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int i=0,t=999999;
        while (t>threshold){
            i++;
            int sum=0;
            for (int num:nums){
                int di=num/i;
                if (num%i!=0){
                    di++;
                }
                sum+=di;
            }
            t=sum;
        }
        return i;
    }
}
