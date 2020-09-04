package DP;

import java.util.*;

public class stringsWOcons1s {
	
	static void printstr(int n, String str, int last_digit)
	{
		if (n == 0)
		{
			System.out.println(str);
			return ;
		}
		
		printstr(n - 1, str+'0', 0);
		
		if (last_digit == 0)
			printstr(n - 1, str+'1', 1);
		
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		int a[] = new int[n + 1];
		a[0] = 1;
		a[1] = 2;
		for (int i = 2; i <= n; i++)
			a[i] = a[i - 1] + a[i - 2];
		System.out.println("Number of " + n + "-digit strings without consecutive 1's is : " + a[n]);
		System.out.println("The given strings are : ");
		String str = "";
		printstr(n, str, 0);
	}

}
