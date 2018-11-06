package study.두태;

import java.util.ArrayList;
import java.util.Scanner;

public class p20181015_백준2468_전두태
{
	static int N, Answer;
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] > 4) matrix[i][j] = 1;
				else matrix[i][j] = 0;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					Answer = 0;
					int result = check(i, j);
					list.add(result);
				}
			}
		}
		
		System.out.println(list.size());
	}
	
	public static int check(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= N) return 0;
		
		if (matrix[i][j] != 1) return 0;
		
		matrix[i][j] = 9;
		
		Answer++;
		
		check(i - 1, j);
		check(i + 1, j);
		check(i, j - 1);
		check(i, j + 1);
		
		return Answer;
	}
}
