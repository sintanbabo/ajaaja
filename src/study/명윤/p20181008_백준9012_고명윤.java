package study.명윤;

import java.util.Scanner;
import java.io.FileInputStream;

public class p20181008_백준9012_고명윤
{
	static String strAnswer;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/baek9012.txt"));
		Scanner sc = new Scanner(System.in);
		int intSize = sc.nextInt();
		String [] arrstrParenthesis = new String[intSize+1];
		
		for(int i=0; i<intSize ; i++) 
		{
			String strParenthesis = sc.next();
			arrstrParenthesis[i] =strParenthesis;
		}
	
		for(int i=0; i<intSize ; i++) 
		{	
			int intOpenCnt = 0;
			int intCloseCnt = 0;
			
			for(int j=0 ; j <arrstrParenthesis[i].length(); j++)
			{
				if(arrstrParenthesis[i].charAt(j) =='(') 
				{
					intOpenCnt+=1;
				}
				
				if(arrstrParenthesis[i].charAt(j) ==')') 
				{
					intCloseCnt+=1;
				}
			}
			
			if(intOpenCnt !=intCloseCnt )
			{
				strAnswer= "NO";
			}
			else
			{
				strAnswer= "YES";
			}
			System.out.println(strAnswer);
		}	
	}
}
