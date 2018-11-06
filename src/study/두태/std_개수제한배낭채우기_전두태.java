package study.두태;

import java.util.Scanner;

public class std_개수제한배낭채우기_전두태
{
	static int N, W;
	static int[] Wi, Pi, Ci;
	static int[][] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		Wi = new int[N + 1];
		Pi = new int[N + 1];
		Ci = new int[N + 1];
		DP = new int[N + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			Wi[i] = sc.nextInt();
			Pi[i] = sc.nextInt();
			Ci[i] = sc.nextInt();
		}
		
		// �ʱⰪ ������ �ٽ� �ؾ��� ������ ����...
		for (int i = 1; i <= W; i++) {
			DP[1][i] = i / Wi[1] * Pi[1] * Ci[1];
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (j >= Wi[i]) {
					DP[i][j] = max(DP[i][j - Wi[i]] + Pi[i], DP[i - 1][j]);
				} else {
					DP[i][j] = DP[i - 1][j];
				}
			}
		}
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				System.out.print(DP[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public static int max(int A, int B) {
		return A > B ? A : B;
	}
}

/*

				1	2	3	4	5	6	7	8	9	10	11	12	13	14
				0	0	0	0	0	0	0	0	0	0	0	0	0	0
2(40)[3] 	0	0	40	40	80	80	120	120	120	120	120	120	120	120	120
5(110)[1]	0	0	40	40	80	110	120	150	150	190	190	230	230	230	230
10(200)[3]	0	0	40	40	80	110	120	150	160	190	200	230	240	270	280
3(50)[2]	0	0	40	50	50	110	120	150	160	190	200	230	240	270	280

*/