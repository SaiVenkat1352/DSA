/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        convert(head,list);
        int arr[]=new int[list.size()];
        int i=0;
        for(int ele:list)
        {
            arr[i]=ele;
            i++;
        }
        TreeNode res=helper(arr,0,arr.length-1);
        return res;
        
    }
    public TreeNode helper(int arr[],int l,int r)
    {
        if(l>r)return null;
       
        int mid=l+(r-l)/2;
        TreeNode node=new TreeNode(arr[mid]);
        node.left=helper(arr,l,mid-1);
        node.right=helper(arr,mid+1,r);
        return node;

        
    }
    public void convert(ListNode head,List<Integer> list)
    {
        while(head!=null)
        {
            list.add(head.val);
            head=head.next;
        }

    }
}