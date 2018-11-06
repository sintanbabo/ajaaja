package study.다솔;

import java.util.Scanner;

public class p20181011_정올1077_문다솔
{
	
	static int N;
	static int W;
	static int Wi[], Pi[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		
		Wi = new int[N+1];
		Pi = new int[N+1]
;		
		for(int i=1; i<=N; i++) {
			
			Wi[i] = sc.nextInt();
			Pi[i] = sc.nextInt();
						
		}
		
		
		int map[][] = new int[N+1][W+1];
		
		int max = 0;
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<W+1; j++) {
				
				if(j - Wi[i] <0) {
					
					map[i][j] = map[i-1][j];
					
				}else {
					map[i][j] = Math.max(map[i][j - Wi[i]]+Pi[i], map[i-1][i]);
					
				}
				
			
				
			}
			
		}
		
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<W+1; j++) {
					
			 if(max<map[i][j]) {
				 
				 max = map[i][j];
			 }
				
				}
		
			}
		
	
		System.out.print(max);
	}

}
