package study.두태;

import java.util.Scanner;

public class p20181015_백준1987_전두태
{
	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[] visit = new boolean[26];
	static int[][] matrix;
	static int maxStep = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		matrix = new int[R + 1][C + 1];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				matrix[i][j] = str.charAt(j) - 'A';
			}
		}
		
		visit[matrix[0][0]] = true;
		
		dfs(0, 0, 1);
		
		System.out.print(maxStep);
	}
	
	public static void dfs(int row, int col, int step) {
		maxStep = maxStep < step ? step : maxStep;
		
		for (int i = 0; i < 4; i++) {
			int nextX = row + dx[i];
			int nextY = col + dy[i];
			
			if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
			if (visit[matrix[nextX][nextY]]) continue;
			
			visit[matrix[nextX][nextY]] = true;
			
			dfs(nextX, nextY, step + 1);
			
			visit[matrix[nextX][nextY]] = false;
		}
	}
}
