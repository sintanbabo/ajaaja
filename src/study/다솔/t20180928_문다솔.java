package study.다솔;

import java.util.Scanner;

public class t20180928_문다솔 {
	static int A[] = new int[30];
	static int B[] = new int[30];
	static int N, M;
	static String buffer;
	static String Answer;
	static int AnswerN[] = new int[30];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		buffer = sc.next();
		N = buffer.length();
		for (int i = 0; i < N; i++) {

			A[i] = (int) (buffer.charAt(i) - '0');

		}

		buffer = sc.next();
		M = buffer.length();

		for (int i = 0; i < M; i++) {

			B[i] = (int) (buffer.charAt(i) - '0');

		}

		int S1[] = new int[30];
		int S2[] = new int[30];

		int nj = M - 1;
		int j = M - 1;
		for (int i = 29; i >= 0; i--) {

			nj = j;

			for (j = nj; j >= 0; j--) {

				if (j <= nj) {
					S2[i] = B[j];
					j--;
					break;
				}
			}
		}

		int k = N - 1;
		int nk = N - 1;

		for (int i = 29; i >= 0; i--) {

			nk = k;
			for (k = nk; k >= 0; k--) {

				if (k <= nk) {
					S1[i] = A[k];
					k--;
					break;
				}
			}
		}

		int R[] = new int[30];
		int SUM[] = new int[30];
		int temp = 0;
		String S = "";

		for (int i = 29; i >= 0; i--) {
			SUM[i] = S1[i] + S2[i] + R[i];

			if (SUM[i] >= 10) {
				R[i - 1] = 1;
				temp = SUM[i] - 10;
				SUM[i] = temp;

			} else {
				R[i] = 0;
			}

		}

		// for(int i =0; i<SUM.length; i++) {
		//
		//
//	    S = S+SUM[i];
		//
		// }

		if (N >= M) {

			if (30 - R.length > 30 - SUM.length) {

				for (int i = 30 - N - 1; i < 30; i++) {
					S = S + SUM[i];

				}
			} else {
				for (int i = 30 - N; i < 30; i++)
					S = S + SUM[i];

			}

		}

		else {

			if (30 - R.length > 30 - SUM.length) {

				for (int i = 30 - M - 1; i < 30; i++) {
					S = S + SUM[i];

				}
			} else
				for (int i = 30 - M; i < 30; i++) {
					S = S + SUM[i];
				}
		}

		System.out.print(S);

	}

}
