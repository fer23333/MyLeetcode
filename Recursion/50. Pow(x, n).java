//先存下half的值 后来return就不用递归到底 2^4 -> 2^2 * 2^2 -> 2^1
//最后还有一种case n为负数 就为half*half/x

public double myPow(double x, int n) {
        if(n == 0 ){
            return 1;
        }
        
        double half = myPow(x, n/2);
        if(n % 2 == 0){
            return half*half;
        }
        if(n >0){
            return x* half * half;
        }
        return half*half/x;
        
    }
