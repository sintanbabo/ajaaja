package study.다솔;

import java.util.Scanner;

public class p20181018_백준1149_문다솔{
	
	static int N;
	static int m[][];
	static int check[][];
	static int A;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		m = new int[N][3];
		check = new int [N][3];
		for(int i = 0; i<=N-1; i++) {
			
				
				m[i][0] = sc.nextInt();
				m[i][1] = sc.nextInt();
				m[i][2] = sc.nextInt();
			
			
		}
		
		
		
		
		check[0][0] = m[0][0];
		check[0][1] = m[0][1];	
		check[0][2] = m[0][2];	
		
		
		
		for(int i = 1; i<N; i++) {
			
			check[i][0] = Math.min(check[i-1][1], check[i-1][2]) + m[i][0];
			check[i][1] = Math.min(check[i-1][0], check[i-1][2]) + m[i][1];
			check[i][2] = Math.min(check[i-1][0], check[i-1][1]) + m[i][2];
			
		}
		int Answer = Math.min(check[N-1][0],Math.min(check[N-1][1], check[N-1][2]));
		
		System.out.println(Answer);

	}
}