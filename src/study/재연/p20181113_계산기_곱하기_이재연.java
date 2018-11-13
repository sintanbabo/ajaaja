package study.재연;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class p20181113_계산기_곱하기_이재연 {

	static int test_case;
	static int a[]; // input1 �迭
	static int b[]; // input2 �迭
	static int gubun = 0;

	public static void func(String input1, String input2) {
		// �� �Լ������� ������ input1�� ū ��
		// ���ϱ��� ���� ���� a ���ϱ��� ���� ���� b

		int size = input1.length();
		/* a, b input data �迭 */
		a = new int[size];
		b = new int[size];

		for (int i = 0; i < size; i++) {
			a[i] = input1.charAt(i) - 48;
		}

		for (int i = 0; i < size; i++) {
			b[i] = input2.charAt(i) - 48;
		}

		// 405 117
		// 415 117
		// 005 117

		// ���ϱ� ���� ����
		String sum = "";
		String endData = "";
		String updata = "";
		List list = new ArrayList<>();

		String data = "N/a";
		boolean flag = false;
		String ten = "";

		for (int i = size - 1; i >= 0; i--) {
			int cur = b[i];
			System.out.println(cur);
			for (int j = size - 1; j >= 0; j--) {
				if (a[j] == 0) {
					if (updata != "") {
						data = updata + endData;
					} else {
						data = "0" + data;
					}
					updata = "";

					if (j == 0) {
						data = data + ten;
						list.add(data);
						updata = "";
						endData = "";
						data = "N/a";
						ten = "0" + ten;
					}
				} else {
					if (data == "N/a") {
						data = "";
						data = cur * a[j] + data;
					} else {
						if (j == size - 1) {
							data = cur * a[j] + data;
						} else {
							if (updata != "") {
								int dup = (cur * a[j]) + Integer.parseInt(updata);
								data = dup + data + "";

							} else {
								int dup = cur * a[j];
								data = dup + data + "";
								flag = true;
							}
						}

					}
					if (j == 0) {
						data = data + ten;
						list.add(data);
						updata = "";
						endData = "";
						data = "N/a";
						ten = "0" + ten;
					} else {
						if (Integer.parseInt(data) > 10) {
							if (!flag) {
								updata = data.substring(0, 1);
								endData = data.substring(1, data.length());
								data = endData;
							}
						}
					}
				}

			}
		}

	}

	public static void main(String[] args) throws Exception {
		//System.in = new FileInputStream("c://sw//adPlzeFinal//multiplication_20181112.txt");
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		for (int T = 0; T < test_case; T++) {
			String input1 = sc.next();
			String input2 = sc.next();

			if (input1.charAt(0) == '-') {
				gubun++;
				input1 = input1.substring(1, input1.length());

			}
			if (input2.charAt(0) == '-') {
				gubun++;
				input2 = input2.substring(1, input2.length());
			}
			System.out.println("jaeyeon");

			if (gubun == 2) {
				System.out.println("- * - => ���ϱ� ���̹Ƿ� �Ű� �Ƚᵵ ��");
			}

			System.out.println("-- start --");

			if (input1.length() > input2.length()) {
				int size = input1.length() - input2.length();
				String bString = "";
				int sizevalue = 0;

				for (int i = 0; i < size; i++) {
					bString = bString + "0";
				}
				input2 = bString + input2;

				func(input1, input2);
			} else {
				int size = input2.length() - input1.length();
				String aString = "";
				int sizevalue = 0;

				for (int i = 0; i < size; i++) {
					aString = aString + "0";
				}
				input1 = aString + input1;

				func(input1, input2);
			}

		}
	}
}
