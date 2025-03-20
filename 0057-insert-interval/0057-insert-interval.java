class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list=new ArrayList<>();
        for(int arr[]:intervals)
        {
            list.add(arr);
        }
        list.add(newInterval);
        Collections.sort(list,(a,b)->a[0]-b[0]);
        int first=list.get(0)[0];
        int second=list.get(0)[1];
        List<int[]> res=new ArrayList<>();
        for(int i=1;i<list.size();i++)
        {
            if(second>=list.get(i)[0])
            {
                second=Math.max(second,list.get(i)[1]);
            }
            else{
                res.add(new int[]{first,second});
                first=list.get(i)[0];
                second=Math.max(second,list.get(i)[1]);
            }
        }
        res.add(new int[]{first,second});
        return res.toArray(new int[0][]);
        
    }
}