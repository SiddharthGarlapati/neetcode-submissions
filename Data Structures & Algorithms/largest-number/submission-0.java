class Solution {
    public String largestNumber(int[] nums) {

        int n = nums.length;

        String[] strs = new String[n];

        for(int i = 0 ; i < nums.length ; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a,b) -> (b+a).compareTo(a+b));

        if(strs[0].equals("0")){
            return "0";
        }

        String res = "";

        for(String str : strs){
            res += str;
        }

        return res;
    }
}