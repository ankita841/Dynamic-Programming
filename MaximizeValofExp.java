/*
 * Given an array A, maximize value of the expression (A[s] - A[r] + A[q] - A[p]) where
 *  p, q, r, s are the indices of the array and s > r > q > p.
 * */
package DP;

import java.util.*;

public class MaximizeValofExp {
	
	static int maximizeVal(int[] a, int n)
	{
		int first[] = new int[n + 1];
		Arrays.fill(first, Integer.MIN_VALUE);
		
		int second[] = new int[n];
		Arrays.fill(second, Integer.MIN_VALUE);
		
		int third[] = new int [n - 1];
		Arrays.fill(third, Integer.MIN_VALUE);
		
		int fourth[] = new int[n - 2];
		Arrays.fill(fourth, Integer.MIN_VALUE);
		
		for (int i = n - 1; i >= 0; i--)
			first[i] = Integer.max(first[i + 1], a[i]);
		
		for (int i = n - 2; i >=  0; i--)
			second[i] = Integer.max(second[i + 1], first[i + 1] - a[i]);
		
		for (int i = n - 3; i >= 0; i--)
			third[i] = Integer.max(third[i + 1], second[i + 1] + a[i]);
		
		for (int i = n - 4; i >= 0; i--)
			fourth[i] = Integer.max(fourth[i + 1], third[i + 1] - a[i]);
		
		return fourth[0];
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = obj.nextInt();
		
		System.out.println("Maximum Value of the expression A[s] - A[r] + A[q] - A[p] is : " + maximizeVal(A, n));
		
	}

}
