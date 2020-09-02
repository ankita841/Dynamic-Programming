/** Given a N x N matrix where each call has a distinct value int the range of 1 - (N*N). 
 * Find the longest sequence formed by adjacent numbers in the matrix such that for each number,
 *  the number on the adjacent neighbor is +1 its value.
 */

package DP;

import java.util.*;

public class longestSequenceFormedinMatrix {
	
	static boolean valid(int i, int j, int n)
	{
		return (i >= 0 && j >= 0 && i < n && j < n);
	}
	
	static String longestPath(int arr[][], int n, int i, int j, Map<String, String> dp)
	{
		if(!valid(i, j, n))
			return null;
		
		String key = i + "|" + j;
		
		if (!dp.containsKey(key))
		{
			String path = null;
			
			if (i > 0 && arr[i - 1][j] - arr[i][j] == 1)
				path = longestPath(arr, n, i - 1, j, dp);
			if (j > 0 && arr[i][j - 1] - arr[i][j] == 1)
				path = longestPath(arr, n, i, j - 1, dp);
			if (i + 1 < n && arr[i + 1][j] - arr[i][j] == 1)
				path = longestPath(arr, n, i + 1, j, dp);
			if (j + 1 < n && arr[i][j + 1] - arr[i][j] == 1)
				path = longestPath(arr, n, i, j + 1, dp);
			
			if (path != null)
				dp.put(key, arr[i][j] + "-" + path);
			else
				dp.put(key, String.valueOf(arr[i][j]));
			
		}
		
		return dp.get(key);
	}

	public static void main(String[] args) {
		int arr[][] =
			{
				{ 10, 13, 14, 21, 23 },
				{ 11,  9, 22,  2,  3 },
				{ 12,  8,  1,  5,  4 },
				{ 15, 24,  7,  6, 20 },
				{ 16, 17, 18, 19, 25 }
			};

			String result = "";		
			String tempStr;				
			long resSize = Long.MIN_VALUE;	
			Map<String, String> dp = new HashMap<>();
			
			for (int i = 0; i < arr.length; i++)
			{
				for (int j = 0; j < arr.length; j++)
				{
					tempStr = longestPath(arr, arr.length, i, j, dp);
					long len = tempStr.chars().filter(ch -> ch == '-').count();
					if (len > resSize)
					{
						result = tempStr;
						resSize = len + 1;
					}
				}
			}
			System.out.println("Longest sequence formed by adjacent numbers in the matrix is : " + result);
			System.out.println("Length of the required path is : " + resSize);
	}

}
