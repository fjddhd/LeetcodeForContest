package lcfor2020;

public class M_lc6 {
    public static String convert(String s, int numRows) {
        if (s.length()==0){
            return new String();
        }
        if (numRows==1){
            return s;
        }
        int[] mn=getRowLine(s.length()+1,numRows);
        char[][] ress=new char[numRows][mn[0]];
        for (int i=0;i<s.length();++i){
            mn=getRowLine(i+1,numRows);
            ress[mn[1]][mn[0]-1]=s.charAt(i);
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<ress.length;++i){
            for (int j=0;j<ress[0].length;++j){
                if (ress[i][j]!=0){
                    sb.append(ress[i][j]);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static int[] getRowLine(int numOfString, int numRows){
        int[] res=new int[2];
        int num=numOfString;
        int numOfFirstZ=3*numRows-2;//加numRows列
        int numOfPlusZ=numOfFirstZ-numRows;//加numRows-1列

        int countPlusZ=num/numOfPlusZ;
        int remainderOfPlusZ=num%numOfPlusZ;
        int remainderOfPlusZOfNumRows=remainderOfPlusZ%numRows;
        if (remainderOfPlusZ==0 || remainderOfPlusZ>numRows){
            if (remainderOfPlusZ==0){
                res[0]=(countPlusZ-1)*(numRows-1)+1+(numRows-2);
            }else {
                res[0]=countPlusZ*(numRows-1)+1+remainderOfPlusZOfNumRows;
            }
        }else {
            res[0]=countPlusZ*(numRows-1)+1;
        }
        //算行数：
        int remainder1=num%numOfPlusZ;
        if (remainder1<numRows && remainder1>0){
            res[1]=remainder1-1;
        }else if (remainder1==0){
            res[1]=1;
        }
        else {
            int remainder2=remainder1%numRows;
            res[1]=numRows-remainder2-1;
        }
        return res;
    }

    public static void main(String[] args) {
        String result=convert("LEETCODEISHIRING",4);
        System.out.println(result);
//        for (int i=0;i<16;++i) {
//            int[] mn=getRowLine(i+1,4);
//            System.out.println(mn[0]+"  "+mn[1]);
//        }
    }
}
