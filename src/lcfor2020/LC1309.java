package lcfor2020;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LC1309 {
    public String freqAlphabets(String s) {
        ArrayDeque<Character> ad=new ArrayDeque<>();
        for (int i=0;i<s.length();++i){
            if (s.charAt(i)!='#'){
                ad.add((char)(s.charAt(i)+('a'-'1')));
            }else {
                ad.pollLast();
                ad.pollLast();
                int i1 = Integer.parseInt(String.copyValueOf(s.toCharArray(), i -2, 2));
                ad.add((char)('j'+(i1-10)));
            }
        }
        StringBuilder ss= new StringBuilder();
        while (!ad.isEmpty()){
            ss.append(ad.pollFirst());
        }
        return ss.toString();

    }
}
