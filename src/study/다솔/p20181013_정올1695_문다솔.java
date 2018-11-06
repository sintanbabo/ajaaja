package study.다솔;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p20181013_정올1695_문다솔
{
	
	static int N;
	static int map[][];
	static boolean Visit[][];
	  static ArrayList<Integer> rtnList;
	
	  
	  static class Node{
			int x; 
			int y;

			public Node(int x, int y){
				this.x = x;
				this.y = y;
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		Visit = new boolean[N][N];
		map = new int[N][N];
		 rtnList = new ArrayList<Integer>();
		
		
		for(int i =0; i<N; i++) {
			String temp = sc.next();
			for(int j=0; j<N; j++) {
				
				map[i][j] = temp.charAt(j) -'0';
				
			}
			
		}
		
		Queue<Node> q = new LinkedList<>();
		
		   for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	            	 if(map[i][j] == 1 && !Visit[i][j]){
	                     Visit[i][j] = true;
	                     q.add(new Node(i, j));
	                     
	                     
	               int cnt =0;
	               
	               while(q.isEmpty()) {
	            	   Node n = q.remove();
	            	   
	            	   int nextx = n.x;
	            	   int nexty = n.y;
	            	   
	            	   
	            	   cnt++;
	            	   
	            	   if( nexty+1 <N && map[nextx][nexty+1] == 1) {
	            		   if(!Visit[nextx][nexty+1]) {
	            			   Visit[nextx][nexty+1] =true;
	            			   q.add(new Node(nextx, nexty+1));
	            		   }
	            		   
	            	   }
	            	   
	            	   if( nextx+1 <N && map[nextx+1][nexty] > 0) {
	            		   if(!Visit[nextx+1][nexty]) {
	            			   Visit[nextx+1][nexty] =true;
	            			   q.add(new Node(nextx+1, nexty));
	            		   }
	            		   
	            	   }
	            	   
	            	   if( nextx-1 >0 && map[nextx-1][nexty] > 0) {
	            		   if(!Visit[nextx-1][nexty]) {
	            			   Visit[nextx-1][nexty] =true;
	            			   q.add(new Node(nextx-1, nexty));
	            		   }
	            		   
	            	   }
	            	   
	            	   
	            	   if( nexty-1 >0 && map[nextx][nexty-1] > 0) {
	            		   if(!Visit[nextx][nexty-1]) {
	            			   Visit[nextx][nexty-1] =true;
	            			   q.add(new Node(nextx, nexty-1));
	            		   }
	            		   
	            	   }
	               }
	                     
	               rtnList.add(cnt);    
	                     
				}	
	            	 
	            	 
	            	 
	            	 
		}
	
		
		
		
	}
		   Collections.sort(rtnList);
	        System.out.println(rtnList.size());
	        for (int i = 0; i < rtnList.size(); i++) {
	            System.out.println(rtnList.get(i));
	        }
	}
}
	

	