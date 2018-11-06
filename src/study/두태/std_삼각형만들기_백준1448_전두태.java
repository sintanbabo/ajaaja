package study.두태;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class std_삼각형만들기_백준1448_전두태
{
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
		
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (A[i] > A[j]) {
					tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (A[k] < A[i] + A[j]) {
						list.add(A[i] + A[j] + A[k]);
					}
				}
			}
		}
		
		Collections.sort(list);
		
		if (list.size() == 0) {
			System.out.println("-1");
		} else {
			System.out.println(list.get(list.size() - 1));
		}
	}
}
