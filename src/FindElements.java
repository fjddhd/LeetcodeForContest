import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class FindElements {
    ArrayList<Integer> al;
    TreeNode r;
    public FindElements(TreeNode root) {
        tra(root);
        r=root;
    }

    public boolean find(int target) {
        al=new ArrayList<>();
        tra1(r);
        if (al.contains(target)){
            return true;
        }
        return false;
    }
    public void tra(TreeNode root){
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.addFirst(root);
        root.val=0;
        while (!deque.isEmpty()){
            TreeNode pop = deque.pop();
            int val = pop.val;
            int lcVal=val*2+1;
            int rcVal=val*2+2;
            if (pop.left!=null){
                pop.left.val=lcVal;
                deque.addFirst(pop.left);
            }
            if (pop.right!=null){
                pop.right.val=rcVal;
                deque.addFirst(pop.right);
            }
        }
    }
    public void tra1(TreeNode root){
        if (root==null){
            return;
        }
        al.add(root.val);
        tra1(root.left);
        tra1(root.right);
    }
}
