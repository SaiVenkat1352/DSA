import java.util.HashSet;

class Solution {
public int longestConsecutive(int[] nums) {
    
    Set<Integer> set=new HashSet<>();
    for(int ele:nums)
    {
        set.add(ele);
    }
    if(set.size()==1)return 1;
    int maxi=0;
    for(int ele:set)
    {
        int prev=ele-1;
        if(!set.contains(prev))
        {
            int count=0;
            while(set.contains(ele))
            {
                count++;
                ele=ele+1;
            }
            maxi=Math.max(maxi,count);

        }

    }
    return maxi;
    
	      
	            
	            
	        
	        
	        
	        
	    



	
	
	   
	    
	    
	}
}
