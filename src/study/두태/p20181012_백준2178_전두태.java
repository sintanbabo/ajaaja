package study.두태;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181012_백준2178_전두태
{
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] matrix, visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		matrix = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = str.charAt(j) - '0';
				visit[i][j] = 0;
			}
		}
		
		visit[0][0] = 1;
		
		bfs(0, 0);
	}
	
	public static void bfs(int x, int y) {
		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(x, y));
		
		while (!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = dot.x + dx[i];
				int nextY = dot.y + dy[i];
				
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue;
				}
				
				if (matrix[nextX][nextY] == 0 || visit[nextX][nextY] == 1) {
					continue;
				}
				
				queue.add(new Dot(nextX, nextY));
				
				matrix[nextX][nextY] = matrix[dot.x][dot.y] + 1;
				
				visit[nextX][nextY] = 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	/*
	static int N, M;
	static int matrix[][], visit[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		matrix = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = str.charAt(j) - '0';
				visit[i][j] = 0;
			}
		}
		
		visit[0][0] = 1;
		bfs(0, 0);
		System.out.println(matrix[N - 1][M - 1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));
		
		while (!q.isEmpty()) {
			Dot d = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				
				if (matrix[nextX][nextY] == 0 || visit[nextX][nextY] == 1) {
					continue;
				}
				
				q.add(new Dot(nextX, nextY));
				
				matrix[nextX][nextY] = matrix[d.x][d.y] + 1;
				
				visit[nextX][nextY] = 1;
			}
		}
	}
	*/
}

class Dot {
	int x;
	int y;
	
	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}