package study.다솔;

import java.util.Scanner;

public class p20181012_백준6603_문다솔{
	
	static int k;
	static int S[],A[];
	
	public static void comb(int start, int depth){
	
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(A[i]);
			}
			System.out.println("");
			return;
		}
		for(int i = start; i<k; i++) {
			A[depth] = S[i];
			comb(i+1,depth+1);
		}

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  =new Scanner(System.in);
		k = sc.nextInt();
		
		S = new int[k+1];
		A = new int[k];
		for(int i = 0; i<k; i++) {
			
			S[i] = sc.nextInt();
		}
		
		comb(0,0);

	}

}
