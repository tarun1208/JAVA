import java.util.Scanner;
class Decimal_Hexa
{
   public static void main(String args[])
   {
     Scanner input = new Scanner( System.in );
     System.out.print("Enter a Decimal Number : ");
     int n =input.nextInt();
     String str=""; 
     char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
 
     while(n>0)
     {
       int rem=n%16; 
       str=hex[rem]+str; 
       n=n/16;
     }
     System.out.println("Decimal to Hexadecimal: "+str);
  }
}
