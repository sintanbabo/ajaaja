package study.두태;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p20181113_계산기_곱하기_전두태 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String First = sc.next();
		String Second = sc.next();
		
		ArrayList<Integer> FirstArr = fromString(First);
		ArrayList<Integer> SecondArr = fromString(Second);
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// "-" ���� Ȯ��
		boolean FirstMinus = false;
		boolean SecondMinus = false;
		for (int i = 0; i < FirstArr.size(); i++) {
			if (FirstArr.get(i) < 0 || FirstArr.get(i) > 9) {
				FirstArr.remove(i);
				FirstMinus = true;
			}
		}
		for (int i = 0; i < SecondArr.size(); i++) {
			if (SecondArr.get(i) < 0 || SecondArr.get(i) > 9) {
				SecondArr.remove(i);
				SecondMinus = true;
			}
		}
		
		// List �� ���� ���� �� ����
		result = ensureSize(result, FirstArr.size() + SecondArr.size() + 1);
		for (int i = 0; i < FirstArr.size(); i++) {
			for (int j = 0; j < SecondArr.size(); j++) {
				result.set(i + j, result.get(i + j) + FirstArr.get(i) * SecondArr.get(j));
			}
		}
		
		// �ڸ��� ���
		result = normalize(result);
		
		Collections.reverse(result);
		if ((FirstMinus == true && SecondMinus == false) || (FirstMinus == false && SecondMinus == true))
			System.out.print("-");
		
		for (int n : result)
			System.out.print(n);
	}
	
	public static ArrayList<Integer> fromString(String s) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i) - '0');
		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	public static ArrayList<Integer> ensureSize(ArrayList<Integer> list, int size) {
		list.ensureCapacity(size);
		while (list.size() < size) {
			list.add(0);
		}
		
		return list;
	}
	
	public static ArrayList<Integer> normalize(ArrayList<Integer> list) {
		list.add(0);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < 0) {
				int borrow = (Math.abs(list.get(i)) + 9) / 10;
				list.set(i + 1, list.get(i + 1) - borrow);
				list.set(i, list.get(i) + borrow * 10);
			} else {
				list.set(i + 1, list.get(i + 1) + list.get(i) / 10);
				list.set(i, list.get(i) % 10);
			}
		}
		
		while (list.get(list.size() - 1) == 0) {
			list.remove(list.size() - 1);
		}
		
		return list;
	}
}
