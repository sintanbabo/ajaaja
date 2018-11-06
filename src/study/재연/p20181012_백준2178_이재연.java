package study.재연;

import java.util.*;
import java.io.*;

public class p20181012_백준2178_이재연
{

	static int n;			// ��ǥ
	static int m;			// ��ǥ
	static int map[][];		// map
	static boolean visit[][];	// �湮
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	static int cnt = 0;
	static int max = 0;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181017//bj_input2178.txt"));
		// TODO Auto-generated method stub
		/*
		�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ��
		������(1,1) -> (N,M) �̵��� �ִܰ�� ���϶�.
		*/
		
		n = sc.nextInt();
		m = sc.nextInt();		
		map = new int[n][m];
		visit = new boolean[n][m];

		sc.nextLine();
		for(int i=0; i<n; i++){
			String str = sc.nextLine();			
			for(int j=0; j<m; j++){
				map[i][j] = str.charAt(j)-'0';
				visit[i][j] = false;
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("------ start -------");
		
		visit[0][0] = true;
		
		dfs(0,0);
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("dfs > "+map[n-1][m-1]);
		
		bfs(0,0);
		// �ʱ� ���� �� �ڽź��� 1ĭ ���� ���� - input ����
		System.out.println("bfs > "+map[n-1][m-1]+" / cnt>"+(cnt-1));


	}
	
	public static void dfs(int x, int y){
		
		for(int i=0; i<4; i++){
			int x1 = dx[i]+x;
			int y1 = dy[i]+y;
			
			// ���� ��Ż
			if(x1<0 || x1>=n || y1<0 || y1>=m){
				continue;
			}
			
			// ���� �ƴϰų� �湮
			if(map[x1][y1]==0 || visit[x1][y1]==true){
				continue;
			}
			
			if(visit[x1][y1]==false){
				visit[x1][y1] = true;
//				System.out.println("�̵� �� x�� ��ǥ>"+x1+" / �̵� �� y�� ��ǥ>"+y1+ " / "+x1+","+y1);
				
				map[x1][y1] = map[x][y]+1;
				dfs(x1,y1);
				visit[x1][y1] = false;
			}
		}
		
/*
1 0 9 10 11 12
2 0 8 0  12 0
3 0 7 0  13 14
4 5 6 0  16 15	
 */
	}
	
	
	public static void bfs(int x, int y){
		Queue<BFS> que = new LinkedList<BFS>();
		que.add(new BFS(x,y));
		
		while(!que.isEmpty()){
			BFS b = que.poll();
			
			for(int i=0; i<4; i++){
				int x1 = dx[i]+b.x;
				int y1 = dy[i]+b.y;
				
				// ���� ��Ż
				if(x1<0 || x1>=n || y1<0 || y1>=m){
					continue;
				}
				
				// ���� �ƴϰų� �湮
				if(map[x1][y1]==0 || visit[x1][y1]==true){
					continue;
				}
//				System.out.println("�̵� �� b.x   >"+b.x+"/ �̵� �� b.y   >"+b.y+ "  / "+b.x+","+b.y);
//				System.out.println("�̵� �� x�� ��ǥ>"+x1+" / �̵� �� y�� ��ǥ>"+y1+ " / "+x1+","+y1);
//				System.out.println();
				
				que.add(new BFS(x1, y1));
				// ��ĭ ����
				map[x1][y1] = map[b.x][b.y]+1;
				cnt++;
				
				visit[x1][y1] = true;
				
				
			}
		}
/*
�̵� �� b.x   >0/ �̵� �� b.y   >0  / 0,0
�̵� �� x�� ��ǥ>1 / �̵� �� y�� ��ǥ>0 / 1,0

�̵� �� b.x   >1/ �̵� �� b.y   >0  / 1,0
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>0 / 2,0

�̵� �� b.x   >2/ �̵� �� b.y   >0  / 2,0
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>0 / 3,0

�̵� �� b.x   >3/ �̵� �� b.y   >0  / 3,0
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>1 / 3,1

�̵� �� b.x   >3/ �̵� �� b.y   >1  / 3,1
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>2 / 3,2

�̵� �� b.x   >3/ �̵� �� b.y   >2  / 3,2
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>2 / 2,2

�̵� �� b.x   >2/ �̵� �� b.y   >2  / 2,2
�̵� �� x�� ��ǥ>1 / �̵� �� y�� ��ǥ>2 / 1,2

�̵� �� b.x   >1/ �̵� �� b.y   >2  / 1,2
�̵� �� x�� ��ǥ>0 / �̵� �� y�� ��ǥ>2 / 0,2

�̵� �� b.x   >0/ �̵� �� b.y   >2  / 0,2
�̵� �� x�� ��ǥ>0 / �̵� �� y�� ��ǥ>3 / 0,3

�̵� �� b.x   >0/ �̵� �� b.y   >3  / 0,3
�̵� �� x�� ��ǥ>0 / �̵� �� y�� ��ǥ>4 / 0,4

�̵� �� b.x   >0/ �̵� �� b.y   >4  / 0,4
�̵� �� x�� ��ǥ>1 / �̵� �� y�� ��ǥ>4 / 1,4

�̵� �� b.x   >0/ �̵� �� b.y   >4  / 0,4
�̵� �� x�� ��ǥ>0 / �̵� �� y�� ��ǥ>5 / 0,5

�̵� �� b.x   >1/ �̵� �� b.y   >4  / 1,4
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>4 / 2,4

�̵� �� b.x   >2/ �̵� �� b.y   >4  / 2,4
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>4 / 3,4

�̵� �� b.x   >2/ �̵� �� b.y   >4  / 2,4
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>5 / 2,5

�̵� �� b.x   >3/ �̵� �� b.y   >4  / 3,4
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>5 / 3,5
 */
		
	}	
}