import java.util.*;
class HDD{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value");
        String n = sc.nextLine();
        int decimal = 0;
        int power = 0;
        for(int i=n.length()-1; i>=0; i--){
            char ch = n.charAt(i);
            int digit;
            if(ch >='0' && ch <='9'){
                digit = ch-'0';
            }else if(ch>='A' && ch<='F'){
                digit = ch-'A'+ 10;
            }else if(ch<='a' && ch<='f'){
                digit = ch-'a'+ 10;
            }else{
                System.out.println("invald ");
                return;
            }
            decimal += digit*Math.pow(16,power);
            power++;
        }
        System.out.println(decimal);
    }
}
