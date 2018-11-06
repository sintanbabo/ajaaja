package study.두태;

import java.util.Scanner;

public class std_분할가능배낭채우기_전두태
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
		
		for (int i = 1; i <= W; i++) {
			DP[1][i] = Pi[1] / Wi[1] * i;
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
		
		System.out.println(DP[N][W]);
		
		/*
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				System.out.print(DP[i][j] + "\t");
			}
			System.out.println("");
		}
		*/
	}
	
	public static int max(int A, int B) {
		return A > B ? A : B;
	}
}

/*

			1	2	3	4	5	6	7	8	9	10	11	12	13	14
			0	0	0	0	0	0	0	0	0	0	0	0	0	0
2(40)	0	20	40	60	80	100	120	140	160	180	200	220	240	260	280
5(110)	0	20	40	60	80	110	130	150	170	190	220	240	260	280	300
10(200)	0	20	40	60	80	110	130	150	170	190	220	240	260	280	300
3(50)	0	20	40	60	80	110	130	150	170	190	220	240	260	280	300

*/