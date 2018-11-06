package study.재연;

import java.util.*;
import java.io.*;

public class p20181015_백준1987_이재연
{
	
	static int r, c; // ��, ��
	static char[][] map; // ����
	static boolean[] visit = new boolean[26]; // �湮 -  ���ĺ� A~Z 26��
	static int[] dx = {-1,0,1,0};  // ��, ��, ��, ��
	static int[] dy = {0,-1,0,1};
	static int max = 0; // ���ĺ��� ���� �Ÿ��� Ȯ�� �ϱ� ���� ��
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181015//bj_input1987.txt"));
		
		r = sc.nextInt(); // ��
		c = sc.nextInt(); // ��
		
		map = new char[r][c];
		for(int i=0; i<r; i++){
			map[i]=sc.next().toCharArray();
		} 
		
		int temp = map[0][0]-65;	// ���� �������� C �̹Ƿ� int�� ��ȯ �� �ʱⰪ�� 2�� ��
		
		visit[temp] = true;
				
		dfs(0,0,1);	// x ������, y ������, cnt �� (ó�� �������ڸ��� ���ϱ� �ʱⰪ 1)
		System.out.println("�ִ� ĭ����>"+max);
	}
	

	public static void dfs(int x, int y, int cnt){
		max= Math.max(cnt,  max);
		
		// ���������κ��� ����
		for(int i=0; i<4; i++){
			int _x = dx[i]+x;
			int _y = dy[i]+y;
			
			if(_x>=0 && _y >=0 && _x<r && _y<c){
				int t = map[_x][_y] -65;
			//	System.out.println("i>"+i+" / "+"_x>"+_x+" / "+"_y>"+_y+" / "+"map>"+map[_x][_y]);
				
				if(visit[t] == false){
					visit[t] = true;
					
				//	cnt++;		// �����ؾ���.
					
				//	System.out.println("i>"+i+" / "+"_x>"+_x+" / "+"_y>"+_y+" / "+"map>"+map[_x][_y]+" / "+"t>"+t+" / " +"cnt>"+cnt);
					
					dfs(_x, _y, cnt+1);
					visit[t] = false;
					
					
					/*
					
					dfs(0,0,1)
					i=2				i=3
						v				v
					dfs(1,0,2)		dfs(0,1,2)
					    v				v
					dfs(1,1,3)		dfs(1,1,3)
					    v
					
					 */
					/*
					
					������ 0,0 / map>c 
					(Ʋ��)
					�߰��� cnt++ ���� ��� ��� �Լ��� �ƴ� ���ö����� cnt++�� �ϱ⿡ �����ؾ���..!
					i>2 / _x>1 / _y>0 / map>A
					i>2 / _x>1 / _y>0 / map>A / t>0 / cnt>2
					i>0 / _x>0 / _y>0 / map>C
					i>3 / _x>1 / _y>1 / map>D
					i>3 / _x>1 / _y>1 / map>D / t>3 / cnt>3
					i>0 / _x>0 / _y>1 / map>A
					i>1 / _x>1 / _y>0 / map>A
					i>3 / _x>1 / _y>2 / map>C
					i>3 / _x>0 / _y>1 / map>A
					i>3 / _x>0 / _y>1 / map>A / t>0 / cnt>3
					i>1 / _x>0 / _y>0 / map>C
					i>2 / _x>1 / _y>1 / map>D
					i>2 / _x>1 / _y>1 / map>D / t>3 / cnt>4
					i>0 / _x>0 / _y>1 / map>A
					i>1 / _x>1 / _y>0 / map>A
					i>3 / _x>1 / _y>2 / map>C
					i>3 / _x>0 / _y>2 / map>A
					
					////////////////////////////////////////////////
					(�ùٸ�)
					��͸� ����ϱ⿡ dfs(_x, _y, cnt+1);�� �´� ����.
					i>2 / _x>1 / _y>0 / map>A
					i>2 / _x>1 / _y>0 / map>A / t>0 / cnt>1
					i>0 / _x>0 / _y>0 / map>C
					i>3 / _x>1 / _y>1 / map>D
					i>3 / _x>1 / _y>1 / map>D / t>3 / cnt>2
					i>0 / _x>0 / _y>1 / map>A
					i>1 / _x>1 / _y>0 / map>A
					i>3 / _x>1 / _y>2 / map>C
					i>3 / _x>0 / _y>1 / map>A
					i>3 / _x>0 / _y>1 / map>A / t>0 / cnt>1
					i>1 / _x>0 / _y>0 / map>C
					i>2 / _x>1 / _y>1 / map>D
					i>2 / _x>1 / _y>1 / map>D / t>3 / cnt>2
					i>0 / _x>0 / _y>1 / map>A
					i>1 / _x>1 / _y>0 / map>A
					i>3 / _x>1 / _y>2 / map>C
					i>3 / _x>0 / _y>2 / map>A
					
					 */	
					
				}
			}
		}
		
	}
}
