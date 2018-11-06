package study.다솔;

import java.util.Scanner;

public class p20181015_백분1987_문다솔 {

	static int R,C;
	static char map[][];
	static int check[] = new int[26] ;
	static int mx[] = {-1,1,0,0};
	static int my[] = {0,0,-1,1};
	static char A[];
	static int cnt = 1;	
	static int max;
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		A = new char[26];
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String temp = sc.next();
			for(int j =0; j<C; j++) {
				map[i][j] = temp.charAt(j);		
			}
		}
		
		
		DFS(0,0);
		
		
	}


	public static void DFS(int i, int j) {
		// TODO Auto-generated method stub
		cnt++;
		if(max >cnt) {
			
			max = cnt;
		}
		
		
		//諛⑸Ц�븳 �븣�뙆踰� 泥댄겕
		check[map[i][j]] = 1;
		
		//�긽�븯醫뚯슦�깘�깋
		
		for(int k = 0; k<4; k++) {
			
			int x = i + mx[k];
			int y = j + my[k];
			
			if(x > -1 && y > -1 && x < R && y < C) {
				
					if(check[map[i][j]] != 1) {   
						DFS(x,y);
					}
					
					
				}
			
			
			}
		}
		
		
	}


