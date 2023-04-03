/* IMPORTANT: Multiple classes and nested static classes are supported */
 
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
import java.util.*;
*/
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass {
    static int MOD = 1000000007;
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
 
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 
        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 
        */
 
        // Write your code here
 
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        long dp [] = new long[n + 1];
        long sum = 0;
        for(int i = 1 ; i <= k ; i++){;
            dp[i] = sum + 1;
            sum = (sum + dp[i]) % MOD;
        }
 
        for(int i = k + 1 ; i < n ; i++){
            dp[i] = sum;
            sum = (dp[i] + sum - dp[i - k]) % MOD;
        }
 
        System.out.println(dp[n-1]);
        //System.out.println(Arrays.toString(dp));
    }
}