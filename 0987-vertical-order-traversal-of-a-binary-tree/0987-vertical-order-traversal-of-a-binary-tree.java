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
class Solution {
    class pair{
        TreeNode node;
        int row,col;
        public pair(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(root,0,0));
        while(!q.isEmpty()){
            pair u=q.remove();
            int r=u.row;
            int c=u.col;
            TreeNode n=u.node;
            map.putIfAbsent(c,new TreeMap<>());
            map.get(c).putIfAbsent(r,new PriorityQueue<>());
            map.get(c).get(r).offer(n.val);
            if(n.left!=null){
                q.offer(new pair(n.left,r+1,c-1));
            }if(n.right!=null){
                q.offer(new pair(n.right,r+1,c+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>>rows:map.values()){
            ArrayList<Integer>temp=new ArrayList<>();
            for(PriorityQueue<Integer>pq:rows.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}