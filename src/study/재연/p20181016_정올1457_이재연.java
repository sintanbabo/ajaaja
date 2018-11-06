package study.재연;

import java.util.*;
import java.io.*;

public class p20181016_정올1457_이재연 {
	static int m;
	static int n;
	static int k;
	static int map[][];
	static boolean[][] visit;
	
	static int dx[] = {-1,0,1,0}; // �� �� �� ��
	static int dy[] = {0,-1,0,1};
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181029//jo_1457.txt"));
		
		m = sc.nextInt();	// ��
		n = sc.nextInt();	// ��
		k = sc.nextInt();	// �簢���� ����
		
		map = new int[100][100];
		
		visit = new boolean[100][100];
		
		for(int i=0; i<k; i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int p=y2-1; p>=y1; p--)
			{
				for(int q=x2-1; q>=x1; q--)
				{
					map[p][q] = 1;
				}
			}
		}
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] == 1){
					visit[i][j] = true;
				}else{
					map[i][j] = 9;
				}
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
/*
9999119
9199119
1111999
1111999
9199999
*/

		int cnt = 0;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(visit[i][j]==false){
					cnt++;
					bfs(i,j);
				//	dfs(i,j);
					
				}
			}
		}
		System.out.println();
		System.out.println(cnt);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i)+" ");
		}
		
	}
	public static void dfs(int x, int y){
		visit[x][y] = true;
		for(int i=0; i<4; i++){
			int x1 = dx[i]+x;
			int y1 = dy[i]+y;
			
			if(x1>=0 && x1<n && y1>=0 && y1<n && visit[x1][y1]==false && map[x1][y1] == 9){
				visit[x1][y1] = true;
				dfs(x1,y1);
				visit[x1][y1] = false;
			}
		}
	}
	
	public static void bfs(int x,int y){
		System.out.println("������>"+"("+x+","+y+")");
		Queue<bfs_j1457> que = new LinkedList<bfs_j1457>();
		que.add(new bfs_j1457(x, y));
		visit[x][y] = true;
		
		// count = ������ �ڸ�
		int count = 1;	
		while(!que.isEmpty()){
			bfs_j1457 b = que.poll();
			
			for(int i=0; i<4; i++){
				int x1 = dx[i]+b.x;
				int y1 = dy[i]+b.y;
				
				
				if(x1== 4 && y1 == 0){
					System.out.println("jaeyeon");
				}
				
				// �迭 ũ�⸦ ���ʿ� 100���� ����༭ ���� �׳� 0���� �ϸ� ������ �ö󰡱⿡ ������ 4,0�� Ȯ�� ����.
				if(x1>=0 && x1<n && y1>=0 && y1<n && visit[x1][y1]==false && map[x1][y1] == 9){
					que.add(new bfs_j1457(x1, y1));
					visit[x1][y1] = true;
					count++;
				}
			}
			
		}
		list.add(count);
	}
}

class bfs_j1457{
	int x;
	int y;
	bfs_j1457(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

