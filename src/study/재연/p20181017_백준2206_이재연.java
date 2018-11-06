package study.재연;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181017_백준2206_이재연
{
	
	
	/**
	 *  ���ͳ� ���� �ڵ�
	 *  https://github.com/bactoria/BOJ/blob/master/_2206.java
	 * 
	 */
	
	static int n;			// ��ǥ
	static int m;			// ��ǥ
	static int map[][];		// map
	static boolean visit[][];	// �湮
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	static int min;
	static int count;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181017//bj_input2206.txt"));

		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		visit = new boolean[n][m];
		min = Integer.MAX_VALUE;
		count = 1;
		
		for(int i=0; i<n; i++){
			String s = sc.next();
			for(int j=0; j<m; j++){
				map[i][j] = s.charAt(j)-48;
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("---start---");
		
		
		visit[0][0] = true;
		dfs(0,0,false);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	public static void dfs(int x, int y, boolean used){
		
		//n,m�� ����. 
		if(x == n-1 && y == m-1) { 
			min = min(min,count); 
		} 
		//dfs �� �ǹ̾��� dfs�� ����
		if(count > min) return; 
				
		for (int k = 0; k < 4; k++) {
			int x1 = x + dx[k];
			int y1 = y + dy[k];
			 
			if(!inRange(x1,y1)) continue;
			if(visit[x1][y1]) continue;
			
			if(map[x1][y1] == 0) {
					visit[x1][y1] = true;
					count++;
//System.out.println("map[x1][y1]>"+map[x1][y1]+"/ �̵� �� x�� ��ǥ>"+x1+" / �̵� �� y�� ��ǥ>"+y1+ " / "+x1+","+y1);		
					dfs(x1,y1,used);
					count--;
					visit[x1][y1] = false;
			}else if((!used)) {
					visit[x1][y1] = true;
					count++;
//System.out.println("map[x1][y1]>"+map[x1][y1]+"/ �̵� �� x�� ��ǥ>"+x1+" / �̵� �� y�� ��ǥ>"+y1+ " / "+x1+","+y1);		
					dfs(x1,y1,(!used));
					count--;
					visit[x1][y1] = false;
			}
			
		}
		
	}
	
	public static int min(int a, int b) {
		return a > b? b:a;
	}
	 
	public static boolean inRange(int i, int j) {
		return i>=0 && j>=0 && i<n && j<m ;
	}
	
/**
			if(map[x1][y1] == 0) {
					visit[x1][y1] = true;
					count++;
					dfs(x1,y1,used);
					count--;
					visit[x1][y1] = false;
			}else if((!used)) {
					visit[x1][y1] = true;
					count++;	
					dfs(x1,y1,(!used));
					count--;
					visit[x1][y1] = false;
			}
			
���� �μ��� ��� boolean ������ ���� �� 
�ν� ���� true �� �ǰ� �ٽ� �����ϴٰ� map[x1][y1] == 0 ��	use = false ������ ������
�Դ� �� �ٽ� �ڷ� back count = --, �湮�� �ٽ� false
 */
}
