package DP;

class matrixChainMultiplication
{
    public static int matrixChainMultiplication(int[] dims)
    {
        int n = dims.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++)
        {
            for (int i = 1; i <= n - len + 1; i++)
            {
                int j = len + i - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; j < n && k <= j - 1; k++)
                {
                    int cost = dp[i][k] + dp[k + 1][j] + (dims[i -1] * dims[j] * dims[k]);
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
        return dp[1][n - 1];
    }
 
    public static void main(String[] args)
    {
        int[] dims = { 10, 30, 5, 60 };
        //int[] dims = {2, 3, 6, 4, 5};
        System.out.print("The minimum cost is " + matrixChainMultiplication(dims));
    }
}