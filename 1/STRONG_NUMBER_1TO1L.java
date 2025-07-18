class all{
    public static void main(String[]args){
        for(long i=0;i<=100000;i++){
            if(isStrong(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isStrong(long num){
        long sum=0;
        for(;num!=0;num=num/10){
            long digit = num%10;
            long fact=1;
            for(long i=1;i<=digit;i++){
                fact*=i;
            }
            sum+=fact;
        }
        if(sum==num){
            return true;
        }
        else{
            return false;
        }
    }
}
