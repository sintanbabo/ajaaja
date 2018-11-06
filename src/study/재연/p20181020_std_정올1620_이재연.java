package study.재연;

import java.io.*;
import java.util.*;

public class p20181020_std_정올1620_이재연{

/*
input data
11-2222-3412-5432 2 4

1. �޴��� ��ȣ 111-2222-3412-5432 
2. ������ ���� 2
3. ���� ������ ��ġ 4
 
5432 �� �ڸ��� 2�� ���Ѵ�.
7654
	
 */
	
	static String S;
	static int p;
	static int m;
	static ArrayList<String> list = new ArrayList<String>();
	static String res;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181020//jo_1620.txt"));
		
		S = sc.next();
		p = sc.nextInt();
		m = sc.nextInt();
		
		
		// ������ list�� ���� ������ ũ�� ���ϱ� - ���� �ɰ���
		int cnt = 1;
		for(int i=0; i<S.length(); i++){
			if(S.charAt(i) == '-'){
				cnt++;
			}
		}
		
		// �� �ڸ����� 0�� ������ STRING ������
		String temp = "";
		
		// ������ ���̸� ����Ʈ�� ����
		for(int i=0; i<cnt; i++){
			// ������ ����
			if(cnt-i == 1){
				
				// ���� 5 �� ���ڴ��̴� 4�ڸ��� �Ѿ�� �ȵȴ�. 
				if(S.length() > 4){
					System.out.println("input error");
					break;
				}
				
				// ���� 6 ������ ũ�Ⱑ 4�ڸ��� �ȵ� ��쿡�� ��ü�� 4�ڸ��� �� ��, �տ� �� ��� �ڸ� ����ŭ 0�� ���δ�
				if(S.length() < 4){
					int strlength = 4 - S.length();
					for(int j=0; j<strlength; j++){
						temp = temp+"0";
					}
					list.add(temp+S);
				}else{
					list.add(S);
				}
			
			// �տ������� ����
			}else{
				// ���ڸ� ���� -������ String data
				String strData = S.substring(0, S.indexOf("-"));
				
				// ���� 5 �� ���ڴ��̴� 4�ڸ��� �Ѿ�� �ȵȴ�. 
				if(strData.length() > 4){
					System.out.println("input error");
					break;
				}
				
				// ���� 6 ������ ũ�Ⱑ 4�ڸ��� �ȵ� ��쿡�� ��ü�� 4�ڸ��� �� ��, �տ� �� ��� �ڸ� ����ŭ 0�� ���δ�
				if(strData.length() < 4){
					int strlength = 4 -  (strData.length());
					for(int j=0; j<strlength; j++){
						temp = temp+"0";
					}
					list.add(temp+strData);
				}else{
					list.add(strData);
				}
				S = S.substring(S.indexOf("-")+1);
			}
		}
	
		for(int i=1; i <= list.size(); i++){
			if(i == m){
				String str = list.get(i-1);
				int val = Integer.parseInt(str);
				System.out.println("val>"+val);
				int a = (val%10);		// 1�� �ڸ�
				int b = (val/10)%10;	// 10�� �ڸ�
				int c = (val/100)%10;	// 100�� �ڸ�
				int d = (val/1000);		// 1000�� �ڸ�
				
				
				a = a+p;
				b = b+p;
				c = c+p;
				d = d+p;
				
				// ���� 4 ���ϴ� ���ڴ��̿��� �� �ڸ��� ���ڸ� ���Ѵ�. �̶� ���� ���� 9�� ���� ��쿡�� �� �� ���� �ڸ� ������ ���Ѵ�
				// ���� 5  �� ���ڴ��̴� 4�ڸ��� �Ѿ�� �ȵȴ�.
				if(a > 9){
					a = 10-a;
				}
				if(b > 9){
					b = 10-b;
				}
				if(c > 9){
					c = 10-c;
				}
				if(d > 9){
					d = 10-d;
				}
				
				String res = String.valueOf(d)+String.valueOf(c)+String.valueOf(b)+String.valueOf(a);
				System.out.println("res>"+res);
			}
		}
	}

}
