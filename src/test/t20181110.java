package test;

import java.util.Scanner;

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

public class t20181110 {
	
	public static int data[] = {1,2,3,4,5,6,7,8,9,10};
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long start = System.currentTimeMillis();
		char map[][][];
		int n = sc.nextInt();
		System.out.println(n);
		
		map = new char [n][5][10];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			for(int j=0; j<5; j++) {
				String str = sc.next();
				String next = str.substring(0, 4);
				for(int k=0; k<10; k++) {
					map[i][j][k] = str.charAt(k);
				}
			}
		}
		
				
		long end = System.currentTimeMillis(); 
		System.out.println((end-start)/1000 +" 초 걸림");
	}
}
