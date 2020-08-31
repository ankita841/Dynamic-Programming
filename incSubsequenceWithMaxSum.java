package DP;
import java.util.*;

public class incSubsequenceWithMaxSum {
	
	static void printMSIS(int[] a, int n, int dp[])
	{
		List<List<Integer>> msis = new ArrayList<>();
		for (int i = 0; i < n; i++)
			msis.add(new ArrayList<Integer>());
		
		msis.get(0).add(a[0]);
		
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (a[i] > a[j] && dp[j] > dp[i])
					msis.set(i, new ArrayList<>(msis.get(j)));
			}
			msis.get(i).add(a[i]);
		}
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (dp[i] > dp[j]) {
				j = i;
			}
		}

		System.out.println(msis.get(j));
		
	}
	static int MSIS(int[] a, int n, int[] dp)
	{
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < i; j++)
				if (dp[j] > dp[i] && a[i] > a[j])
					dp[i] = dp[j];
			dp[i] += a[i];
		}
		int max = dp[0];
		for (int i = 1; i < n; i++)
			if (max < dp[i])
				max = dp[i];
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		System.out.println("Increasing Subsequence with Maximum Sum is : " + MSIS(arr, arr.length, dp));
		printMSIS(arr, arr.length, dp);
	}

}
