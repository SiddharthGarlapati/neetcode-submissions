class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        int leftMin = 0 ;
        int leftMax = 0;

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                leftMax++;
                leftMin++;
            }
            else if(s.charAt(i) == ')'){
                leftMax--;
                leftMin--;
            }
            else{
                leftMax++;
                leftMin--;
            }
            if(leftMax < 0) return false;
            if(leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
        
    }


}
