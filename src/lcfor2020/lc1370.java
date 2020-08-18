package lcfor2020;

import java.util.*;

public class lc1370 {
    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        Map<Character,Integer> hm=new LinkedHashMap<>();
        int count=1;
        for (int i=1;i<chars.length;++i){
            if (chars[i]!=chars[i-1]){
                hm.put(chars[i-1],count);
                count=1;
            }else {
                count++;
            }
        }
        hm.put(chars[chars.length-1],count);
        StringBuilder sbRes=new StringBuilder();
        Boolean oddOrEven=false;//false=odd,true=even
        while (!hm.isEmpty()){
            StringBuilder sbTemp=new StringBuilder();
            Iterator<Map.Entry<Character, Integer>> iterator = hm.entrySet().iterator();
            hm=new LinkedHashMap<>();
            while (iterator.hasNext()){
                Map.Entry<Character, Integer> next = iterator.next();
                sbTemp.append(next.getKey());
                int countTemp=next.getValue()-1;
                if (countTemp>0){
                    hm.put(next.getKey(),countTemp);
                }else {
//                    hm.remove(next.getKey());
                }
            }
            if (oddOrEven){
                sbRes.append(sbTemp.reverse());
            }else {
                sbRes.append(sbTemp);
            }
            oddOrEven=!oddOrEven;
        }
        return sbRes.toString();

    }

    public static void main(String[] args) {
        sortString("aaaabbbbcccc");
    }
}
