package study.두태;

import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;

public class std_DFS_BFS_전두태
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		int s = sc.nextInt();
		
		int matrix[][] = new int [v + 1][v + 1];
		for (int i = 1; i <= e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		
		int check[] = new int[matrix[0].length];
		System.out.print("DFS : ");
		DFS(matrix, check, s);
		
		System.out.println("");
		
		check = new int[matrix[0].length];
		System.out.print("BFS : ");
		BFS(matrix, check, s);
	}
	
	public static void DFS(int m[][], int check[], int p) {
		System.out.print(p + " ");
		check[p] = 1;
		
		for (int i = 1; i < m[0].length; i++) {
			if (m[p][i] == 1 && check[i] == 0) {
				//System.out.println(p + "���� " + i + "�� �̵�");
				DFS(m, check, i);
			}
		}
	}
	
	public static void BFS(int m[][], int check[], int p) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		check[p] = 1;
		q.add(p);
		
		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			
			for (int i = 1; i < m[0].length; i++) {
				if (m[node][i] == 1 && check[i] == 0) {
					//System.out.println(node + "���� " + i + "�� �̵�");
					check[i] = 1;
					q.add(i);
				}
			}
		}
	}
}
