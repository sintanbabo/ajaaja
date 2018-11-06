package study.재연;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p20181010_백준5567_이재연
{

	static int n, m;
	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//baejoon//test_5567.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int arr [][] = new int [m][2];
		
		for(int i=0; i<m; i++){
			for(int j=0; j<2; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		/*
		for(int i=0; i<m; i++){
			for(int j=0; j<2; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		
		System.out.println("-------start---------");
		
		// 친구 
		int cnt = 0; // 친구 카운?��
		int my = 1; // ?���? ?��?��
		ArrayList<Integer> list = new ArrayList<Integer>(); // 친구
		for(int i=0; i<m; i++){
			if(my == arr[i][0]){
				list.add(arr[i][1]);
				cnt++;
				
			}
		}
		// 친구 ?���?
//		System.out.println(cnt);
		

		// 친구?�� 친구
		for(int i=0; i<m; i++){				
			for(int j=0; j<m; j++){
				if(arr[i][1] < arr[j][0]){
					/*
					System.out.println("i="+i+"> "+"arr["+i+"][1]>"+arr[i][1]);
					System.out.println("j="+j+">"+" arr["+j+"][0]>"+arr[j][0]);
					System.out.println("j="+j+">"+" arr["+j+"][1]>"+arr[j][1]);
					System.out.println("**********************************************************************");
					*/
					for(int k=0; k<list.size(); k++){
						if(arr[j][0]==list.get(k)){
							cnt++;
						}
					}
				}
			}
			
		}	
		// �? 친구
		System.out.println("?��>"+cnt);
		
	}
}
