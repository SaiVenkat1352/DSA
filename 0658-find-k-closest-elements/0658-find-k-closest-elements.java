    //Runtime: 3 ms, faster than 99.87% of Java online submissions for Find K Closest Elements.
    //Memory Usage: 44.2 MB, less than 93.40% of Java online submissions for Find K Closest Elements.
    //Slide Window + Binary Search
    //Time: O( lg(N-K) + K); Space: O(1)
class Pair{
    int diff;
    int val;
    Pair(int diff,int val)
    {
        this.diff=diff;
        this.val=val;
    }
}
class Solution{
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> list=new ArrayList<>();
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((Pair a,Pair b)->a.diff==b.diff?b.val-a.val:b.diff-a.diff);
        
        for(int num:nums)
        {
            maxHeap.add(new Pair(Math.abs(num-x),num));
            if(maxHeap.size()>k)maxHeap.remove();
        }
        while(!maxHeap.isEmpty())
        {
            Pair p=maxHeap.remove();
            list.add(p.val);
        }
        Collections.sort(list);
        return list;

        
    }
   
}