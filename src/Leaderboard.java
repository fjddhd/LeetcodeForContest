import java.util.*;

class Leaderboard {

    HashMap<Integer,Integer> hm;
    public Leaderboard() {
        hm=new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (hm.containsKey(playerId)){
            hm.put(playerId,hm.get(playerId)+score);
        }else{
            hm.put(playerId,score);
        }
    }

    public int top(int K) {
        List<Integer> l=new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
//            Integer key = entry.getKey();
            Integer value = entry.getValue();
            l.add(value);
        }
        Collections.sort(l);
        int temp=0;
        for (int i=0;i<K;++i){
            temp+=l.get(l.size()-1-i);
        }
        return temp;
    }

    public void reset(int playerId) {
        if (hm.containsKey(playerId)){
            hm.put(playerId,0);
        }
    }
}
