package study.두태;

import java.util.Scanner;

public class p20181022_정올1175_전두태
{
	static int N, M;
	static int cnt = 0;
	static char[] str, order;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		str = new String("123456").toCharArray();
		order = new char[N];
		
		perm_repeat(0, str.length, N);
	}
	
	public static void perm_repeat(int k, int n, int r) {
		int sum = 0;
		if (k == r) {
			for (int i = 0; i < k; i++) {
				sum += order[i] - '0';
			}
			
			if (sum == M) {
				for (int i = 0; i < k; i++) {
					System.out.print(order[i] + " ");
				}
				System.out.println("");
			}
			
			return;
		}
		for (int i = 0; i < n; i++) {
			order[k] = str[i];
			perm_repeat(k + 1, n, r);
		}
	}
}
