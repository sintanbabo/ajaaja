package study.다솔;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181012_백준2178_문다솔 {
	
	static int N,M;
	static int map[][];
	static boolean visit[][];
	static int movex[] = {0,0,-1,1};
	static int movey[] = {-1,1,0,0};
	
	
	public static void BFS(int x, int y) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node n = q.remove();
			
			
			for(int i =0; i<4; i++) //�쐞,�븘�옒, �쇊, �삤 �깘�깋
			{
				int nextx = n.x + movex[i];
				int nexty = n.y + movey[i];
				
				
				if(nextx<0 || nexty<0 || nextx>=N || nexty>= M) {
					continue;
					
				}
				
				if(map[nextx][nexty] == 0 && visit[nextx][nexty] == true) {	
					continue;
				}
				q.add(new Node(nextx,nexty));
				map[nextx][nexty] = map[n.x][n.y]+1;
				visit[nextx][nexty] = true;
				
			}
			
			
		}
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			
			String temp = sc.next();
			for(int j=0; j<M; j++) {
				
				map[i][j] = temp.charAt(j)-'0';
			}
			
		}
		
		
		visit[0][0] = true;
		BFS(0,0);
		
		System.out.println(map[N-1][M-1]);
		
	}
	
}

class Node{
	int x; 
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}



