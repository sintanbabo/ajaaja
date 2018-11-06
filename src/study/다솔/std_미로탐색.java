package study.다솔;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class std_미로탐색 {
	
	static int N,M;
	static int map[][];
	static int visited[][];
	static int mx[] = {1,-1,0,0};
	static int my[] = {0,0,1,-1};
	static int count;
	
	public static class Node{
		int x; 
		int y;
		
		Node(int x,int y){
			
			this.x = x;
			this.y = y;
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		N =sc.nextInt();
		M =sc.nextInt();
		
		map = new int[N][M];
		visited = new int [N][M];
		
		for(int i =0; i<N; i++) {
			String temp = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j)-'0';

			}	
		}
		
		
		
		BFS(0,0);
		System.out.println(map[N-1][M-1]);
		
	}

	public static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		visited[i][j] = 1;
		
		q.add(new Node(i,j));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
		
			for(int k=0; k<4; k++) {
			
			int x = n.x + mx[k];
			int y = n.y + my[k];
		
			if(x>=0 && y>=0 && x<N && y<M) {
				
				if(map[x][y] == 1 && visited[x][y] ==0) {
					
					visited[x][y] = 1;
					q.add(new Node(x,y));
					map[x][y] = map[n.x][n.y]+1;
					
				}
				
			}
			
			
			
		}
		
		}
		
	}

}
