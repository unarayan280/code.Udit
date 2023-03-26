/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	  Scanner tb = new Scanner(System.in);
	  int T = tb.nextInt();
	  
	  for(int i = 1;i <= T;i++)
	  {
	      int N = tb.nextInt();
	      int temp,r,sum =0;
	      temp = N;    
          while(N > 0)
          {    
          r = N % 10;  
          sum = (sum * 10) + r;    
          N = N / 10;    
          }    
          if(temp == sum)    
          System.out.println("wins");    
          else    
          System.out.println("loses");    
	  }
	}
}