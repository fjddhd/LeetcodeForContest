import java.util.ArrayList;

public class FindParent {
    public TreeNode parent;
    public int findParent(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null || parent != null) {
            // Accelerate check
            return 0;
        }
        int value = 0;
        if (root == first || root == second) {
            // 只要找到目标节点就设置该层权重value为0并返回给上一层
            value = 1;
        }
        value += findParent(root.left, first, second);
        value += findParent(root.right, first, second);
        if (value == 2) {
            // find the common parent of the first and second TreeNode
            parent = root;
            value = 0;
        }
        //
        return value;
    }
    public static FtTree FtParent;//输出结果
    public static int findFtParent(FtTree root,FtTree first,FtTree second){
        if (root == null || FtParent != null) {//-TODO 注意FtParent静态，在实际使用中应作出调整
            // Accelerate check
            return 0;
        }
        int value = 0;
        if (root == first || root == second) {
            // 只要找到目标节点就设置该层权重value为0并返回给上一层
            value = 1;
        }
        ArrayList<FtTree> childrens = root.childrens;
        for (int i=0;i<childrens.size();++i){
            value+=findFtParent(childrens.get(i),first,second);
        }

        if (value == 2) {
            // find the common parent of the first and second TreeNode
            FtParent = root;
            value = 0;
        }
        //
        return value;
    }

}
