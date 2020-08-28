package DP;
import java.util.*;

public class LongestCommonSubsequence {
	
	static int bottomUpDP(String str1, String str2)
	{
		int l1 = str1.length(), l2 = str2.length();
		int dp[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++)
		{
			for (int j = 0; j <= l2; j++)
			{
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else
				{
					if (str1.charAt(i - 1) == str2.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1] + 1;
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(printLCS(str1, str2, l1, l2, dp));
		return dp[l1][l2];
	}
	
	static String printLCS(String str1, String str2, int l1, int l2, int[][] dp)
	{
		if (l1 == 0 || l2 == 0)
			return "";
		if (str1.charAt(l1 - 1) == str2.charAt(l2 - 1))
		{
			return printLCS(str1, str2, l1 - 1, l2 - 1, dp) + str1.charAt(l1 - 1);
		}
		if (dp[l1 - 1][l2] > dp[l1][l2 - 1])
			return printLCS(str1, str2, l1 - 1, l2, dp);
		else
			return printLCS(str1, str2, l1, l2 - 1, dp);
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String str1 = obj.next();
		String str2 = obj.next();
		System.out.println("Length of Longest Common Subsequence is : " + bottomUpDP(str1, str2));
	}

}
