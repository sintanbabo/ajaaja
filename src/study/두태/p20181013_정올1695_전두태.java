package study.두태;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p20181013_정올1695_전두태
{
	static int N;
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = str.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					int result = check(i, j);
					list.add(result);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static int check(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= N) {
			return 0;
		}
		
		if (matrix[i][j] != 1) {
			return 0;
		}
		
		matrix[i][j] = 9;
		
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				System.out.print(matrix[a][b] + " ");
			}
			System.out.println("");
		}
		System.out.println("=================");
		
		int result = 0;
		result += check(i - 1, j);
		result += check(i + 1, j);
		result += check(i, j - 1);
		result += check(i, j + 1);
		
		return result + 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	static int N;
	static int[][] matrix, visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		matrix = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = str.charAt(j) - '0';
				visit[i][j] = 0;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 1) {
					int result = check(i, j);
					list.add(result);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static int check(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= N) {
			return 0;
		}
		
		if (matrix[i][j] != 1) {
			return 0;
		}
		
		matrix[i][j] = 9;
		
		int result = 0;
		result += check(i - 1, j);
		result += check(i + 1, j);
		result += check(i, j - 1);
		result += check(i, j + 1);
		
		return result + 1;
	}
	*/
}
