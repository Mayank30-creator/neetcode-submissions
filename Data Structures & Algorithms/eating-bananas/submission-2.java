class Solution {
    long eatingBananas(int mid,int[] piles,int h){
        long hr=0;
        for(int i=0;i<piles.length;i++){
            hr+= Math.ceil((double)piles[i]/mid);
        }
        return hr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high = 0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        int ans=0;
        while(low<=high){
            int mid  = low + (high-low)/2;
            long hours  =  eatingBananas(mid,piles,h);
            if(hours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
