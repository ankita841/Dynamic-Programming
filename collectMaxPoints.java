package DP;
import java.util.*;
public class collectMaxPoints {
	
	static int countPoints(int a[][], int m, int n)
	{
		int dp[][] = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++)
		{
			if (i % 2 == 1)
			{
				for (int j = 1; j <= n; j++)
					if (a[i - 1][j - 1] != -1)
						dp[i][j] = a[i - 1][j - 1] + Integer.max(dp[i - 1][j], dp[i][j - 1]);
			}
			else
			{
				for (int j = n - 1; j > 0; j--)
					if (a[i - 1][j - 1] != -1)
						dp[i][j] = a[i - 1][j - 1] + Integer.max(dp[i - 1][j], dp[i][j + 1]);
			}
		}
		
		int i = 1, j = 1;
		while (i <= m && j >= 0 && j <= n)
		{
			if (dp[i][j] == dp[i + 1][j] || dp[i][j] + 1 == dp[i + 1][j])
				i++;
			else if (dp[i][j] == dp[i][j + 1] || dp[i][j] + 1 == dp[i][j + 1])
				j++;
			else if (dp[i][j] == dp[i][j - 1] || dp[i][j] + 1 == dp[i][j - 1])
				j--;
			else
				break;
		}
		return dp[i][j];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int m = obj.nextInt();
		int n = obj.nextInt();
		int mat[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				mat[i][j] = obj.nextInt();
		System.out.println("Maximum points collected are : " + countPoints(mat, mat.length, mat[0].length));

	}

}
