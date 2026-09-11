class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){

        int m = nums1.length;
        int n = nums2.length;

        if( m > n) {
            return findMedianSortedArrays(nums2,nums1);
        }

        int total = m + n;
        int half = total/2;

        int left = 0 ; 
        int right = m - 1;

        while(true){
            int i = (int)Math.floor((left + right) / 2.0);
            int j = half - i - 2;

            int Aleft = (i >=0) ? nums1[i]: Integer.MIN_VALUE;
            int Aright = (i+1 < m) ?nums1[i+1]: Integer.MAX_VALUE;
            int Bleft = (j >=0) ?nums2[j] : Integer.MIN_VALUE;
            int Bright = (j + 1 < n) ? nums2[j+1] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 == 0) return (double)(Math.max(Aleft,Bleft) + Math.min(Aright,Bright))/2.0;
                else return (double)(Math.min(Aright,Bright));

            }
            else if (Aleft > Bright){
                right = i - 1;
            }
            else{
                left = i + 1;
            }
        }


    }
}
