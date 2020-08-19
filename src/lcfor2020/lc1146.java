package lcfor2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class lc1146 {//Ͱ
    List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
    int snap = 0;
    public lc1146(int length) {
        for (int i=0; i<length; i++)
            arr.add(new TreeMap<>());
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        tm.put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        Integer key = tm.floorKey(snap_id);
        return key == null ? 0 : tm.get(key);
    }

}
