package study.명윤;

import java.util.Scanner;
import java.io.FileInputStream;

public class p20181008_백준2846_고명윤
{
	static int AnswerN;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/baek2846.txt"));
		Scanner sc = new Scanner(System.in);
		int intSize = sc.nextInt();
		int intTempMaxHeight = 0;
		int [] arrintHeight = new int[intSize+1];
		String strDownFlag= "false";
		
		for(int i=0; i<intSize ; i++) 
		{
			int intHeight = sc.nextInt();
			arrintHeight[i] =intHeight;
		}
	
		for(int j=0; j <intSize ; j++)
		{				
			if(arrintHeight[j]<arrintHeight[j+1] && strDownFlag=="false")
			{
				intTempMaxHeight += arrintHeight[j+1] - arrintHeight[j];
			}
			else
			{ 
				j = j +1;
			   strDownFlag ="true";
			}
			
			if(intTempMaxHeight > AnswerN && strDownFlag=="true")
			{
				AnswerN = intTempMaxHeight;
				intTempMaxHeight=0;
				strDownFlag ="false";
			}
		}

		System.out.println(AnswerN);
	}
}
