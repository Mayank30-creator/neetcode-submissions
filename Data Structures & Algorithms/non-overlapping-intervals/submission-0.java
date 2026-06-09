class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       int count=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end= intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>intervals[i][0]){
                count++;
                end=Math.min(intervals[i][1],end);
            }
            else{
                end=intervals[i][1];
            }
        }
        return count; 
    }
}
