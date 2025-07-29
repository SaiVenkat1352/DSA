class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int k=60;
        
        for(int i=0;i<time.length;i++)
        {
            int rem=time[i]%k;
             if(rem==0 && map.containsKey(rem))count=count+map.get(rem);
             else if(map.containsKey(k-rem))
             {
                count=count+map.get(k-rem);
             }
             map.put(rem,map.getOrDefault(rem,0)+1);

            
        }
        return count;
        
    }
}
