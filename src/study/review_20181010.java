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
		int Answer = 0;		// 에러일 경우 0을 출력하기 위해서 0으로 초기화
		
		// 입력값 받기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				MAP[i][j] = sc.nextInt();
			}
		}
		
		int zero, one, two, three;
		
		// 2차원 배열 탐색 시작
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 사용할 변수 초기화
				zero = one = two = three = 0;
				
				// 자신이 0이 아닐 때만 시작하다.
				if (MAP[i][j] != 0) {
					
					// 상좌
					if (i-1 >= 0 && j-1 >= 0) {
						if (MAP[i-1][j-1] == 0) zero++;
						else if (MAP[i-1][j-1] == 1) one++;
						else if (MAP[i-1][j-1] == 2) two++;
						else if (MAP[i-1][j-1] == 3) three++;
					}
					
					// 상
					if (i-1 >= 0) {
						if (MAP[i-1][j] == 0) zero++;
						else if (MAP[i-1][j] == 1) one++;
						else if (MAP[i-1][j] == 2) two++;
						else if (MAP[i-1][j] == 3) three++;
					}
					
					// 상우
					if (i-1 >= 0 && j+1 < N) {
						if (MAP[i-1][j+1] == 0) zero++;
						else if (MAP[i-1][j+1] == 1) one++;
						else if (MAP[i-1][j+1] == 2) two++;
						else if (MAP[i-1][j+1] == 3) three++;
					}
					
					// 좌
					if (j-1 >= 0) {
						if (MAP[i][j-1] == 0) zero++;
						else if (MAP[i][j-1] == 1) one++;
						else if (MAP[i][j-1] == 2) two++;
						else if (MAP[i][j-1] == 3) three++;
					}
					
					// 자신
					if (MAP[i][j] == 1) one++;
					else if (MAP[i][j] == 2) two++;
					else if (MAP[i][j] == 3) three++;
					
					// 우
					if (j+1 < N) {
						if (MAP[i][j+1] == 0) zero++;
						else if (MAP[i][j+1] == 1) one++;
						else if (MAP[i][j+1] == 2) two++;
						else if (MAP[i][j+1] == 3) three++;
					}
					
					// 하좌
					if (i+1 < N && j-1 >= 0) {
						if (MAP[i+1][j-1] == 0) zero++;
						else if (MAP[i+1][j-1] == 1) one++;
						else if (MAP[i+1][j-1] == 2) two++;
						else if (MAP[i+1][j-1] == 3) three++;
					}
					
					// 하
					if (i+1 < N) {
						if (MAP[i+1][j] == 0) zero++;
						else if (MAP[i+1][j] == 1) one++;
						else if (MAP[i+1][j] == 2) two++;
						else if (MAP[i+1][j] == 3) three++;
					}
					
					// 하우
					if (i+1 < N && j+1 < N) {
						if (MAP[i+1][j+1] == 0) zero++;
						else if (MAP[i+1][j+1] == 1) one++;
						else if (MAP[i+1][j+1] == 2) two++;
						else if (MAP[i+1][j+1] == 3) three++;
					}
					
					// 집을 지을 수 있는지 검증
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
