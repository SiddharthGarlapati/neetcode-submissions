class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;

        Set<Integer> set = new HashSet<>();

        while( n != 1){
            int sum = 0;
            while(n > 0){
                int rem = n % 10;
                sum += rem * rem;
                n = n / 10;
            }
            n = sum;
            if(set.contains(sum)) return false;
            else set.add(sum);
        }

        return true;
    }
}
