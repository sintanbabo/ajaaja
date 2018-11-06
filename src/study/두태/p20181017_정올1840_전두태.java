package study.두태;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181017_정올1840_전두태
{
	static int N, M, Time;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] matrix, visit;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		Time = 0;
		
		int sum = -1;
		while (sum != 0) {
			// Ž���ϸ鼭 ����(0)�� �ٱ��� ����(9)�� ����
			bfs(0, 0);
			
			// �ٱ��� ����(9)�� ���� ġ��(1)�� ���� ġ��(2)�� ����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (matrix[i][j] == 1) {
						if (matrix[i - 1][j] == 9 || matrix[i + 1][j] == 9 || matrix[i][j - 1] == 9 || matrix[i][j + 1] == 9) {
							matrix[i][j] = 2;
						}
					}
				}
			}
			
			// ���� ġ��(2)�� ������ ��� ����(0)�� ����
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (matrix[i][j] == 2 || matrix[i][j] == 9) {
						matrix[i][j] = 0;
					}
				}
			}
			
			Time++;
			
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += matrix[i][j];
				}
			}
			
			list.add(sum);
			
			/*
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("================== " + sum);
			*/
		}
		
		System.out.println(Time);
		System.out.println(list.get(Time - 2));
	}
	
	public static void bfs(int x, int y) {
		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(x, y));
		
		matrix[x][y] = 9;
		
		while (!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = dot.x + dx[i];
				int nextY = dot.y + dy[i];
				
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
				
				if (matrix[nextX][nextY] != 0) continue;
				
				queue.add(new Dot(nextX, nextY));
				
				matrix[nextX][nextY] = 9;
			}
		}
	}
}
