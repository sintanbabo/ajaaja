package study.다솔;

import java.util.Arrays;
import java.util.Scanner;

public class t20181010_문다솔 {

	static int MAP[][] = new int[12][12];
	static int N;
	static int Answer;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i <= N + 1; i++) {
			Arrays.fill(MAP[i], 5);
		}
		
		for(int i=0; i<= N+1; i++) {
			for(int j=0; j<=N+1; j++) 
				System.out.print(MAP[i][j]);
			System.out.println("");
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				MAP[i][j] = sc.nextInt();
			}

		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (MAP[i][j] == 1) {

					if (MAP[i + 1][j] != 0 && MAP[i][j + 1] != 0 && MAP[i - 1][j] != 0 && MAP[i - 1][j + 1] != 0
							&& MAP[i - 1][j - 1] != 0 && MAP[i + 1][j + 1] != 0 && MAP[i + 1][j - 1] != 0
							&& MAP[i][j - 1] != 0) {

						if (MAP[i + 1][j] == 2 || MAP[i][j + 1] == 2 || MAP[i - 1][j] == 2 || MAP[i - 1][j + 1] == 2
								|| MAP[i - 1][j - 1] == 2 || MAP[i + 1][j + 1] == 2 || MAP[i + 1][j - 1] == 2
								|| MAP[i][j - 1] == 2) {

							if (MAP[i + 1][j] == 3 || MAP[i][j + 1] == 3 || MAP[i - 1][j] == 3 || MAP[i - 1][j + 1] == 3
									|| MAP[i - 1][j - 1] == 3 || MAP[i + 1][j + 1] == 3 || MAP[i + 1][j - 1] == 3
									|| MAP[i][j - 1] == 3) {

								Answer++;
							}
						}
					}
				}
				if (MAP[i][j] == 2) {

					if (MAP[i + 1][j] != 0 && MAP[i][j + 1] != 0 && MAP[i - 1][j] != 0 && MAP[i - 1][j + 1] != 0
							&& MAP[i - 1][j - 1] != 0 && MAP[i + 1][j + 1] != 0 && MAP[i + 1][j - 1] != 0
							&& MAP[i][j - 1] != 0) {

						if (MAP[i + 1][j] == 1 || MAP[i][j + 1] == 1 || MAP[i - 1][j] == 1 || MAP[i - 1][j + 1] == 1
								|| MAP[i - 1][j - 1] == 1 || MAP[i + 1][j + 1] == 1 || MAP[i + 1][j - 1] == 1
								|| MAP[i][j - 1] == 1) {

							if (MAP[i + 1][j] == 3 || MAP[i][j + 1] == 3 || MAP[i - 1][j] == 3 || MAP[i - 1][j + 1] == 3
									|| MAP[i - 1][j - 1] == 3 || MAP[i + 1][j + 1] == 3 || MAP[i + 1][j - 1] == 3
									|| MAP[i][j - 1] == 3) {

								Answer++;
							}
						}
					}
				}
				if (MAP[i][j] == 3) {

					if (MAP[i + 1][j] != 0 && MAP[i][j + 1] != 0 && MAP[i - 1][j] != 0 && MAP[i - 1][j + 1] != 0
							&& MAP[i - 1][j - 1] != 0 && MAP[i + 1][j + 1] != 0 && MAP[i + 1][j - 1] != 0
							&& MAP[i][j - 1] != 0) {

						if (MAP[i + 1][j] == 2 || MAP[i][j + 1] == 2 || MAP[i - 1][j] == 2 || MAP[i - 1][j + 1] == 2
								|| MAP[i - 1][j - 1] == 2 || MAP[i + 1][j + 1] == 2 || MAP[i + 1][j - 1] == 2
								|| MAP[i][j - 1] == 2) {

							if (MAP[i + 1][j] == 1 || MAP[i][j + 1] == 1 || MAP[i - 1][j] == 1 || MAP[i - 1][j + 1] == 1
									|| MAP[i - 1][j - 1] == 1 || MAP[i + 1][j + 1] == 1 || MAP[i + 1][j - 1] == 1
									|| MAP[i][j - 1] == 1) {

								Answer++;
							}
						}
					}
				}

			}

		}

		System.out.println(Answer);

	}

}
