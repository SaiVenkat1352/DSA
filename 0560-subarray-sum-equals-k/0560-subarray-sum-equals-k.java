class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> map=new HashMap<>();
       map.put(0,1);
       int sum=0;
       int count=0;
       for(int ele:nums)
       {
         sum=sum+ele;
         //check it the sum-k present in map or not
         if(map.containsKey(sum-k))
         {
            count=count+map.get(sum-k);
         }
         map.put(sum,map.getOrDefault(sum,0)+1);

       }
       return count;
        
    }
}