package study.두태;

import java.util.ArrayList;
import java.util.Scanner;

public class std_소수찾기_백준1978_전두태 {
	static int N;
	static int[] A;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < A[i]; j++) {
				if (A[i] % j == 0) {
					list.add(A[i]);
				}
			}
		}
		
		boolean isOne = false;
		for (int i = 0; i < N; i++) {
			if (A[i] == 1) {
				isOne = true;
			}
		}
		
		if (isOne == true) {
			System.out.println(N - list.size() - 1);
		} else {
			System.out.println(N - list.size());
		}
	}
}
