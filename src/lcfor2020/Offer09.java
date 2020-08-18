package lcfor2020;

import java.util.Stack;

public class Offer09 {
    Stack<Integer> s1,s2;
    public Offer09() {//Ô­ÌâÎªCQueue
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void appendTail(int value) {
        s2.push(value);
    }

    public int deleteHead() {
        if (s2.empty()){
            return -1;
        }
        while (!s2.empty()){
            s1.push(s2.pop());
        }
        int res=s1.pop();
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        return res;
    }
}
