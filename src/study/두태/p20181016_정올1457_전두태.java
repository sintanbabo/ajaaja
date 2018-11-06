package study.두태;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p20181016_정올1457_전두태
{
	static int N, M, K, Answer;
	static int[] x1, y1, x2, y2;
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 1;
			}
		}
		
		x1 = new int[K];
		y1 = new int[K];
		x2 = new int[K];
		y2 = new int[K];
		for (int k = 0; k < K; k++) {
			x1[k] = sc.nextInt();
			y1[k] = sc.nextInt();
			x2[k] = sc.nextInt();
			y2[k] = sc.nextInt();
		}
		
		for (int k = 0; k < K; k++) {
			for (int i = y1[k]; i < y2[k]; i++) {
				for (int j = x1[k]; j < x2[k]; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		/*
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		*/
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					Answer = 0;
					int result = check(i, j);
					list.add(result);
				}
			}
		}
		
		System.out.println(list.size());
		
		Collections.sort(list);
		for (int v : list) {
			System.out.print(v + " ");
		}
	}
	
	public static int check(int i, int j) {
		if (i < 0 || i >= M || j < 0 || j >= N) return 0;
		
		if (matrix[i][j] != 1) return 0;
		
		matrix[i][j] = 9;
		
		Answer++;
		
		/*
		for (int a = 0; a < M; a++) {
			for (int b = 0; b < N; b++) {
				System.out.print(matrix[a][b] + " ");
			}
			System.out.println("");
		}
		System.out.println("==================");
		*/
		
		check(i - 1, j);
		check(i + 1, j);
		check(i, j - 1);
		check(i, j + 1);
		
		return Answer;
	}
}
