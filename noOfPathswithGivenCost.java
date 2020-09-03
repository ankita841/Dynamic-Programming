package DP;
import java.util.*;
public class noOfPathswithGivenCost {
	static int pathCount(int[][] mat, int m, int n, int cost, Map<String, Integer> dp)
	{
		if (cost < 0)
			return 0;
		if (m == 0 && n == 0)
			if (mat[0][0] - cost == 0)
				return 1;
			else
				return 0;
		String key = m + "-" + n + "-" + cost;
		if (!dp.containsKey(key))
		{
			if (m == 0)
				dp.put(key, pathCount(mat, 0, n - 1, cost - mat[m][n], dp));
			else if (n == 0)
				dp.put(key, pathCount(mat, m - 1, 0, cost - mat[m][n], dp));
			else
				dp.put(key, pathCount(mat, m, n - 1, cost - mat[m][n], dp) + pathCount(mat, m - 1, n, cost - mat[m][n], dp));
		}
		return dp.get(key);
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int m = obj.nextInt();
		int n = obj.nextInt();
		int [][] mat = new int[m][n];
		for (int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				mat[i][j] = obj.nextInt();
		/*
		 * int[][] mat =
			{
				{ 4, 7, 1, 6 },
				{ 5, 7, 3, 9 },
				{ 3, 2, 1, 2 },
				{ 7, 1, 6, 3 }
			};
		 *	
		 */

			int cost = obj.nextInt();
			Map<String, Integer> dp = new HashMap<>();
			System.out.println("Total number of Paths with given Cost are : " + pathCount(mat, mat.length - 1, mat[0].length - 1, cost, dp));

	}

}
