package DP;

import java.util.Scanner;

public class noOfWaysCoinChangeMaking {
	
	public static int count(int S[], int n) {

		int dp[] = new int[n + 1];
		dp[0] = 1;

		for (int i = 0; i < S.length; i++) {
			for (int j = S[i]; j <= n; j++) {
				dp[j] += dp[j - S[i]];
			}
		}

		return dp[n];
	}


	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = obj.nextInt();
		System.out.print("Enter the amount : ");
		int amt = obj.nextInt();
		System.out.println("Total number of ways to get desired change is "	+ count(a, amt));

	}

}
