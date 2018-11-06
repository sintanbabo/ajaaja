package study.다솔;

import java.util.Scanner;

public class p20181013_정올1278_문다솔
{
	
	static int N;
	static int W;
	static int Wi[], Pi[];
	static int map[][];
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		
		Wi = new int[N+1];
		Pi = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			
			Wi[i] = sc.nextInt();

			Pi[i] = sc.nextInt();
						
		}
		
		map = new int[N+1][W+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=W; j++) {
				
				if(j-Wi[i] <0) {
					
					map[i][j] = map[i-1][j];
				}else {
					
					map[i][j] = Math.max(map[i-1][j-Wi[i]]+Pi[i], map[i-1][j]);
				}
			
			
			}
			
		}
		

		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=W; j++) {
			
			max =0;
				
				if(map[i][j] > max) {
					
					max = map[i][j];
				}
				
				
			}
			
		}
		
		System.out.println(max);
	}

}
