package lcfor2020;

public class lc338 {
    public int[] countBits(int num) {//题目最低要求
        int[] fres=new int[num+1];
        for (int i = 0; i <= num; i++) {
            int temp=i&0xffffffff;
            String s = Integer.toBinaryString(temp);
            int count=0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='1'){
                    count++;
                }
            }
            fres[i]=count;
        }
        return fres;
    }
    public int[] countBits1(int num) {//动态规划，官方题解
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }
}
