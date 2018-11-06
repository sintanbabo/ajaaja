package study.두태;

import java.util.Scanner;

public class std_괄호_전두태
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String arr[] = new String[N];
		int result[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
			
			if (arr[i].substring(0, 1).equals(")")) {
				result[i] = -1;
			} else {
				for (int a = 0; a < arr[i].length(); a++) {
					if (arr[i].substring(a, a + 1).equals("(")) {
						result[i] += 1;
						if (result[i] < 0) {
							result[i] = -1;
							break;
						}
					} else {
						result[i] -= 1;
						if (result[i] < 0) {
							result[i] = -1;
							break;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (result[i] == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}