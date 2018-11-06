package study.다솔;

import java.util.Scanner;

public class p20181008_백준2846_문다솔
{
	
	static int N;
	static int[] Pi;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		
		Pi = new int[N];
		
		for(int i =0; i<N; i++) {
			
			Pi[i] = sc.nextInt();
		}
		
		int max =0;
		int Answer =0;
		
		for(int i =0; i<N-1; i++) {

			if( Pi[i] < Pi[i+1] ) {
				
				Answer += Pi[i+1]-Pi[i];
			}
			else{
				Answer = 0;
				
			}
			
			if(max<Answer) {
				
				max = Answer;
			}
		}
		

				System.out.println(max);


		
	}
	
}
