import java.util.ArrayList;

public class FindParent {
    public TreeNode parent;
    public int findParent(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null || parent != null) {

            return 0;
        }
        int value = 0;
        if (root == first || root == second) {

            value = 1;
        }
        value += findParent(root.left, first, second);
        value += findParent(root.right, first, second);
        if (value == 2) {

            parent = root;
            value = 0;
        }

        return value;
    }
    public static FtTree FtParent;
    public static int findFtParent(FtTree root,FtTree first,FtTree second){
        if (root == null || FtParent != null) {

            return 0;
        }
        int value = 0;
        if (root == first || root == second) {

            value = 1;
        }
        ArrayList<FtTree> childrens = root.childrens;
        for (int i=0;i<childrens.size();++i){
            value+=findFtParent(childrens.get(i),first,second);
        }

        if (value == 2) {

            FtParent = root;
            value = 0;
        }
        return value;
    }

}
