package study.재연;

import java.io.*;
import java.util.*;

public class std20181114_bj1918 {
	// http://mygumi.tistory.com/181  참조

	static Stack<Character> stack = new Stack<Character>();
	static StringBuilder sb = new StringBuilder();
	static String input; 
	public static void main(String[] args) throws Exception{
	//	Scanner sc = new Scanner(new FileInputStream("c://sw//adPlzeFinal//bj1918.txt"));
		
		Scanner sc = new Scanner(System.in);
		// (A+(B*C))-(D/E)
		
		input = sc.next();
		char[] s = input.toCharArray();
		int len = s.length;	
		
		for(int i=0; i < len; i++){
			System.out.print(s[i]);
		}System.out.println();
		System.out.println("-- start --");
		
		for (int i = 0; i < len; i++) {
			int p = priority(s[i]);
			char ch = s[i];
//System.out.println("p>"+p+" / ch>"+ch);
//System.out.println("string>"+sb.toString());
			switch (ch) {
				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && priority(stack.peek()) >= p) {
						sb.append(stack.pop());
					}
					stack.push(ch);
					break;
				case '(':
					stack.push(ch);
					break;
				case ')':
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
					break;
				default:
				sb.append(ch);
			}
		}
	 
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
	 
	public static int priority(char ch) {
		switch (ch) {
			case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		}
		return -1;
	}
}
