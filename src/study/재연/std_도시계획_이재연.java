package study.재연;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class std_도시계획_이재연
{

	static int n;
	static int N;
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();
	static int AnswerN;
	

	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//algo//test_dosi.txt"));
	
		n = sc.nextInt();
		N = n;
		char arr [][] = new char[n][n];
		
		int cnt = 0;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = sc.next().charAt(0);
				if(arr[i][j] == 'B'){
					cnt++;
				}
			}
		}
		System.out.println("cnt>"+cnt);
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("----start----");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
					
				if(arr[i][j] == 'B') {
					if(arr[i-1][j] == 'G' || arr[i+1][j] == 'G' || arr[i][j-1] == 'G' || arr[i][j+1] == 'G') {
						AnswerN++;
					}else {
						
						// case 1
						/*
						int count = 1;
						for(int k=1; i-k >= 0; k++ ) {
							if(arr[i-k][j] == 'B') {
								count++;
							}
						}
						for(int k=1; i+k<N; k++) {
							if(arr[i+k][j] == 'B') {
								count++;
							}
						}
						for(int k=1; j-k>=0; k++) {
							if(arr[i][j-k] == 'B') {
								count++;
							}
						}
						for(int k=1; j+k<N; k++) {
							if(arr[i][j+k] == 'B') {
								count++;
							}
						}
						AnswerN = AnswerN + count;
						*/
						
						// case2
						int count = 0;
						for(int k=0; k<N; k++) {
							if(arr[i][k] == 'B') {
								count++;
							}
						}
						for(int k=0; k<N; k++) {
							if(arr[k][j] == 'B' ) {
								count++;
							}
						}
						
						count--;
						AnswerN = AnswerN + count;
					}
				}
			}
		}
		
		
		
		
		
	}
	public static void func(int x, int y){
		// �?
		if((x+1) != 0 && (x-1) != 0 && (y+1) != 0 && (y-1) != 0 ){
			System.out.println("x>"+x);
			System.out.println("y>"+y);
			System.out.println("jaeyeon");
		}

	}
	
}