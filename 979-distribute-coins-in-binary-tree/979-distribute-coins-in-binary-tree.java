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
    class Pair{
        int nodes;
        int coins;
        
        Pair(){}
        
        Pair(int n, int c){
            nodes = n;
            coins = c;
        }
        
    }
    
    public int res = 0;
    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        helper(root);
        return res;
    }
    
    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair();
        }
        
        Pair lp = helper(root.left);
        Pair rp = helper(root.right);
        
        Pair mp = new Pair();
        mp.nodes = lp.nodes + rp.nodes + 1;
        mp.coins = lp.coins + rp.coins + root.val;
        
        res += Math.abs(mp.nodes - mp.coins);
        
        return mp;
    }
    
}








