package study.두태;

import java.util.Scanner;

public class p20181012_정올1278_전두태
{
	static int N, W;
	static int[] Wi, Pi;
	static int[][] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		Wi = new int[N + 1];
		Pi = new int[N + 1];
		DP = new int[N + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			Wi[i] = sc.nextInt();
			Pi[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (j >= Wi[i]) {
					DP[i][j] = max(DP[i - 1][j - Wi[i]] + Pi[i], DP[i - 1][j]);
				} else {
					DP[i][j] = DP[i - 1][j];
				}
			}
		}
		
		System.out.println(DP[N][W]);
	}
	
	public static int max(int A, int B) {
		return A > B ? A : B;
	}
}

/*

			1	2	3	4	5	6	7	8	9	10	11	12	13	14
			0	0	0	0	0	0	0	0	0	0	0	0	0	0
2(40)	0	0	40	40	40	40	40	40	40	40	40	40	40	40	40
5(110)	0	0	40	40	40	110	110	150	150	150	150	150	150	150	150
10(200)	0	0	40	40	40	110	110	150	150	150	200	200	240	240	240
3(50)	0	0	40	50	50	110	110	150	160	160	200	200	240	250	250

*/