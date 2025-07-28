class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the array
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int first=intervals[0][0];
        int second=intervals[0][1];
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++)
        {
            if(second>=intervals[i][0])
            {
                second=Math.max(second,intervals[i][1]);
            }
            else{
                list.add(new int[]{first,second});
                first=intervals[i][0];
                second=intervals[i][1];
            }
        }
        list.add(new int[]{first,second});
        return list.toArray(new int[0][]);



        
        
        
    }
} 