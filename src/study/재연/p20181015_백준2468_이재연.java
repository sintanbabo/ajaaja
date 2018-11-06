package study.재연;

import java.util.*;
import java.io.*;

public class p20181015_백준2468_이재연
{
	
	static int n;				// ��
	static int map[][];			// map
	static boolean[][] visit;	// �湮���� flag
	static Queue<Integer>qx = new LinkedList<Integer>();
	static Queue<Integer>qy = new LinkedList<Integer>();
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181015//bj_input2468.txt"));
		
		n = sc.nextInt();
		
		map = new int[101][101];
		visit = new boolean[101][101];
		// ���̴� 1�̻� 100 ������ �����̴�. ��� �������� �־���.
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				map[i][j] = sc.nextInt();
				visit[i][j] = false;
				if(max < map[i][j]){
					max = map[i][j];
				}
			}
		}
		
		int anser = 0;
		for(int h=0; h<max; h++){	// ����
			int cnt = 0;	// ��������
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(map[i][j] > h && visit[i][j] == false){
						cnt++;
						bfs(h,i,j); // ���� = h, ���� ��ġ = i/j
					}
				}
			}
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					visit[i][j] = false;
				}
			}
			// ���°� ���� ���� �ϳ��� �����̹Ƿ� 1�� ��!
			if(anser<cnt){
				anser = cnt;
			}
//System.out.println("cnt>>"+cnt);
//System.out.println("anser>>"+anser);

		}
		System.out.println("�ִ� ���� ����>"+anser);
	}
	
	public static void bfs(int h, int i,int j) { // ���� = h, ���� ��ġ = i/j
//System.out.println("h>"+h+" / "+"i>"+i+" / "+"j>"+j);
		visit[i][j] = true;
		qx.add(i);
		qy.add(j);
		
		int x,y;		// ���� ��
		int x1, y1;		// ���� ��
		
		while(!qx.isEmpty() && !qy.isEmpty()){
			x = qx.poll();
			y = qy.poll();
			
			for(int k=0; k<4; k++){
				x1 = dx[k]+x;
				y1 = dy[k]+y;
				
				if(x1 >=0 && x1 < n && y1 >=0 && y1 < n ){
					if( map[x1][y1] > h && visit[x1][y1] == false) {
//System.out.println("x1>"+x1+" / y1>"+y1+" / map>"+map[x1][y1]+" / visit>"+visit[x1][y1]);
						qx.add(x1);
						qy.add(y1);
						visit[x1][y1] = true;
					}
				}
/*

3�� ��� ������ Ȯ��
h>3 / i>0 / j>0
x1>0 / y1>1 / map>8 / visit>false
h>3 / i>0 / j>3
x1>1 / y1>3 / map>4 / visit>false
x1>1 / y1>4 / map>6 / visit>false
h>3 / i>2 / j>0
x1>3 / y1>0 / map>7 / visit>false
x1>2 / y1>1 / map>7 / visit>false
x1>4 / y1>0 / map>8 / visit>false
x1>4 / y1>1 / map>9 / visit>false
x1>4 / y1>2 / map>5 / visit>false
x1>3 / y1>2 / map>5 / visit>false
h>3 / i>3 / j>4
x1>4 / y1>4 / map>7 / visit>false
cnt>>4
anser>>4 
  				
 */
				
			}
		}
	}
	
}
