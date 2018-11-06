package study.두태;

import java.util.Scanner;

public class p20181012_백준6603_전두태
{
	static int n, cnt;
	static int[] str;
	static int[] picked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			} else {
				str = new int[n];
				picked = new int[n];
				
				for (int i = 0; i < n; i++) {
					str[i] = sc.nextInt();
				}
				
				comb(0, n, 6, 0);
			}
		}
	}
	
	public static void comb(int k, int n, int r, int start) {
		if (k == r) {
			for (int i = 0; i < k; i++) {
				System.out.print(picked[i] + " ");
			}
			System.out.println("");
			return;
		}
		for (int i = start; i < n; i++) {
			picked[k] = str[i];
			comb(k + 1, n, r, i + 1);
		}
	}
}
