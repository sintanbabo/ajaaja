package study;

import java.util.Scanner;

/*
4
0 2 2 1
2 3 2 2
3 0 1 3
1 1 1 2

 */
public class review_20181010 {

	public static void main(String[] args) {
		int MAP[][] = new int[12][12];
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int Answer = 0;		// ������ ��� 0�� ����ϱ� ���ؼ� 0���� �ʱ�ȭ
		
		// �Է°� �ޱ�
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				MAP[i][j] = sc.nextInt();
			}
		}
		
		int zero, one, two, three;
		
		// 2���� �迭 Ž�� ����
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// ����� ���� �ʱ�ȭ
				zero = one = two = three = 0;
				
				// �ڽ��� 0�� �ƴ� ���� �����ϴ�.
				if (MAP[i][j] != 0) {
					
					// ����
					if (i-1 >= 0 && j-1 >= 0) {
						if (MAP[i-1][j-1] == 0) zero++;
						else if (MAP[i-1][j-1] == 1) one++;
						else if (MAP[i-1][j-1] == 2) two++;
						else if (MAP[i-1][j-1] == 3) three++;
					}
					
					// ��
					if (i-1 >= 0) {
						if (MAP[i-1][j] == 0) zero++;
						else if (MAP[i-1][j] == 1) one++;
						else if (MAP[i-1][j] == 2) two++;
						else if (MAP[i-1][j] == 3) three++;
					}
					
					// ���
					if (i-1 >= 0 && j+1 < N) {
						if (MAP[i-1][j+1] == 0) zero++;
						else if (MAP[i-1][j+1] == 1) one++;
						else if (MAP[i-1][j+1] == 2) two++;
						else if (MAP[i-1][j+1] == 3) three++;
					}
					
					// ��
					if (j-1 >= 0) {
						if (MAP[i][j-1] == 0) zero++;
						else if (MAP[i][j-1] == 1) one++;
						else if (MAP[i][j-1] == 2) two++;
						else if (MAP[i][j-1] == 3) three++;
					}
					
					// �ڽ�
					if (MAP[i][j] == 1) one++;
					else if (MAP[i][j] == 2) two++;
					else if (MAP[i][j] == 3) three++;
					
					// ��
					if (j+1 < N) {
						if (MAP[i][j+1] == 0) zero++;
						else if (MAP[i][j+1] == 1) one++;
						else if (MAP[i][j+1] == 2) two++;
						else if (MAP[i][j+1] == 3) three++;
					}
					
					// ����
					if (i+1 < N && j-1 >= 0) {
						if (MAP[i+1][j-1] == 0) zero++;
						else if (MAP[i+1][j-1] == 1) one++;
						else if (MAP[i+1][j-1] == 2) two++;
						else if (MAP[i+1][j-1] == 3) three++;
					}
					
					// ��
					if (i+1 < N) {
						if (MAP[i+1][j] == 0) zero++;
						else if (MAP[i+1][j] == 1) one++;
						else if (MAP[i+1][j] == 2) two++;
						else if (MAP[i+1][j] == 3) three++;
					}
					
					// �Ͽ�
					if (i+1 < N && j+1 < N) {
						if (MAP[i+1][j+1] == 0) zero++;
						else if (MAP[i+1][j+1] == 1) one++;
						else if (MAP[i+1][j+1] == 2) two++;
						else if (MAP[i+1][j+1] == 3) three++;
					}
					
					// ���� ���� �� �ִ��� ����
					if (zero == 0 && one >= 1 && two >= 1 && three >= 1) {
						Answer++;
						System.out.println("point : " + i + "," + j);
					}
				}
			}
		}
		
		System.out.println(Answer);
	}
}
