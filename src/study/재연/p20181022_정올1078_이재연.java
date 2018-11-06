package study.재연;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class p20181022_정올1078_이재연 {

	static int m;
	static int n;
	
	static int map[][]; // ��ǥ
	static int xx;
	static int yy; // �״� �� ���ϴ� ��
	
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	
	static boolean visit [][];
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181022//jo_1078.txt"));
		
		m = sc.nextInt(); //����
		n = sc.nextInt(); // ����
		
		map = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				map[i][j] = sc.nextInt();
				visit[i][j] = false;
			}
		}
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		xx = sc.nextInt();
		yy = sc.nextInt();
		
		
		// ���� ���� ���θ� �Ϲ����� ������ �ٸ��� �־������ϱ� ������ �͵� �ٸ���
		bfs(yy,xx);
		
		System.out.println("---start----");
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		int time = 0;
		int live = 0;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				time = Math.max(time, map[i][j]);
				if(map[i][j] == 1){
					live++;
				}
			}
		}
		System.out.println("time>"+time+" / live>"+live);
		
		
	}
	
	public static void bfs(int x, int y){
System.out.println("x>"+x);
System.out.println("y"+y);
		cnt = 3; // ���� ������ 3���� �� ����;
		map[x][y] = cnt;
		visit[x][y] = true;
		
		Queue<bfs_1163> que = new LinkedList<bfs_1163>();		
		que.add(new bfs_1163(x,y));
		
		while(!que.isEmpty()){
			bfs_1163 bfs = que.poll();
			for(int i=0; i<4; i++){
				int x1 = dx[i]+bfs.x;
				int y1 = dy[i]+bfs.y;
				
				if((x1>0) && (y1>0) && (x1<=n) && (y1<=m) && (visit[x1][y1] == false) && (map[x1][y1]>0)) {
					que.add(new bfs_1163(x1, y1));
					// ��ĭ ����
					map[x1][y1] = map[bfs.x][bfs.y]+1;
					visit[x1][y1] = true;
				}
				
			}
		}
	}
}

class bfs_1163{
	int x;
	int y;
	public bfs_1163(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
