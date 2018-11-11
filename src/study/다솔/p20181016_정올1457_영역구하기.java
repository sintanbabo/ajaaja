package study.다솔;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class p20181016_정올1457_영역구하기 {
	
	static int N,M,K;
	static int map[][];
	static boolean visited[][];
	static int mx[] = {0,0,1,-1};
	static int my[] = {1,-1,0,0};
	static int count;
	static List<Integer> A = new LinkedList<Integer>();
	
	public static class Node{
		int x ;
		int y ;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
			
			
		}
		
	}
	
	
	
	public static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		
		visited[x][y] = true;
		Node n = new Node(x,y);
		
		for(int i=0; i<4; i++) {
			int nx = n.x+ mx[i];
			int ny = n.y+ my[i];
			
			if( nx >=0 && nx<N && ny>=0 && ny<M) {
				if(map[nx][ny] == 0 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					count++;
					dfs(nx,ny);
				}
			}
		
		}
		
			
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		count =1;
		for(int k=0; k<K; k++) {
			int y1= sc.nextInt(); int x1 = sc.nextInt();
			int y2 = sc.nextInt(); int x2 =sc.nextInt();
				
			for(int m=x1; m<x2; m++) {
				for(int x=y1; x<y2; x++) {
						map[m][x] = 3;
				}
			}
		
		}
		

		

		for(int i =0; i<N; i++) {
			for(int j =0; j<M; j++) {

				if (map[i][j] == 0 && visited[i][j] == false) {
					dfs(i,j);
					A.add(count);
					count =1;
				}
			}
		}
		
		Collections.sort(A);
		
		System.out.println(A.size());
		for(int i=0; i<A.size(); i++) {
			
			System.out.print(A.get(i)+" ");
		}
	
		
		
	}

	
}
