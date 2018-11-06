package study.재연;

import java.io.FileInputStream;
import java.util.Scanner;

public class t20181027_이재연
{
	static int test_case;
	static int a[] = new int[101]; 	// input data1
	static int b[] = new int[101]; 	// input data2
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181029//ad_minus.txt"));
		
		test_case = sc.nextInt();

/*
4
123 122
122 123
-123 999
999 -123
-999 -123
 */
		for(int t=0; t<test_case; t++){
			String size1 = sc.next();
			String size2 = sc.next();
			System.out.println(size1);
			System.out.println(size2);
			
			// �տ� - üũ ���� start
			int size1Flag = 0;
			if(size1.substring(0, 1).equals("-")){
				size1 = size1.substring(1,size1.length());
				size1Flag = 1;
			}
			
			int size2Falg = 0;
			if(size2.substring(0, 1).equals("-")){
				size2 = size2.substring(1,size2.length());
				size2Falg = 1;
			}
			// �տ� - üũ ���� ���� end
			
			
			// ���� ���ڰ� -�� ��� -- => +�� �Ǵϱ�  flag�� 1�϶��� add �Լ� ȣ��
			if(size2Falg !=1){
				minus(size1, size2, size1Flag, size2Falg);
			}else{
				// ���ڸ��� 1�� ��쿡�� �ڿ��� -- =>+ �� �ǵ� �� �ڸ����� ���ڸ� �������
				if(size1Flag == 1){
					minus(size1, size2, size1Flag, size2Falg);
				}else{
					add(size1, size2, size1Flag, size2Falg);
				}
			}
			
			
		}	

	}
	
	public static void add(String size1, String size2, int size1Flag, int size2Flag){
		
		for(int i=0; i<size1.length(); i++){
			a[i] = (int)size1.charAt(i)-48;
		}
		
		for(int i=0; i<size2.length(); i++){
			b[i] = (int)size2.charAt(i)-48;
		}
		
		if(size1.length() > size2.length()){
			int cnt = 0;
			int modb[] = new int [size1.length()];	// �ڸ� �� ū �ʿ� ������ �迭
			
			/* ���� ��  modb�� ū �ڸ����� �°� ������.. ex) 23 -> 023 */
			for(int i=0; i<size1.length(); i++){
				if(size1.length() > size2.length()+i){
					modb[i] = 0;
					cnt++;
				}else{
					modb[i] = b[i-cnt]; 
				}
			}
			
			/* modb + a ex) 987+023 */
			for(int i=0; i<size1.length(); i++){
				modb[i] = a[i]+modb[i];
			}
			
			/* modb �ڸ� �� ����*/
			for(int i=modb.length-1; i>0; i--){
				if(modb[i] >9){						
					modb[i] = (modb[i])-10;
					modb[i-1]++;
				}
			}
			/* ��� */
			for(int i=0; i<modb.length; i++){
				System.out.print(modb[i]);
			}
			
		}else{
			int cnt = 0;
			int modb[] = new int [size2.length()];
			for(int i=0; i<size2.length(); i++){
				if(size2.length() > size1.length()+i){
					modb[i] = 0;
					cnt++;
				}else{
					modb[i] = a[i-cnt]; 
				}
			}
			
			for(int i=0; i<size2.length(); i++){
				modb[i] = b[i]+modb[i];
			}
			
			for(int i=modb.length-1; i>0; i--){
				if(modb[i] >9){						
					modb[i] = (modb[i])-10;
					modb[i-1]++;
				}
			}
			
			for(int i=0; i<modb.length; i++){
				System.out.print(modb[i]);
			}
		}
	}

	
	public static void minus(String size1, String size2, int size1Flag, int size2Flag){
		
		for(int i=0; i<size1.length(); i++){
			a[i] = (int)size1.charAt(i)-48;
		}
		
		for(int i=0; i<size2.length(); i++){
			b[i] = (int)size2.charAt(i)-48;
		}
		
		// ���� ����
		if(size1.length() < size2.length()){
			int size = size2.length()-size1.length();
			
			String zeroSum = "";
			String cnt = "0";
			
			for(int i=0; i<size; i++){
				zeroSum = zeroSum + cnt;
			}
			
			size1 = String.format(zeroSum+"%s",size1);
	
			for(int i=0; i<size1.length(); i++){
				a[i] = (int)size1.charAt(i)-48;
			}
			
			for(int i=size2.length()-1; i>=0; i--){
				if((b[i]-a[i])<0){
					b[i] = (b[i]+10) -(a[i]);
					b[i-1]--;
				}else{
					b[i] = (b[i]-a[i]);
				}
			
			}
			
			for(int i=0; i<size2.length(); i++){
				System.out.print(b[i]);
			}
			
			System.out.println();
			
			
		}else{
			
			// ���ڿ��� ���Ƶ� ū �� ã�Ƽ� ġȯ
//			if(Integer.parseInt(size1) < Integer.parseInt(size2)){
//				String temp = "";
//				temp = size1;
//				size1 = size2;
//				size2 = temp;
//				
//			}
			
			
			int intVal = Integer.parseInt(size2);
			String val = String.format("%0"+size1.length()+"d",intVal);
			
			for(int i=0; i<val.length(); i++){
				b[i] = (int)val.charAt(i)-48;
			}
	
			
			for(int i=size1.length()-1; i>=0; i--){
				if((a[i]- b[i]) < 0){
					a[i] = (a[i]+10) - (b[i]);
					
				}else{
					a[i] = (a[i]-b[i]);
				}
			
			}
			
			boolean temp = false;
			String output = "";
			for(int i=0; i<size1.length(); i++){
				if(a[i] != 0){
					temp =true; 
				}
				if(temp){
					output = output+a[i];
				}
			}
			if(Integer.parseInt(size1) < Integer.parseInt(size2)){
				output = "-"+output;
			}
			
			if(size1Flag == 1){
				output = "-"+output;
			}
			
			System.out.println("��>"+output);
			System.out.println();
			output = "";
			
		}		
	}
	
	

	

}