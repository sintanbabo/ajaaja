package study.다솔;

import java.util.Scanner;

public class p20181011_백준2293_문다솔 {

	static int n, k;
	static int coin[];
	static int dp[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		coin = new int[n + 1];
		dp = new int[k + 1];
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j - coin[i] >= 0) {

					dp[j] += dp[j - coin[i]];
				}

			}

		}

		int max = 0;
		for (int i = 1; i <= k; i++) {

			if (max < dp[i]) {

				max = dp[i];
			}
		}

		System.out.println(max);

	}

}
