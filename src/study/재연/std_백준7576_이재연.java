package study.재연;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class std_백준7576_이재연 {

	static int n,m;
	static int map[][];
	static boolean visit[][];
	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	static Queue<Integer> qx = new LinkedList<Integer>();
	static Queue<Integer> qy = new LinkedList<Integer>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//baejoon//test_7576.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		 map = new int[m][n];
		 visit = new boolean[m][n];
		 
		 // ?��?? ?��마토 = 1
		 // ?���? ?��??�? = 0
		 // ?��?��?��  x  = -1
		 
		 
		 // ?���? 범위?��?�� ?��?? ?��마토 ?��?��
		 for(int i=0; i<m; i++){
			 for(int j=0; j<n; j++){
				 map[i][j] = sc.nextInt();
				 
				 if(map[i][j] == 1){
					 qx.add(i);
					 qy.add(j);
				 }
			 }
		 }
		 
		 bfs();
		 
		 for(int i=0; i<m; i++){
			 for(int j=0; j<n; j++){
				System.out.print(map[i][j]); 
			 }
			 System.out.println();
		 }
	}
	
	public static void bfs(){
		int res = 0;
		int x, y;
		int x1, y1;
		
		while(!qx.isEmpty() || !qy.isEmpty()){
			x = qx.poll();
			y = qy.poll();
			
			visit[x][y] = true;
			
			for(int i=0; i<4; i++){
				x1 = x+dx[i];
				y1 = y+dy[i];
				
				if(x1>=0 && y1 >=0 && x1<m && y1 <n){
					if(map[x1][y1] == 0 && visit[x1][y1]==false){
						qx.add(x1);
						qy.add(y1);
						
						visit[x1][y1] = true;
						
						map[x1][y1] = map[x][y]+1;
						res = map[x1][y1];
					}
				}
			}
		}
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(map[i][j]==0){
					res = -1;
				}
			}
		}
		
		System.out.println("-----");
		if(res>0){
			System.out.println(res-1);
		}else{
			System.out.println(res);
		}
	}

}
