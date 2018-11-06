package study.재연;

import java.io.*;
import java.util.*;

public class p20181014_기출0901_이재연 {
	static int n;
    static char[][] map;
    
	static Queue<bfs_h> bh = new LinkedList<bfs_h>();
	static Queue<bfs_t> bt = new LinkedList<bfs_t>();
	
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	static int cnt = 0;

	public static void main(String[] args) throws Exception{
/*
4
HGGW
GGWW
GGGW
GGGT
 */
		
		Scanner sc = new Scanner(new FileInputStream("D:\\gc_input0901.txt"));
		n = sc.nextInt();
		map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			map[i]=(char[]) sc.next().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----start--------");
		
		// ��� , ��ũ ���ÿ� �������� �ϴϱ�
		// for�� ������ ���� �ٷ� Ž��
		bfs();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'H') {
					cnt++;
				}
			}
		}
		System.out.println("cnt>"+cnt);

	}
	public static void bfs() {
		
		// ��� �� ��
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'H') {
					bh.add(new bfs_h(i, j));
				}
			}
		}
		
		// ��ũ �϶�
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'T') {
					bt.add(new bfs_t(i, j));
				}
			}
		}
		
		while(!bh.isEmpty() && !bt.isEmpty()) {
			bfs_h b = bh.poll();
			bfs_t t = bt.poll();
			for(int i=0; i<n; i++) {
				
				// ��� , ��ũ ���ÿ� ���� ��� ������ ����ũ�� �����ϱ� ����ũ���� Ž��
				// ����ũ
				int xt1 = dx[i]+t.x;
				int yt1 = dy[i]+t.y;
				
				if(xt1>=0 && xt1<n && yt1>=0 && yt1<n) {
					if(map[xt1][yt1] == 'G') {
						System.out.println("xt1>"+xt1+"/ yt1>"+yt1);
						map[xt1][yt1] = 'T';
						bt.add(new bfs_t(xt1, yt1));
					}
				}
				
				// ���
				int xh1 = dx[i]+b.x;
				int yh1 = dy[i]+b.y;
				if(xh1>=0 && xh1<n && yh1>=0 && yh1<n) {
					if(map[xh1][yh1] == 'G') {
						System.out.println("xh1>"+xh1+"/ yh1>"+yh1);
						map[xh1][yh1] = 'H';
						bh.add(new bfs_h(xh1, yh1));
					}
				}
				
			}
			System.out.println("------------------");
		}
	}
	
	public static void bh_bfs() {
		
	}
	
	public static void bt_bfs() {
		
	}
}
class bfs_h{
	int x, y;
	public bfs_h(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y= y;
	}
}

class bfs_t{
	int x, y;
	public bfs_t(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}