package study.다솔;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181014_기출0526_문다솔 {
	
	static int N,A,B,C,D;
	static int map[][];
	static boolean visited[][];


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("C:\\Users\\dasol\\eclipse-workspace\\test\\src\\study3\\testCase"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		
	
	
		visited = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j =1; j<=N; j++) {
				
				map[i][j] = sc.nextInt();
				
			}
			
		}
		
		A = sc.nextInt(); 
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		dfs(A,B);
		
		if(visited[C][D] == true) {
			
				System.out.println("1");
		}else {
			System.out.println("0");
		}

	}


	public static void dfs(int i, int j) {
	
		//醫낅즺議곌굔
		if( i == C && j == D) {

			return;
		}
		
			
		
					//�긽
					if(i-1 > 0 && map[i-1][j] == 1 && visited[i-1][j] == false) {
						visited[i-1][j] = true;
						dfs(i-1,j);
						visited[i-1][j] = false;
						
					}
					//�븯
					if(i+1 < N && map[i+1][j] == 1 && visited[i+1][j] == false) {
						visited[i+1][j] = true;
						dfs(i+1,j);
						visited[i+1][j] = false;
						
					}
					//醫�
					if(j-1 > 0 && map[i][j-1] == 1 && visited[i][j-1] == false) {
						visited[i][j-1] = true;
						dfs(i,j-1);
						visited[i][j-1] = false;
					}
					//�슦
					if(j+1 < N && map[i][j+1] == 1 && visited[i][j+1] == false) {
						visited[i][j+1] = true;
						dfs(i,j+1);
						visited[i][j+1] = false;
					}
					
					
				}
	 


	

}
