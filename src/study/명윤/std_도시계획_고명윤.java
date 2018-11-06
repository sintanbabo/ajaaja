package study.명윤;

import java.util.Scanner;
import java.io.FileInputStream;

class std_도시계획_고명윤
{
	static int N;
	static int AnswerN;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		/*
		3
		G G G
		G B G
		G G G
		5
		G G G G G
		G B B G G
		G B B B G
		G B B B G
		G G G G G
		8
		G G G G G G G G
		G G G B G G G G
		G G G B B B G G
		G B B B B B B G
		G G G B B B G G
		G G G B G G G G
		G G G G G B G G
		G G G G G G G G
		*/
		for (int test_case = 1; test_case <= 3; test_case++) {
			AnswerN = 0;
			N = sc.nextInt();

			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}

			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					if (map[i][j] == 'B') 
					{
						if(map[i+1][j]=='G'||map[i-1][j]=='G'||map[i][j+1]=='G'||map[i][j-1]=='G')
						{
							AnswerN +=1;
						}
						else
						{
							for(int k=0; k<N ; k++)
							{
								if(map[k][j]=='B')
								{
									AnswerN +=1;
								}
								if(map[i][k]=='B')
								{
									AnswerN +=1;
								}
							}
							AnswerN -=1;
						}
						
					} 
				}
			}

			System.out.println("#" + test_case + " " + AnswerN);
		}
	}
}
