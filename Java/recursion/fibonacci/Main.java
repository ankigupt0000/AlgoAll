import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Main{
    static final int maxPlaces=63;
    static BigInteger fib[]=new BigInteger[5001];
    static class BigInteger{
        long maxValToStoreInOneLong = 1000000000000000000L;
        Long maxValToStoreInOneLongDivideByTenMinusOne = ((maxValToStoreInOneLong/10L)-1);
        int maxLongDigits = maxValToStoreInOneLongDivideByTenMinusOne.toString().length();
        Long[] arr = new Long[maxPlaces];

        public BigInteger(Long val){
            this.arr[maxPlaces-1]=val;
            for(int i=maxPlaces-2;i>=0;i--){
                this.arr[i]=0L;
            }
        }

        public BigInteger add(BigInteger num2){
            BigInteger num1=this;
            BigInteger sum = new BigInteger(0L);
            int i=0;
            long remainder=0L;
            for(i=maxPlaces-1; i>=0 ;i--){
                long long1=0L, long2=0L;
                if(num1.arr[i]==0L && num2.arr[i]==0L && remainder==0L)
                    break;
                long longSum = num1.arr[i] + num2.arr[i] + remainder;
                remainder=0L;
                if(longSum >= maxValToStoreInOneLong)
                {
                    sum.arr[i]=longSum%maxValToStoreInOneLong;
                    remainder = longSum/maxValToStoreInOneLong;
                }else{
                    sum.arr[i]=longSum;
                }
            }
            return sum;
        }
        public void printBigInt(){
            for(int i=0;i<maxPlaces;i++){
                System.out.print(this.arr[i]);
            }
            System.out.println();
        }
        public String toString(){
            String number = "";
            for(int i=maxPlaces-1;i>=0;i--){
                if(this.arr[i]!=0L){
                    number=this.arr[i]+number;
                    if(this.arr[i-1]!=0L && this.arr[i] < (maxValToStoreInOneLong/10L)){
                        for( int j=maxLongDigits-(this.arr[i].toString().length());j>=0;j--){
                            number="0"+number;
                        }
                    }
                }
            }
            if(number.length()==0)
                return "0";
            return number;
        }
    }
    static BigInteger fibonacci(int n){
        /*if(n<=2)
            return fib[n];
        if(fib[n]==null){
            fib[n]= fibonacci(n-1).add(fibonacci(n-2));
        }*/
        return fib[n];
    }
    public static void main(String args[]) throws IOException{
        fib[0]=new BigInteger(0L);
        fib[1]=new BigInteger(1L);
        fib[2]=new BigInteger(1L);
        for(int i=3;i<=5000;i++)
        {
            fib[i]=fib[i-1].add(fib[i-2]);
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=br.readLine()) != null){
            int number = Integer.parseInt(str);
            System.out.println("The Fibonacci number for "+number+" is "+fibonacci(number));
        }
    }
}