import java.io.*;
import java.util.*;
 
 
public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String out_ = solve(N);
            wr.println(out_);
        }
 
        wr.close();
        br.close();
    }
 
    static String solve(int n) {
      int mid=n/2;
      boolean isPrime=true;
      
         if(n<=3) 
         return "No";
           
           if(n%2==0 || n%3==0)
              return "Yes";
 
           for(int i=5 ; i*i<=n ;i=i+6){
             if(n%i==0 || n %(i+2)==0){      
               return "Yes";
             }
           }
 
          
 
          
             return "No";
  }
}