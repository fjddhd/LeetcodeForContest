package Utils;

public final class MyMath {
    public static void main(String[] args) {
        short x=-3;
//        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Integer.toBinaryString(reverseByBit(x)));
        System.out.println(x);
        System.out.println(reverseByBit(x));
    }
    public static short reverseByBit(short x) {
        short temp=0;
        for (int i = 0; i < 8; i ++)
        {
            temp = (short) (temp << 1);
            temp |= (x >> i) & 0x01;
        }

        return temp;
    }
}
