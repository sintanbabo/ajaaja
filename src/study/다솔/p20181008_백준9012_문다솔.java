package study.다솔;

import java.util.Scanner;

public class p20181008_백준9012_문다솔
{
	static String PS;
	static char P[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case =1; test_case <=T;test_case++ ) {
			
		PS = sc.next();
		
		P = new char[50];
		
		for(int i=0; i<PS.length();i++) {
			
			P[i] = PS.charAt(i);
		}
		
		int left=  0;
		int right = 0;
		int No =0;
		
		for(int i=0; i<PS.length();i++) {
			
				if(P[i] == '(') {
					
					left += 1;
		
				}
				
				
				else if(P[i]== ')') {
					
					right += 1;
					
					if(left < right) {
						
						No =1;
						break;
						}
				
					}
				
				
				
			if(P[0] == ')' || P[PS.length()-1] == '(') {
					
					No = 1;
									
				}
			
			}

		if(left != 0 && right != 0 && left == right) {
			System.out.println("YES");
		}else{
			if(No == 1 || left != right)
			System.out.println("NO");
			}
		
		}
	}
}
