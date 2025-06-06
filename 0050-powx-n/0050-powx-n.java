class Solution {
    double ans = 1;
    public double myPow(double x, int n) {
        if(n == 0){
            return (double)(1);
        }

        long exp = n;

        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }

        return helper(x, exp);
        

    }

    public double helper(double x, long n){
        if(n == 0){

            return 1;
            
        }

        double half = helper(x, n/2);

        if(n % 2 == 0){
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
}