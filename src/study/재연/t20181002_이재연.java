package study.재연;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class t20181002_이재연 {
	public static int[] parent = new int[1000001];
	
	static int test_case;
	static int a[] = new int[101]; 	// input data
	static int q[] = new int[101]; 	// ���� �� ��
	static int rem;					// ������
	
	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://input.txt"));
		
		test_case = sc.nextInt();
		
/** test_case
 *		4
		12345 2
		4401 3
		34581583 4
		101485 17
		1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890 2	
 */
		
		System.out.println("--- input data start----");
		System.out.println(12345 / 2+" / " + 12345 % 2);
		System.out.println(4401 / 3+" / " + 4401 % 3);
		System.out.println(34581583 / 4+" / " + 34581583 % 4);
		System.out.println(101485 / 17+" / " + 101485 % 17);
		System.out.println("--- input data end----");
		
		for(int T=0; T<test_case; T++){
			String data = sc.next();
			
			for(int i=0; i<data.length(); i++){
				a[i] = data.charAt(i)-48;
			}
			
			// ���� ��
			int b = sc.nextInt();
			boolean flag = false;
			int str1 =0;  // �� �� ���� ��
			int str2 = 0; // �� �� ���� ��
			int str3 = 0; // �� + �� �� (ex 1+2 = 12)
						
			for(int i=0; i<data.length(); i++){
				if(flag){
					str2 = a[i];
					String number = String.valueOf(str1)+String.valueOf(str2);
					str3 = Integer.parseInt(number);
					a[i] = str3;
					flag = false;
				}
				
				if(a[i] < b){					
					q[i] = 0;
					rem = a[i];
					str1 = rem;
					flag = true;
				}else{
					if(a[i] % b == 0){
						q[i] = a[i] / b;
						rem = a[i] % b;
					}else{
						q[i] = a[i] / b;
						rem = a[i] % b;
						str1 = rem;
						flag = true;
					}
				}
			}
			
			
			System.out.println();
			
			
			// ���� ���� ��
			for(int i=0; i< data.length(); i++){
				System.out.print(q[i]);
			}
			System.out.print(" "+rem);
			System.out.println();
			
			
			// Ʋ�� ���� ����
			boolean bol = false;
			
			for(int i=0; i< data.length(); i++){
				if(q[i] !=0){
					bol = true;
				}
				
				if(bol == true){					
					System.out.print(q[i]);
					
				}
			}
			System.out.print(" / " + rem);
			System.out.println();
			System.out.println();
			
		}
	}
}