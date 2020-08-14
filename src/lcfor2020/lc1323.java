package lcfor2020;

public class lc1323 {
    public int maximum69Number (int num) {
        for (int i = (int) Math.log10(num);i>=0;--i){
            if ((num/((int)Math.pow(10,i)))%10 <9){
                return num+3*((int)Math.pow(10,i));
            }
        }
        return num;
    }
}
