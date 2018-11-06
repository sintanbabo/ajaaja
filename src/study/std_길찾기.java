package study;

public class std_길찾기
{
	static boolean result = false;
	
	public static void go(int[][] road, int n, int x, int y, int[][] visited, String s)
	{
		if (x== n-1 && y == n-1)
		{
			System.out.println(s);
			result = true;
			return;
		}
		else {
			// ��
			if (y+1 < n && visited[x][y+1] == 0 && road[x][y+1] == 1)
			{
				visited[x][y+1] = 1;
				s = s + "[" + x + "," + (y+1) + "]";
				
				go(road,n,x,y+1,visited,s);
				
				s = s.substring(0, s.length()-5);
				visited[x][y+1] = 0;
			}
			// ��
			if (x+1 < n && visited[x+1][y] == 0 && road[x+1][y] == 1)
			{
				visited[x+1][y] = 1;
				s = s + "[" + (x+1) + "," + (y) + "]";
				
				go(road,n,x+1,y,visited,s);
				
				s = s.substring(0, s.length()-5);
				visited[x+1][y] = 0;
			}
		}
	}

	public static void main(String args[])
	{
		int visited[][] = new int[5][5];
		String s = "";
		int[][] road = {
			{1,1,1,1,1},
			{1,0,0,0,0},
			{1,1,1,1,1},
			{1,1,0,0,1},
			{0,0,0,0,1}
		};

		s = "[0,0]";
		go(road,5,0,0,visited,s);
		if ( !result ) System.out.println("0");
	}
}
