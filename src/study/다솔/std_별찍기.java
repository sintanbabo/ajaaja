package study.다솔;

import java.util.Scanner;

public class std_별찍기 {
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = N - i; j < N + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("----------------------------");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("----------------------------");

		for (int i = 1; i <= N; i += 2) {
			for (int k = i / 2; k <= 3; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("----------------------------");

		for (int i = N; i >= 1; i -= 2) {
			for (int k = i / 2; k <= 3; k++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("----------------------------");

		for (int i = 1; i < N; i += 2) {
			for (int k = i / 2; k <= 3; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = N; i >= 1; i -= 2) {
			for (int k = i / 2; k <= 3; k++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("----------------------------");

	}

}
