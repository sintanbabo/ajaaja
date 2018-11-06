package study.재연;

import java.io.*;
import java.util.*;

public class p20181019_std_백준9663_이재연
{

	// https://coding-start.tistory.com/18 ����
	
	static int n;  
	// input data n=8 -> output data : 92
	// input data n=4 -> output data : 2
	static int arr[];
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		n = 4;
		// �� �� �Ǵ� ���� ���� �Ѱ��� ���� �ؾ� ��. 2���� �迭 �ʿ� ����.
		arr = new int[n];
		dfs(arr, n, 0);
		
		System.out.println("cnt>"+cnt);
	}
	
	public static void dfs(int[] arr, int x, int y) {
		/* N-QUEEN �� ���� �� ������ �� �� �κ��� �˻��� �ʿ� ����.
		 * ���� Ư����, i1,j1 ���� Ž���� �ʿ����
		 * �˻� ���� : �ڽ��� ���� �¿쿡 �ذ� ������ �ȵ�.
		*/
		
		// �迭�� ���� ��, x=����, y=��
		for(int i=0; i<n; i++) {
			// (0,0) ~ (0,3)�� ���� �������� Ž��
			// ���۰��� (0)
			arr[y] = i;
			if(confrim(arr, x, y)) {
				if(y==x-1) {
					cnt++;
				}else {
					dfs(arr, x, y+1);
				}
			}
		}
	}
	
	public static boolean confrim(int[] arr, int x, int y) {
		for(int i=0; i<y; i++) {
			// ��ȭ �¿� �밢�� ������ ������ ����
			if(arr[y] == arr[i] || y-i==Math.abs(arr[y]-arr[i])) {
				return false;
			}	
		}
System.out.println("arr[y]>"+arr[y]+" / y>"+y);
		return true;
	}
/*
1)
arr[y]>1 / y>0
arr[y]>3 / y>1
arr[y]>0 / y>2
arr[y]>2 / y>3	

2)
arr[y]>2 / y>0
arr[y]>0 / y>1
arr[y]>3 / y>2
arr[y]>1 / y>3	

1) 0���� 0���� ����
o -> o    -> o
     xxo     xxxx     0�� 0 �ƿ�
     
2) 0���� 1���� ����
xo -> xo       -> xo         -> xo
      xxxo        xxxo          xxxo
                  o             o
                                xxo  cnt ++



*/
	

}
