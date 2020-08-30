package DP;

import java.util.*;

public class findingAllLCS {
	
	public static List<String> allLCS(String A, String B, int l1, int l2,int[][] dp)
	{
		if (l1 == 0 || l2 == 0)
			return new ArrayList<String>(Collections.nCopies(1, ""));
		
		if (A.charAt(l1 - 1) == B.charAt(l2 - 1))
		{
			List<String> lcs = allLCS(A, B, l1 - 1, l2 - 1, dp);
			for (int i = 0; i < lcs.size(); i++)
				lcs.set(i, lcs.get(i) + (A.charAt(l1 - 1)));
			
			return lcs;
		}
		
		if (dp[l1 - 1][l2] > dp[l1][l2 - 1])
			return allLCS(A, B, l1 - 1, l2, dp);
		
		if (dp[l1 - 1][l2] < dp[l1][l2 - 1])
			return allLCS(A, B, l1, l2 - 1, dp);
		
		List<String> top = allLCS(A, B, l1 - 1, l2, dp);
		List<String> left = allLCS(A, B, l1, l2 - 1, dp);
		
		top.addAll(left);
		
		return top;	
		
	}
	
	static int LCSlength(String A, String B, int l1, int l2, int[][] dp)
	{
		for (int i = 1; i <= l1; i++)
		{
			for (int j = 1; j <= l2; j++)
			{
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else 
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[l1][l2];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		
		String str1 = obj.next();
		String str2 = obj.next();
		int l1 = str1.length(), l2 = str2.length();
		int dp[][] = new int[l1 + 1][l2 + 1];
		
		System.out.println("Length of Longest Common Subsequence is : " + LCSlength(str1, str2, l1, l2, dp));
		
		List <String> lcs = allLCS(str1, str2, l1, l2, dp);
		Set<String> getAllLCS = new HashSet<String>(lcs);
		System.out.println(getAllLCS);

	}

}
