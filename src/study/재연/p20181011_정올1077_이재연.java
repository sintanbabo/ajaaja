package study.재연;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p20181011_정올1077_이재연
{

	static int n,w;
	static int wi[];
	static int pi[];
	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//jungol//test_1077.txt"));
		n = sc.nextInt();
		w = sc.nextInt();
		
		/*배열?�� ?��?���? ?��?��?�� ???��*/
		int arr[][] = new int[n][2];
		for(int i=0; i<n; i++){
			for(int j=0; j<2; j++){
				arr[i][j] = sc.nextInt();
			}
		}		
		
		/*
		for(int i=0; i<n; i++){
			for(int j=0; j<2; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		System.out.println("---start---");
		
		
		
		int data[][] = new int[n][2]; // 1개당 최고 무게�? ?��?�� 배열 ?��?��
		ArrayList<Integer> list = new ArrayList<Integer>(); // 무게�? ?��?�� 리스?�� ?��?��
		for(int i=0; i<n; i++){
			for(int j=0; j<2; j++){
				if(j==0){
					data[i][j] = arr[i][0];
				}else{					
					int val =arr[i][1] / arr[i][0];
					data[i][j] = val;
					list.add(val);
				}
				
				
			}
		}
		
		// ???�� �? ?��?��
		Collections.sort(list);

		
		int weight = 0;
		for(int i=list.size()-1; i>=0; i--){
			boolean flag = true;
			
			for(int j=0; j<data.length; j++){
				
				if(flag){
				/*
				System.out.println("list.get(i)>"+list.get(i));
				System.out.println("data[j][1]>" +data[j][1]);
				*/
					if(list.get(i) == data[j][1]){
						/*
						System.out.println("list.get(i)>"+list.get(i));
						System.out.println("data[j][1]>" +data[j][1]);
						System.out.println("data[j][0]>" +data[j][0]);
						*/
						
						for(int k=1; k<=n; k++){ // n?? 보석?�� 개수
							if(k*data[j][0] <= w){
								weight = weight+ arr[j][1];
							}else{
								
								/*
								System.out.println("k>"+k);
								System.out.println("k2>"+data[j][0]);
								*/
								
								w = w-((k-1)*data[j][0]);
								flag = false;
								break;
							}
						}
						
					}
				}else{
					break;
				}
			}
		}
		
		System.out.println(weight);	
		
	}

}
