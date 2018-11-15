package study.재연;

import java.io.*;
import java.util.*;

public class std20181114_jo1082 {

	static int r;
	static int c;
	static char map[][];
	static boolean[][] visit;
	static boolean[][] visitfire;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("c://sw//final1110_ahja//input_jo_1082.txt"));
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		map = new char [r][c];
		visit = new boolean [r][c];
		visitfire = new boolean [r][c]; 
		
		sc.nextLine();
		for(int i=0; i<r; i++){
			String str = sc.next();
			for(int j=0; j<c; j++){
				map[i][j] = str.charAt(j);
				visit[i][j] = false;
			}
		}
		
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.println("--start--");

		int startJix = 0;
		int startJiy = 0;
		int startHomeX = 0;
		int startHomeY = 0;
		String who = "";
		String fire = "";
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] == 'S'){
					startJix = i;
					startJiy = j;
					who = "j";
				}
				if(map[i][j] == '*'){
					startHomeX = i;
					startHomeY = j;
					fire = "f";
				}
			}
		}
		
		bfs1(startJix,startJiy,who,startHomeX,startHomeY,fire);
		
		
		boolean anwserFlag = false;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] == 'F'){
					anwserFlag = true;
					break;
				}else{
					anwserFlag = false;
				}
			}
			if(anwserFlag){
				break;
			}
		}
		if(anwserFlag){
			System.out.println(cnt);
		}else{
			System.out.println("not");
		}
	}
	
	// public static void bfs1(int x, int y, String who, int xx, int yy, String fire)
	public static void bfs1(int x, int y, String who, int xx, int yy, String fire){
		visit[x][y] = true;
		visit[xx][yy] = true;
		
		
		Queue<bfs1082> que = new LinkedList<bfs1082>();
		que.add(new bfs1082(x, y, who));
		que.add(new bfs1082(xx, yy, fire));
	
		boolean flag = true;
		
		
		
		
		
		while(!que.isEmpty()){
			int Scnt = 0;
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					if(map[i][j]=='S'){
						Scnt++;
					}
				}
			}
			if(Scnt == 0){
				break;
			}
			
			if(cnt==7){
				System.out.println("jaeyeon");
			}
			
			bfs1082 b = que.poll();	
			// ���� bfs
			if(b.z == "j"){
				
				boolean countFlag = true;
				
				for(int i=0; i<4; i++){						
					
					int x1 = dx[i]+b.x;
					int y1 = dy[i]+b.y;
					String z1 = b.z;
					
					
					
					if(x1>=0 && x1<r && y1>=0 && y1<c){
						if((map[x1][y1] == '.' || map[x1][y1] =='D') && visit[x1][y1] == false && map[x][y] !='*'){
							
							
							if(countFlag){
								cnt++;
								countFlag = false;
							}
							
							if(map[x1][y1]=='D'){
								map[x1][y1] = 'F';
								flag = false;
								break;
							}else{
								map[x1][y1] = 'S';
								
							}
							visit[x1][y1] = true;
							que.add(new bfs1082(x1, y1, z1));
						}
					}

				}
				
				
				for(int i=0; i<r; i++){
					for(int j=0; j<c; j++){
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				System.out.println("-----");
				
			
			}else{
			// �� bfs
				
				System.out.println();
				for(int i=0; i<4; i++){
					int x1 = dx[i]+b.x;
					int y1 = dy[i]+b.y;
					String z1 = b.z;
					
					if(x1>=0 && x1<r && y1>=0 && y1<c){
						if( map[x1][y1] != 'D' && map[x1][y1] != 'X'){
							map[x1][y1] = '*';
							que.add(new bfs1082(x1, y1, z1));
							visitfire[x1][y1] = true;
						}
						
					}
				}
				
				for(int i=0; i<r; i++){
					for(int j=0; j<c; j++){
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				System.out.println("-----");
				
				
			}
			
			if(flag == false){
				break;
			}
		}
	}
}

class bfs1082{
	int x;
	int y;
	String z;
	public bfs1082(int x, int y, String z) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public String toString(){
		return String.valueOf(x)+" / "+String.valueOf(y)+ " / "+ z;
	}
}