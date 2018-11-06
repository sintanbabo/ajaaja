package study.다솔;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181015_백준2468_문다솔 {

	
	static int N,A;
	static int map[][];
	static int visited[][];
	static int cnt =1;
			
	static class Node{
		static int x;
		static int y;
		Node(){}
		Node(int _x, int _y){
			this.x = x;
			this.y = y;
			
		}
		
	}
	
	
	public static void bfs(int a, int b) {
		// TODO Auto-generated method stub
		
		Queue<Node> q  = new LinkedList<>();
		
		q.add(new Node(a,b));
		
		while(!q.isEmpty()) {
			
			Node n = q.remove();
			
			int x = n.x;
			int y = n.y;
			
			if(x+1 <= N && map[x+1][y] > map[x][y]) {
				if(visited[x+1][y] != 1) {
					q.add(new Node(x+1,y));
					visited[x+1][y] = cnt;
					
				}
				
			}
			if(x-1 > 0 && map[x-1][y] > map[x][y]) {
				if(visited[x-1][y] != 1) {
					q.add(new Node(x-1,y));
					visited[x-1][y] = cnt;
					
				}
				
			}
			if(y-1 > 0 && map[x][y-1] > map[x][y]) {
				if(visited[x][y-1] != 1) {
					q.add(new Node(x,y-1));
					visited[x][y-1] = cnt;
					
				}
				
			}
			if(y+1 <=N  && map[x][y+1] > map[x][y]) {
				if(visited[x][y+1] != 1) {
					q.add(new Node(x,y+1));
					visited[x][y+1] = cnt;
					
				}
				
			}
			
			
			
		}
		
		
		
		
		
	}
		



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		visited = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				
				map[i][j] = sc.nextInt();
				
			}
		}
		
	
	
		for(int i=1; i<N+1; i++) {
			for(int j =1; j<N+1; j++) {
				
					bfs(i,j);
				
			}
		}
		
		
		
		}

	
}
