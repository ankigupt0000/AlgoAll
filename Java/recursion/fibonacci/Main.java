import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
class Main{
    public static void main(String[] args) throws IOException{
        String str="";
        BigInteger[] fibonacci = new BigInteger[5001];
        fibonacci[0]=new BigInteger("0");
        fibonacci[1]=new BigInteger("1");
        for(int i=2;i<5001;i++){
            fibonacci[i]=fibonacci[i-1].add(fibonacci[i-2]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((str = br.readLine()) != null)
        {
            int number = Integer.parseInt(str);
            //number  = 10;
            System.out.println("The Fibonacci number for "+number+" is "+fibonacci[number]);
        }
    }
}