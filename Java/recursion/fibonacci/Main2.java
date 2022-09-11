import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Main{
    static String add(String num1, String num2){
        String sum="";
        if(num2.length()>num1.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        long remainder=0;
        for(int i=num1.length(),j=num2.length();i>0 || j>0;i--,j--){
            long digit1=0L,digit2=0L;
            if(i!=0)
                digit1=Long.parseLong(num1.substring(i-1,i));
            if(j!=0)
                digit2=Long.parseLong(num2.substring(j-1,j));
            long intSum = digit1 + digit2 + remainder;
            sum=(intSum)%10L+sum;
            remainder=(intSum)/10L;
        }
        if(remainder>0){
            sum=remainder+sum;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        String str="";
        String[] fibonacci = new String[5001];
        fibonacci[0]="0";
        fibonacci[1]="1";
        for(int i=2;i<5001;i++){
            fibonacci[i]=add(fibonacci[i-1],fibonacci[i-2]);
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