class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();



        while(true){
            int sum = 0;
            while(n > 0){
                int rem = n % 10;
                sum += rem * rem;
                n = n/10;
            }
            if(sum == 1) return true;
            if(!set.contains(sum)){
                set.add(sum);
                n = sum;
            }
            else{
                break;
            }

        }

        return false;


    }
}
