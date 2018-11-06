package study.재연;

import java.util.*;
import java.io.*;

public class p20181013_정올1695_이재연
{
	static int n;
	static int map[][];
	static boolean[][] visit;
	
	static int dx[] = {-1,0,1,0}; // �� �� �� ��
	static int dy[] = {0,-1,0,1};
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181029//jo_1695.txt"));
		n = sc.nextInt();
		
		map = new int [n][n];
		visit = new boolean[n][n];
		
		for(int i=0; i<n; i++){
			String str = sc.next();
			for(int j=0; j<n; j++){
				map[i][j] = str.charAt(j)-48;
				visit[i][j] = false;
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("--- start ---");
		int cnt = 0;  // ���� ��
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j]==1 && visit[i][j] ==false){
					cnt++;
					bfs(i,j);
				}
			}
		}

		System.out.println();
		
		System.out.println(+cnt);// ���� ��
		// �� ����
		Collections.sort(list);
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public static void bfs(int x, int y){
		System.out.println("("+x+","+y+")");
		visit[x][y] = true;
		
		Queue<bfs_j1695> que = new LinkedList<bfs_j1695>();
		que.add(new bfs_j1695(x, y));
		
		int house = 1; // �� ���� ���ʿ� 1�� ��� ���ϱ� �ʱⰪ 1
		
		while(!que.isEmpty()){
			bfs_j1695 b = que.poll();
			
			for(int i=0; i<4; i++){
				int x1 = dx[i]+b.x;
				int y1 = dy[i]+b.y;
				
				if(x1>=0 && x1<n && y1>=0 && y1<n && visit[x1][y1]==false && map[x1][y1]==1){
					System.out.println("x1>"+x1+" / y1>"+y1);
					visit[x1][y1] = true;
					que.add(new bfs_j1695(x1, y1));
					house++;
				}
			}
		}
		list.add(house);
//		System.out.println("house>"+house);
		
		
	}

	

}

class bfs_j1695{
	int x;
	int y;
	bfs_j1695(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

