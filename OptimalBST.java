package DP;
import java.util.*;
public class OptimalBST {
	
	private static int getSum(int freq[], int i, int j)
	{
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
	
	static int calcCost(int[] a, int n)
	{
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			dp[i][i] = a[i];
		
		for (int num = 2; num <= n; num++)
		{
			for (int i = 0; i <= n - num; i++)
			{
				int j = i + num - 1;
				dp[i][j] = Integer.MAX_VALUE;
				int sum = getSum(a, i, j);
				for (int k = i; k <= j; k++)
				{
					int result = sum + ((k - 1 < i) ? 0 : dp[i][k - 1]) + ((k + 1 > j) ? 0 : dp[k + 1][j]);
					if (result < dp[i][j])
						dp[i][j] = result;
				}
			}
		}
		
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n  = obj.nextInt();
		int freq[] = new int[n];
		for (int i = 0; i < n; i++)
			freq[i] = obj.nextInt();
		System.out.println("Optimal cost to construct Binary Search tree is : " + calcCost(freq, freq.length));
	}

}
