package study.두태;

import java.util.Scanner;

public class std_동전1_전두태
{
	static int N, K;
	static int coin[];
	static int dp[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		coin = new int[N + 1];
		dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			coin[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= coin[i]) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
	}
}


/*
			��ġ k
			1	2	3	4	5	6	7	8	9	10
		0	0	0	0	0	0	0	0	0	0	0
����	1	1	1	1	1	1	1	1	1	1	1	1
����	2	1	1	2	2	3	3	4	4	5	5	6
n 	5	1	1	2	2	3	4	5	6	7	8	10
*/