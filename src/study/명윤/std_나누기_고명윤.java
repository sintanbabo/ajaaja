package study.명윤;

import java.io.FileInputStream;
import java.util.Scanner;

public class std_나누기_고명윤{
	
	static int test_case;
	static int a[] = new int[101]; 	// input data
	static int q[] = new int[101]; 	// ���� �� ��
	static int rem;					// ������
	
	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("res/sample_input3.txt"));
		test_case = sc.nextInt();
		
/** test_case
 *		4
		12345 2
		4401 3
		34581583 4
		101485 17
		1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890 2	
 */	
		for(int T=0; T<test_case; T++)
		{
			String data = sc.next();
			for(int i=0; i<data.length(); i++){
				a[i] = data.charAt(i)-48;
			}
			
			// ���� ��
			int b = sc.nextInt();
			String strA ="";				
			String strSumA ="";
		
			for(int i=0; i<data.length(); i++)
			{
				if(strSumA !="")
				{
					strSumA = strSumA + String.valueOf(a[i]);
					a[i]= Integer.parseInt(strSumA);
				}
				
				  if(a[i] > b)
				  {
					  q[i] = a[i]/b;
					  rem = a[i]%b;
				  }
				  else if(a[i]==b)
				  {
					  q[i] = a[i]/b;
					  rem = 0;
				  }
				  else
				  {  
					  q[i] = 0;
					  rem = a[i];
				  }
				  
				  if(i+1 ==data.length())
				  {
					  break;
				  }
				  else
				  {
					  strSumA = String.valueOf(rem);  
				  }  
			}
			
			for(int i = 0 ; i <data.length() ; i++)
			{
				strA = strA +String.valueOf(a[i]);			
			}
		
			System.out.print("#"+T+" ");
			for(int i=0; i< data.length(); i++){
				System.out.print(q[i]);
			}
			System.out.println(" / " + rem);		
		}
	}
}