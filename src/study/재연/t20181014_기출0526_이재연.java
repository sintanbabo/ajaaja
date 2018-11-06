package study.재연;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class t20181014_기출0526_이재연
{
	static int n;
	static int map[][];
	static boolean visit[][];
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	static int fromX;
	static int fromY;
	static int toX;
	static int toY;
	static boolean ans;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("D:\\gc_input0526.txt"));
		n = sc.nextInt();
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				map[i][j] = sc.nextInt();
				visit[i][j] = false;
			}
		}
		
		fromX = sc.nextInt();
		fromY = sc.nextInt();
		toX = sc.nextInt();
		toY = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("---- start ----");
		
		
		if(fromX == toX && fromX==toY) {
			System.out.println("1");
		}else {
			visit[fromX][fromY] = true;
			bfs(fromX, fromY, toX, toY);
		}
		
		if(flag) {
			System.out.println("1");
		}else {
			System.out.println("-1");
		}
		
	}	
	
	public static void bfs(int x, int y, int tx, int ty) {
		Queue<BFS> que = new LinkedList<BFS>();
		que.add(new BFS(x,y));
		
		while(!que.isEmpty()) {
			BFS b = que.poll();
			
			for(int i=0; i<4; i++) {
				int x1 = dx[i]+b.x;
				int y1 = dy[i]+b.y;
				
				if(x1 == tx && y1 == ty) {
					System.out.println("��������  ��ǥ>"+x1+" / �̵� �� y�� ��ǥ>"+y1+ " / "+x1+","+y1);
					flag = true;
					break;
				}
				
				if(x1<1 || x1>=n+1 || y1<1 || y1>=n+1){
					continue;
				}
				
				if(map[x1][y1]==0 || visit[x1][y1] == true) {
					continue;
				}
				System.out.println("�̵� �� x�� ��ǥ>"+x1+" / �̵� �� y�� ��ǥ>"+y1+ " / "+x1+","+y1);
//				System.out.println();				
				que.add(new BFS(x1,y1));
				visit[x1][y1] = true;
			}
			
			if(flag) {
				break;
			}
		}
	}
/*
 * 
1101
1101
0111
0010
---- start ----
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>1 / 2,1
�̵� �� x�� ��ǥ>1 / �̵� �� y�� ��ǥ>2 / 1,2
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>2 / 2,2
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>2 / 3,2
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>3 / 3,3
�̵� �� x�� ��ǥ>4 / �̵� �� y�� ��ǥ>3 / 4,3
�̵� �� x�� ��ǥ>3 / �̵� �� y�� ��ǥ>4 / 3,4
�̵� �� x�� ��ǥ>2 / �̵� �� y�� ��ǥ>4 / 2,4
��������  ��ǥ>1 / �̵� �� y�� ��ǥ>4 / 1,4
1
	
 */
	
}
class BFS{
	int x;
	int y;
	BFS(int x, int y){
		this.x = x;
		this.y = y;
	}
}
