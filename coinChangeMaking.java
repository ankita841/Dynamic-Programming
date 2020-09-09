package DP;

import java.util.Scanner;

public class coinChangeMaking {
	
	static int coinsRequired(int[] a, int amt)
	{
		int[] dp = new int[amt + 1];
		for (int i = 1; i <= amt; i++)
		{
			dp[i] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;
			for (int j = 0; j < a.length; j++)
			{
				if (i - a[j] >= 0)
					res = dp[i - a[j]];
				
				if (res != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], res + 1);
			}
		}
		return dp[amt];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = obj.nextInt();
		System.out.print("Enter the amount : ");
		int amt = obj.nextInt();
		int ans  = coinsRequired(a, amt);
		if (ans == Integer.MAX_VALUE)
			System.out.println("\nAmount not possible using given denominations.");
		else
			System.out.println("Minimum coins required to get desired change is : " + ans);

	}

}
