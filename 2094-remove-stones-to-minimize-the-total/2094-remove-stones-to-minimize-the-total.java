class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int ele:piles)
        {
            pq.add(ele);
        }
        while(k-->0)
        {
            int stone=pq.remove();
            if(stone%2==0)
            {
                pq.add(stone/2);
            }
            else{
                pq.add(stone/2+1);
            }
        }
        int res=0;
        while(!pq.isEmpty())
        {
            res=res+pq.remove();

        }
        return res;

    }
}