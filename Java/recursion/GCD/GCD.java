import java.math.BigInteger;
class GCD{
    public static void main(String args[]){
        System.out.println(gcd(new BigInteger("15"),new BigInteger("20")));
    }
    static BigInteger gcd(BigInteger a, BigInteger b){
        BigInteger remainder = new BigInteger("-1");
        BigInteger min=a;
        BigInteger max=b;
        if(b.compareTo(a)<0){
            min=b;
            max=a;
        }
        remainder = max.mod(min);
        if (remainder.compareTo(new BigInteger("0")) == 0)
            return min;
        else
            return gcd(min, remainder);
    }
}