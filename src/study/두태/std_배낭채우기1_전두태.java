package study.두태;

import java.util.Scanner;

public class std_배낭채우기1_전두태
{
	static int N, W;
	static int Wi[], Pi[];
	static int dp[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		Wi = new int[N + 1];
		Pi = new int[N + 1];
		dp = new int[N + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			Wi[i] = sc.nextInt();
			Pi[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (j >= Wi[i]) {
					dp[i][j] = max(dp[i][j - Wi[i]] + Pi[i], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		
		
		
		
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public static int max(int A, int B) {
		return A > B ? A : B;
	}
}

/*
				Pi �뷮 W
				1	2	3	4	5	6	7	8	9	10	11	12	13	14
Wi			0	0	0	0	0	0	0	0	0	0	0	0	0	0	0
����	2(40)	0	0	40	40	80	80	120	120	160	160	200	200	240	240	280
����	5(110)	0	0	40	40	80	110	120	150	160	190	220	230	260	270	300
��	10(200)	0	0	40	40	80	110	120	150	160	190	220	230	260	270	300
N	3(50)	0	0	40	50	80	110	120	150	160	190	220	230	260	270	300
*/