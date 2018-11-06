package study.재연;

import java.io.FileInputStream;
import java.util.Scanner;

public class p20181012_백준6603_이재연 {

	static int k;
	static int s[];
	static int cnt = 0;
	static String res = "";
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181031//bj_input6603.txt"));
		
		while((k = sc.nextInt()) !=0){
			s = new int[k];
			
			for(int i=0; i<k; i++){
				s[i] = sc.nextInt();
			}
			
			for(int i=0; i<k; i++){
				cnt = 1;
				dfs(i, String.valueOf(s[i]));
			}
		}

	}
	
	public static void dfs(int i, String data){
		if(cnt == 6){
			System.out.println(data);
		}else{
			for(int j = i+1; j<k; j++){
				cnt++;
				dfs(j, data+" "+s[j]);
			}
		}
		cnt--;
	}

}
