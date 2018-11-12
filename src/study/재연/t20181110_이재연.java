package study.재연;

import java.io.*;
import java.util.*;

public class t20181110_이재연 {
/*
2
RRRRRRRRRR
RGGGGGRGGG
RBBBBBRBBB
RRRRRRRRRR
BBBGGBBBGG
BRRRRRBRRR
BGGGGGBGGG
BBBBBBBBBB
BRRRRRBRRR
BBGGGBRBGG
 */
	
	
	
	static int n;
	static char map[][][];
	static char data[][][];
	static int max = 0;
	static int count = 1;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("D:\\1110.txt"));
		// TODO Auto-generated method stub
		n = sc.nextInt();
		System.out.println(n);
		
		map = new char [n][5][10];
		data = new char[n][5][4];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			for(int j=0; j<5; j++) {
				String str = sc.next();
				String next = str.substring(0, 4);
				for(int k=0; k<10; k++) {
					map[i][j][k] = str.charAt(k);
				}
				for(int k=0; k<4; k++) {
					data[i][j][k] = next.charAt(k);
				}
			}
		}
		
		System.out.println("-- 사진 --");
		for(int i=0; i<n; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; k<10; k++) {
					System.out.print(map[i][j][k]);
				}
				System.out.println();
			}
			System.out.println("--4 개 자른 값--");
			
			for(int j=0; j<5; j++) {
				for(int k=0; k<4; k++) {
					System.out.print(map[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println("------start------");
		
		// 0,0 은 원래 기준사진의 시작 0(첫번째), 자른 사진의 시작(0) 첫번째
		dfs(0,0);
		System.out.println("max>"+max);

	}
	public static void change(int k1, int a1) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<4; j++) {
				map[k1][i][j+6] = data[a1][i][j]; 
			}
		}
		System.out.println("jaeyeon");
	}
	
	public static void dfs(int k, int a) {
		if(a<n && k<n) {
			for(k=0; k<n; k++) {
				for(a=0; a<n; a++) {
					int cnt = 0;
					boolean flag = false;
					for(int i=0; i<5; i++) {
						for(int j=0; j<4; j++) {
							if(k != a) {
								if(map[k][i][j+6] == data[a][i][j]) {
									cnt++;
								}
								
								if(cnt >=16 ) {
									flag = true;
									// 기준 사진 뒷면에 다음 사진 앞 부분 치환 함수
									//	change(k, a);
									// 밑에 for문이 치환 로직
									for(int ii=0; ii<5; ii++) {
										for(int jj=0; jj<4; jj++) {
											map[k][ii][jj+6] = data[a][ii][jj]; 
										}
									}
									
									count++;
									max = Math.max(max, count);
									dfs(k,a+1);
								}
								
							}
							if(flag) {
								break;
							}
						}
					}
					count = 0;
				}
			}
		}
		
	}
}