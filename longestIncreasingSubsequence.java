package DP;

import java.util.*;

public class longestIncreasingSubsequence {
	
	static void gettingLIS(int a[], int n)
	{
		List<List<Integer>> lis = new ArrayList<>(); 
		for (int i = 0; i < n; i++)
			lis.add(new ArrayList<Integer>());
		lis.get(0).add(a[0]);
		
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (a[i] > a[j] && lis.get(i).size() < lis.get(j).size())
					lis.set(i, new ArrayList<>(lis.get(j)));
			}
			lis.get(i).add(a[i]);
		}
		int j = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (lis.get(j).size() < lis.get(i).size()) 
				j = i;
		}
		System.out.print(lis.get(j));
	}
	
	static int LIS(int[] a, int n, int dp[])
	{
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (a[i] > a[j] && (dp[i] < 1 + dp[j]))
					dp[i] = 1 + dp[j];
		
		Arrays.sort(dp);
		return dp[n - 1];
	}

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int a[] = new int[n]; 
		int dp[] = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			a[i] = obj.nextInt();
			dp[i] = 1;
		}
		
		System.out.println("Length of Longest Increasing Subsequence is : " + LIS(a, n, dp));
		
		System.out.print("Longest Increasing Subsequence is : " );
		gettingLIS(a, n);
		
	}

}
