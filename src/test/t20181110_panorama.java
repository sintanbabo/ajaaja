package test;

import java.io.FileInputStream;
import java.util.Scanner;

public class t20181110_panorama {
	
	public static char[][][] pic;
	public static int N; // 총 N장의 사진
	public static int Answer;
	public static boolean[][] connectable; // 두 사진이 이어붙일 수 있는지 여부
	public static boolean[] usedPicture; // 이미 사용된 사진인지 여부

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("C:\\Users\\User\\res\\paranomaPicture.txt"));
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int test_case=1; test_case<=T; test_case++) {
    		
    		// 입력부
    		N = sc.nextInt();
    		pic = new char[N][5][10];
    		connectable = new boolean[N][N];
    		usedPicture = new boolean[N];
    		for(int n=0; n<N; n++ )
    			for(int i=0; i<5; i++)
    				pic[n][i] = sc.next().toCharArray();
    		
    		// 알고리즘 구현부
    		// connectable 배열을 먼저 구성한다
    		Answer = 0;
    		for(int a=0; a<N; a++) {
    			for(int b=0; b<N; b++) {
    				int sameColor_count = 0;
    				for(int i=0; i<5; i++) {
    					for(int j=0; j<4; j++) {
    						if(pic[a][i][j] == pic[b][i][j+6])
    							sameColor_count++;
    						if(sameColor_count >= 16) 
    							connectable[b][a] = true; // b사진 -> a사진의 순서로 연결 가능
    					}
    				}
    				
    				sameColor_count = 0;
    				for(int i=0; i<5; i++) {
    					for(int j=6; j<10; j++) {
    						if(pic[a][i][j] == pic[b][i][j-6])
    							sameColor_count++;
    						if(sameColor_count >= 16) 
    							connectable[a][b] = true; // a사진 -> b사진의 순서로 연결 가능
    					}
    				}
    			}    			
    		}
    		
    		for(int n=0; n<N; n++) {
    			for(int k=0; k<N; k++)
    				usedPicture[k] = false;
    			
    			usedPicture[n] = true;
    			backtrack(n, 1);
    		}    		
    		
    		System.out.println("#" + test_case + " " + Answer);
    	}

    	sc.close();
	}
	
	public static void backtrack(int n, int connection_count) {
		// 더이상 연결 가능한 사진이 없을 때 최종 종료
		int remainingsToConnect_count = 0;
		for(int k=0; k<N; k++)
			if(connectable[n][k]==true && usedPicture[k]==false)
				remainingsToConnect_count++;
		if(remainingsToConnect_count == 0) {
			if(connection_count > Answer)
				Answer = connection_count;
			return;
		}
		
		for(int k=0; k<N; k++) {
			if(connectable[n][k]==true && usedPicture[k]==false) {
				usedPicture[k] = true;
				connection_count++;
				backtrack(k, connection_count);
				connection_count--;
				usedPicture[k] = false;
			}
		}
	}
}

