package study.두태;

import java.util.Scanner;

public class std_오르막길_전두태
{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = 0;
		int b = 0;
		int max = 0;
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				a = arr[i];
				
				if (arr.length == 2) {
					b = arr[i + 1];
				} else {
					while (arr[i] < arr[i + 1]) {
						b = arr[i + 1];
						
						if (i < arr.length - 2) i++;
						else break;
					}
				}
			}
			
			if (max < (b - a)) max = b - a;
		}
		
		System.out.println(max);
	}
}
