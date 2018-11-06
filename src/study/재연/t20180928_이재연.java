package study.재연;

import java.io.FileInputStream;
import java.util.Scanner;

public class t20180928_이재연
{

	static int test_case;
	static int a[] = new int[101]; // input data1
	static int b[] = new int[101]; // input data2

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("c://�Ұ�//test2_GYUSANGI_REBOK.txt"));

		test_case = sc.nextInt();

		for (int T = 0; T < test_case; T++) {
			String size1 = sc.next();
			String size2 = sc.next();

			for (int i = 0; i < size1.length(); i++) {
				a[i] = (int) size1.charAt(i) - 48;
			}

			for (int i = 0; i < size2.length(); i++) {
				b[i] = (int) size2.charAt(i) - 48;
			}

			if (size1.length() > size2.length()) {
				int cnt = 0;
				int modb[] = new int[size1.length()]; // �ڸ� �� ū �ʿ� ������ �迭

				/* ���� �� modb�� ū �ڸ����� �°� ������.. ex) 23 -> 023 */
				for (int i = 0; i < size1.length(); i++) {
					if (size1.length() > size2.length() + i) {
						modb[i] = 0;
						cnt++;
					} else {
						modb[i] = b[i - cnt];
					}
				}

				/* modb + a ex) 987+023 */
				for (int i = 0; i < size1.length(); i++) {
					modb[i] = a[i] + modb[i];
				}

				/* modb �ڸ� �� ���� */
				for (int i = modb.length - 1; i > 0; i--) {
					if (modb[i] > 9) {
						modb[i] = (modb[i]) - 10;
						modb[i - 1]++;
					}
				}
				/* ��� */
				for (int i = 0; i < modb.length; i++) {
					System.out.print(modb[i]);
				}

			} else {
				int cnt = 0;
				int modb[] = new int[size2.length()];
				for (int i = 0; i < size2.length(); i++) {
					if (size2.length() > size1.length() + i) {
						modb[i] = 0;
						cnt++;
					} else {
						modb[i] = a[i - cnt];
					}
				}

				for (int i = 0; i < size2.length(); i++) {
					modb[i] = b[i] + modb[i];
				}

				for (int i = modb.length - 1; i > 0; i--) {
					if (modb[i] > 9) {
						modb[i] = (modb[i]) - 10;
						modb[i - 1]++;
					}
				}

				for (int i = 0; i < modb.length; i++) {
					System.out.print(modb[i]);
				}
			}
		}
	}
}
