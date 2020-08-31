package DP;
import java.util.*;

public class incSubsequenceWithMaxSum {
	
	static void printMSIS(int[] arr, int n)
	{
		List<List<Integer>> MSIS = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			MSIS.add(i, new ArrayList<>());
		
		MSIS.get(0).add(arr[0]);

		int[] sum = new int[n];
		sum[0] = arr[0];

		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < i; j++)
			{

				if (sum[i] < sum[j] && arr[i] > arr[j])
				{
					MSIS.set(i, new ArrayList<>(MSIS.get(j)));
					sum[i] = sum[j];
				}
			}

			MSIS.get(i).add(arr[i]);

			sum[i] += arr[i];
		}

		int j = 0;
		for (int i = 1; i < n; i++) 
			if (sum[i] > sum[j]) 
				j = i;

		System.out.println(MSIS.get(j));		
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
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = obj.nextInt();
		int dp[] = new int[n];
		dp[0] = arr[0];
		System.out.println("Maximum sum of Increasing Subsequence is : " + MSIS(arr, n, dp));
		System.out.print("Subsequence with Maximum sum is : ");
		printMSIS(arr, n);
	}

}
