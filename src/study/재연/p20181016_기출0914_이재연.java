package study.재연;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181016_기출0914_이재연
{
	static int test_Case, n,m;
	static String s;
	static char map[][];	// ����
	static char arr[];	// ã�� ���ڿ�	
	static int[] dx={0,0,-1,1,-1,-1,1,1};//
	static int[] dy={-1,1,0,0,-1,1,-1,1};
	boolean flag = false;
	static int cnt = 0;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("D:\\gc_input0914.txt"));
		
		test_Case = sc.nextInt(); // �׽�Ʈ ���̽�
		
		for(int t=0; t<test_Case; t++) {
			n = sc.nextInt(); // ���ڿ� ����
			m = sc.nextInt(); // ���ڿ� ����
			s = sc.next(); // �ܾ�
			
			// ����
			map = new char[n][n];
			for(int i=0; i<n; i++){
				map[i]=(char[]) sc.next().toCharArray();
			} 
			
			// ���ڿ�
			arr = new char[m];			
			for(int i=0; i<m; i++) {
				arr[i] = s.charAt(i);
			}
			

			for(int i=0; i<m; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println("---- start -----");
			
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == arr[0]) {
						System.out.println("==============i>"+i+" / j>"+j);
						System.out.println("["+arr[0]+"]");
						bfs(i,j,0);
						System.out.println();
					}
				}
			}
			
			System.out.println("cnt>"+cnt);
			
		}
	}
	public static void bfs(int i, int j, int arrCnt) {
		
		Queue<BFS0914> que = new LinkedList<BFS0914>();
		que.add(new BFS0914(i, j, arrCnt));
		
		while(!que.isEmpty()) {
			BFS0914 b = que.poll();
			for(int k=0; k<8; k++) {
				int x1 = dx[k]+b.x;
				int y1 = dy[k]+b.y;
				int z1 = b.z+1;
				if(x1>=0 && x1<n && y1>=0 && y1<n && z1 <3) {
					if(map[x1][y1]==arr[z1]) {						
						if(z1 == 1) {
							System.out.println("["+arr[z1]+"]"+" : x1>"+x1+" / y1>"+y1+" / z1>"+z1);
							que.add(new BFS0914(x1,y1, z1));
						}else {
							System.out.println("["+arr[z1]+"]"+" : x1>"+x1+" / y1>"+y1+" / z1>"+z1);
							cnt++;
						}
						
					}
				}
				
			}
		}
		que.clear();
	}
}


class BFS0914 {
	int x;
	int y;
	int z;
 
	BFS0914(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

/*
1
5 3 DFH 
ABCDE
SDFHF
DSQAB
FHDHF
HDQEA

������ ���ĺ��� ���ؼ� DFH �׽�Ʈ ���̽��� ���
==============i>0 / j>3
[D]
[F] : x1>1 / y1>2 / z1>1
[F] : x1>1 / y1>4 / z1>1
[H] : x1>1 / y1>3 / z1>2
[H] : x1>1 / y1>3 / z1>2

==============i>1 / j>1
[D]
[F] : x1>1 / y1>2 / z1>1
[H] : x1>1 / y1>3 / z1>2

==============i>2 / j>0
[D]
[F] : x1>3 / y1>0 / z1>1
[H] : x1>3 / y1>1 / z1>2
[H] : x1>4 / y1>0 / z1>2

==============i>3 / j>2
[D]

==============i>4 / j>1
[D]
[F] : x1>3 / y1>0 / z1>1
[H] : x1>3 / y1>1 / z1>2
[H] : x1>4 / y1>0 / z1>2
 */
