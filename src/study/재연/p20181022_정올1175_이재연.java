package study.재연;

import java.io.FileInputStream;
import java.util.Scanner;

public class p20181022_정올1175_이재연 {
	static int N;
	static int M;
	static int sum[];
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("D:\\gc_input1175.txt"));
		N = sc.nextInt();
		M = sc.nextInt();
		sum = new int[10];
		
		event(N, M);
	}
	
	public static void event(int n, int m) {
		for (int i = 1; i <= 6; i++){
			sum[cnt] = i;
			if (cnt == N - 1){
				int total = 0;
				
				for (int j = 0; j <= cnt; j++) {
					total += sum[j];
				}
	  
				if (total == M){
					for (int k = 0; k < N; k++) {
						System.out.print(sum[k]);
					}
					System.out.println();
				}
			}else{
				cnt++;
				event(N, M);
				cnt--;
			}
		}
	}
}
