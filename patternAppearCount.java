package DP;

import java.util.*;

public class patternAppearCount {
	
	static int patCount(String A, String B, int x, int y)
	{
		int dp[][] = new int[x + 1][y + 1];
		for (int i = 0; i <= x; i++)
			dp[i][0] = 1;
		
		for (int i = 1; i <= x; i++)
		{
			for (int j = 1; j <= y; j++)
			{
				dp[i][j] = ((A.charAt(i - 1) == B.charAt(j - 1)) ? dp[i - 1][j - 1] : 0) + dp[i - 1][j];	
			}
		}
		
		return dp[x][y];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String str = obj.next();
		String pattern = obj.next();
		
		System.out.println("The count of '" + pattern + "' appearing in String '" + str +"' is : " 
											+ patCount(str, pattern, str.length(), pattern.length()));

	}

}
