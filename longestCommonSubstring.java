package DP;

import java.util.*;

public class longestCommonSubstring {
	
	static int bottomUpDP(String str1, String str2)
	{
		int max = 0, ind = 0;
		int l1 = str1.length(), l2 = str2.length();
		int[][] dp = new int[l1 + 1][l2 + 1]; 
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
						dp[i][j] = 0;
					if (dp[i][j] > max)
					{
						max = dp[i][j];
						ind = i;
					}
				}
			}
		}
		System.out.println(str1.substring(ind - max, ind));
		return max;
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String str1 = obj.next();
		String str2 = obj.next();
		System.out.println("Length of Longest Common Substring is : " + bottomUpDP(str1, str2));

	}

}
