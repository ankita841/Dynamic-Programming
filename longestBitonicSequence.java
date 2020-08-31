package DP;

import java.util.*;

public class longestBitonicSequence {
	
	static void printingLBS(int[] arr, int n, int ind)
	{
		List<List<Integer>> Inc = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			Inc.add(new ArrayList<>());
		}

		Inc.get(0).add(arr[0]);

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (Inc.get(i).size() < Inc.get(j).size() && arr[i] > arr[j]) {
					Inc.set(i, new ArrayList<>(Inc.get(j)));
				}
			}
			Inc.get(i).add(arr[i]);
		}

		List<List<Integer>> Dec = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			Dec.add(new ArrayList<>());
		}
		Dec.get(n).add(0, arr[n]);

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n; j > i; j--) {
				if (Dec.get(i).size() < Dec.get(j).size() && arr[i] > arr[j])
					Dec.set(i, new ArrayList<>(Dec.get(j)));
			}
			Dec.get(i).add(0, arr[i]);
		}
		Dec.get(ind).remove(0);
		Inc.get(ind).addAll(Dec.get(ind));
		System.out.print(Inc.get(ind));
	}

	static int LIS(int[] a, int n, int dp[])
	{
		int max = dp[0];
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (a[i] > a[j] && (dp[i] < 1 + dp[j]))
				{
					dp[i] = 1 + dp[j];
					if (dp[i] > max)
						max = dp[i];
				}
		
		
		return max;
	}
	
	static int revLIS(int[] a, int n, int dp[])
	{
		int max = dp[n - 1];
		for (int i = n - 1; i >= 0; i--)
			for (int j = n; j > i; j--)
				if (a[i] > a[j] && (dp[i] < 1 + dp[j]))
				{
					dp[i] = 1 + dp[j];
					if (dp[i] > max)
						max = dp[i];
				}
		
		return max;
	}
	
	static int LBS(int dp[], int dp1[], int n)
	{
		int max = 0;
		int ind = 0;
		for (int i = 0; i < n; i++)
			if (dp[i] + dp1[i] - 1 > max)
			{
				max = dp[i] + dp1[i] - 1;
				ind = i;
			}
		return ind;
	}

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int a[] = new int[n]; 
		int dp[] = new int[n];
		int dp1[] = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			a[i] = obj.nextInt();
			dp[i] = 1;
			dp1[i] = 1;
		}
		
		System.out.println("Length of Longest Increasing Subsequence is : " + LIS(a, n, dp));
		System.out.println("Length of Longest Decreasing Subsequence is : " + revLIS(a, n - 1, dp1));
		int ind  = LBS(dp, dp1, n);
		System.out.println("Length of Longest Bitonic Sequence is : " + (dp[ind] + dp1[ind] - 1));
		System.out.print("Longest Bitonic Sequence is : ");
		printingLBS(a, n - 1, ind);
		
		
	}

}
