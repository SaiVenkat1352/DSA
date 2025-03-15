class Pair{
    int freq;
    int val;
    Pair(int freq,int val)
    {
        this.freq=freq;
        this.val=val;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int ele:nums)
        {
            map.put(ele,map.getOrDefault(ele,0)+1);

        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((Pair a,Pair b)->a.freq-b.freq);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           pq.add(new Pair(entry.getValue(),entry.getKey()));
           if(pq.size()>k)
           {
              pq.remove();
           }
        }
        int res[]=new int[pq.size()];
        int i=0;
        while(!pq.isEmpty())
        {
            res[i++]=pq.remove().val;

        }
        return res;
       
    }
}