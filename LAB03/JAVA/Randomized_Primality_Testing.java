import java.util.*;
class HelloWorld {
    
    // 1). Randomized Primality Testing using Fermat's Theorem
    public static long GCD(long a,long b){
        while(b!=0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static long power(long a,long n,long mod){
        long res = 1;
        a = a % mod;
        
        while(n > 0){
            
            if( (n & 1) == 1){
                res = (res*a) % mod;
            }
            n = n>>1;
            a = (a*a)%mod;
        }
        return res;
    }
    
    public static boolean isPrime(long n , long k){
        if(n <= 1) return false;
        if(n <= 3) return true; 
        while(k-- > 0){
            Random rand = new Random();
            long r =  (rand.nextLong());
            r = r<0 ? r*-1 : r;
            long a = (r % (n-3) ) + 2;
            // System.out.println(a);
            if(GCD(n,a)!=1){
                return false;
            }
            if(power(a,n-1,n) != 1){
                return false;
            }
        }
        return true;
    }
   
    
    
    public static void main(String[] args) {

        // System.out.println(GCD(7,5));
        // System.out.println(power(149,48,49));
        // System.out.println(power(2,48,49));
        // System.out.println(power(149,48,49));
        long n = 100000007;
        System.out.println(isPrime(n,100));
        
        // for finnding probability of lairs...

        // long liar = 0;
        // for(long a = 2 ; a < n-2 ; a++){
        //     if(power(a,n-1,n)==1) {
        //         liar++;
        //     }
        // }
        // System.out.println("probability of liar : "+ ((double)liar/(n-3)));
        // System.out.println(liar);

        
        
        
        
    }
}