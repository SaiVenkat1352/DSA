class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int count=0;
        int first=intervals[0][0];
        int second=intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
              if(second>intervals[i][0])
              {
                count++;
                
              }
              else{
                first=intervals[i][0];
                second=intervals[i][1];
              }
        }
        return count;
        
    }
}