package study.다솔;

import java.util.Scanner;

public class std_도시계획_문다솔 {
	static int N;
	static int B; // ������ ����

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			char city[][] = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					String temp = sc.next();
					city[i][j] = temp.charAt(0);

				}
			}

			B = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (city[i][j] == 'B') {
						if (city[i + 1][j] == 'G' || city[i][j + 1] == 'G' || city[i - 1][j] == 'G'	|| city[i][j - 1] == 'G') {

							B += 1;

						}

						else {
							int cnt = 1;

							for (int k = 1; i - k > 0; k++) {
								if (city[i - k][j] == 'B') {
									cnt++;
								}

							} // ��
							for (int k = 1; i + k < N; k++) {
								if (city[i + k][j] == 'B') {
									cnt++;
								}

							} // ��

							for (int k = 1; j - k > 0; k++) {
								if (city[i][j - k] == 'B') {
									cnt++;
								}

							} // ��
							for (int k = 1; j + k < N; k++) {
								if (city[i][j + k] == 'B') {
									cnt++;
								}

							} // ��

							B += cnt;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + B);

		}

	}

}
