package study.두태;

import java.util.Scanner;

public class std_도시계획_전두태
{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		int N = 0;
		int idx = 0;
		String matrix[][] = {};
		int result[] = new int[test_case];
		
		for (int T = 0; T < test_case; T++) {
			N = sc.nextInt();
			matrix = new String[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.next();
				}
			}
			
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (matrix[i][j].equals("B")) {
						if (matrix[i - 1][j].equals("G") || matrix[i + 1][j].equals("G") || matrix[i][j - 1].equals("G") || matrix[i][j + 1].equals("G")) {
							result[idx] += 1;
						} else {
							for (int a = 1; a < N - 1; a++) {
								if (matrix[i][a].equals("B")) result[idx] += 1;
								if (matrix[a][j].equals("B")) result[idx] += 1;
							}
							
							result[idx] -= 1;
						}
					}
				}
			}
			
			idx++;
		}
		
		for (int T = 0; T < test_case; T++) {
			System.out.println(result[T]);
		}
	}
}