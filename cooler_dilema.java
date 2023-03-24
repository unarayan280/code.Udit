import java.util.Scanner;

class TheCoolerDilemma2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t != 0) {
            Long x = sc.nextLong();
            Long y = sc.nextLong();
                        
            if ( y % x != 0){
                System.out.println(y / x);
            }
            else{
                System.out.println((y/x)-1);
            }
            t--;
        }
    }

}
