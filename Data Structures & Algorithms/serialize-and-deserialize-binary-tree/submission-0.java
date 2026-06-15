/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        char n = 'X';
        List<TreeNode> lvl = lvlorder(root);
        String res = "";
        for (TreeNode t: lvl){
            if (t == null) {
                res += n;
                res += ',';
            } else {
                res += t.val;
                res += ',';
            }
        }
        return res;

    }

    private List<TreeNode> lvlorder(TreeNode root) {
        List<TreeNode> bin = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            bin.add(curr);
            if (curr != null) {
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return bin;
        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        List<TreeNode> b = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();


        for (String s: d) {
            if (s.equals("X")) {
                b.add(null);
            } else {
                b.add(new TreeNode(Integer.parseInt(s)));
            }
        }
        TreeNode root = b.get(0);
        q.add(root);
        int i = 1;

        while (i < b.size() && !q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (i < b.size()) {
                if (b.get(i) != null) {
                    q.add(b.get(i));
                    curr.left = b.get(i);
                }
                i++;
            }

            if (i < b.size()) {
                if (b.get(i) != null) {
                    q.add(b.get(i));
                    curr.right = b.get(i);
                }
                i++;
            }
        }

        return root;
        
    }
}
