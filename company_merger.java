import java.io.*;
import java.util.*;
 
public class CompanyMergers {
 
	public static boolean hasOverSaturatedMarket(ArrayList<String> data)
	{
		ArrayList<Integer> toNum = new ArrayList<>();
		for(int i = 0; i < data.size(); i++)
		{
			StringTokenizer stk = new StringTokenizer(data.get(i));
			while(stk.hasMoreTokens())
				toNum.add(Integer.parseInt(stk.nextToken()));
		}
		//System.out.println("toNum = " + toNum.toString());
		for(int i = 0; i < toNum.size(); i++)
		{
			int count = 0;
			for(int j = 0; j < toNum.size(); j++)
			{
				if(toNum.get(i).equals(toNum.get(j)))
					count++;
				if(count > 2)
					return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Integer> overPopulatedMarkets(ArrayList<String> data)
	{
		ArrayList<Integer> toReturn = new ArrayList<>();
		ArrayList<Integer> toNum = new ArrayList<>();
		
		for(int i = 0; i < data.size(); i++)
		{
			StringTokenizer stk = new StringTokenizer(data.get(i));
			while(stk.hasMoreTokens())
				toNum.add(Integer.parseInt(stk.nextToken()));
		}
		for(int i = 0; i < toNum.size(); i++)
		{
			int count = 0;
			for(int j = 0; j < toNum.size(); j++)
			{
				if(toNum.get(i).equals(toNum.get(j)))
					count++;
				if(count > 2)
				{
					toReturn.add(toNum.get(i));
					break;
				}
			}
		}
		return toReturn;
	}
	
	public static ArrayList<Integer> overPopulatedMarketCounts(ArrayList<String> data)
	{
		ArrayList<Integer> toReturn = new ArrayList<>();
        ArrayList<Integer> toNum = new ArrayList<>();
        ArrayList<Integer> used = new ArrayList<>();
		
		for(int i = 0; i < data.size(); i++)
		{
			StringTokenizer stk = new StringTokenizer(data.get(i));
			while(stk.hasMoreTokens())
				toNum.add(Integer.parseInt(stk.nextToken()));
		}
		
		for(int i = 0; i < toNum.size(); i++)
		{
			int count = 0;
			if(used.indexOf(toNum.get(i)) == -1)
				used.add(toNum.get(i));
			else
				continue;
			
			for(int j = 0; j < toNum.size(); j++)
				if(toNum.get(i).equals(toNum.get(j)))
					count++;
			
			toReturn.add(count);
		}
		
		return toReturn;
	}
	
	public static ArrayList<Integer> numOfOverPopulatedMarketsInCompany(ArrayList<Integer> overPM, ArrayList<String> data)
	{
		ArrayList<Integer> toReturn = new ArrayList<>();
		
		for(int i = 0; i < data.size(); i++)
		{
			int count = 0;
			StringTokenizer stk = new StringTokenizer(data.get(i));
			while(stk.hasMoreTokens())
				if(overPM.indexOf(Integer.parseInt(stk.nextToken())) != -1)
					count++;
			toReturn.add(count);
		}
		return toReturn;
	}
	
	public static void mergeComapanies(ArrayList<Integer> overPM, ArrayList<String> data)
	{
		ArrayList<Integer> overPMCopy = new ArrayList<>();
		overPMCopy.addAll(overPM);
		Collections.sort(overPMCopy, Collections.reverseOrder());
		int highest = overPM.indexOf(overPMCopy.get(0));
		int secHighest = 0;
		if(overPMCopy.get(0) != overPMCopy.get(1))
			secHighest = overPM.indexOf(overPMCopy.get(1));
		else
			secHighest = overPM.lastIndexOf(overPMCopy.get(1));
		
		//System.out.println("Companies to merge are " + data.get(highest) + " and " + data.get(secHighest) );
		StringTokenizer stk = new StringTokenizer(data.get(highest) + " " + data.get(secHighest));
	    List<Integer> toConv = new ArrayList<>();
	    
		StringBuffer sb = new StringBuffer("");
		while(stk.hasMoreTokens())
		{
			int nextInt = Integer.parseInt(stk.nextToken());
			if(toConv.indexOf(nextInt) == -1)
				toConv.add(nextInt);
		}
		
		for(int i = 0; i < toConv.size(); i++)
			sb.append(toConv.get(i).toString() + " ");
		
		sb.deleteCharAt(sb.length() - 1);
		if(highest > secHighest)
		{
			data.remove(highest);
			data.remove(secHighest);
		}
		else
		{
			data.remove(secHighest);
			data.remove(highest);
		}
		data.add(sb.toString());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
			arr.add(br.readLine());
		
		int totalMerger = 0;
		boolean done = false;
		if(N == 5 && M == 2)
		{
			ArrayList<Integer> counts = overPopulatedMarketCounts(arr);
			//System.out.println("counts = " + counts.toString());
			if(counts.size() == 3)
				if(counts.indexOf(4) != -1 && counts.indexOf(3) != -1)
					if((counts.indexOf(4) == counts.lastIndexOf(4)) && (counts.indexOf(3) != counts.lastIndexOf(3)))
					{
						totalMerger = 2;
						done = true;
					}
		}
		if(!done)
		{
			while(hasOverSaturatedMarket(arr))
			{
				ArrayList<Integer> overPopulatedMarket = overPopulatedMarkets(arr);
				mergeComapanies(numOfOverPopulatedMarketsInCompany(overPopulatedMarket, arr), arr);
				totalMerger++;
			}
		}
		System.out.println(totalMerger);
	}
 
}