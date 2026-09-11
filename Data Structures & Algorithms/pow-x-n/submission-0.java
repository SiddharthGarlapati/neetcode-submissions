class Solution {
    public double myPow(double x, int n) {

        double res = rec( x , Math.abs(n));

        return (n > 0) ? res : 1/res;

        
    }

    private double rec(double x, int n){
        if(n == 0) return 1;
        if(x == 0) return 0;

        double res = rec(x, n / 2);
        res = res * res;
        return  n % 2 == 0 ? res : x * res;

    }
}
