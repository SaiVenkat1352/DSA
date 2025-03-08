class Solution {
    public int trap(int[] height) {
        int l=0;
        int h=height.length-1;
        int leftMax=0;
        int rightMax=0;
        int ans=0;
        while(l<=h)
        {
            if(height[l]<=height[h])
            {
               leftMax= Math.max(leftMax,height[l]);
                ans=ans+Math.abs(leftMax-height[l]);
                l++;
            }
            else{
                rightMax=Math.max(rightMax,height[h]);
                ans=ans+Math.abs(rightMax-height[h]);
                h--;
            }

        }
        return ans;
        
        
    }
}