package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class t20181103 {
	static LinkedList<Integer> q;
	static int 맵y, 맵x, 최대횟수, 마차최대횟수;
	static int[][][] 맵;
	static int 은신처y;
	static int 은신처x;

	public static void main(String[] args) throws Exception {
		long start_time = System.currentTimeMillis();
		System.setIn(new FileInputStream(new File("화이트채플_input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= N; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			맵y = Integer.parseInt(st.nextToken());
			맵x = Integer.parseInt(st.nextToken());
			int 경찰수 = Integer.parseInt(st.nextToken());
			마차최대횟수 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int 범인y = Integer.parseInt(st.nextToken());
			int 범인x = Integer.parseInt(st.nextToken());
			은신처y = Integer.parseInt(st.nextToken());
			은신처x = Integer.parseInt(st.nextToken());
			맵 = new int[맵y + 맵x + 2][맵y + 2][맵x + 2];
			최대횟수 = 맵x + 맵y;
			for (int 이동횟수 = 0; 이동횟수 <= 최대횟수; 이동횟수++) {
				st = new StringTokenizer(br.readLine());
				int y = 0;
				int x = 0;
				for (int i = 1; i <= 경찰수; i++) {
					y = Integer.parseInt(st.nextToken());
					x = Integer.parseInt(st.nextToken());
					맵[이동횟수][y][x] = -1;
					맵[이동횟수][y - 1][x] = -1;
					맵[이동횟수][y + 1][x] = -1;
					맵[이동횟수][y][x - 1] = -1;
					맵[이동횟수][y][x + 1] = -1;
				}
			}
			q = new LinkedList<Integer>();
			int[] cur = new int[] { 0, 범인y, 범인x, 0 };
			q.add(cur[0] * 100000 + cur[1] * 1000 + cur[2] * 10 + cur[3]);
			while (!q.isEmpty()) {
				int qq = q.poll();
				cur[0] = qq / 100000;
				cur[1] = qq % 100000 / 1000;
				cur[2] = qq % 1000 / 10;
				cur[3] = qq % 10;
				if (cur[1] == 은신처y && cur[2] == 은신처x)
					break;
				int 다음횟수 = cur[0] + 1;
				if (다음횟수 <= 최대횟수) {
					add(다음횟수, cur[1] + 1, cur[2], cur[3]);
					add(다음횟수, cur[1] - 1, cur[2], cur[3]);
					add(다음횟수, cur[1], cur[2] + 1, cur[3]);
					add(다음횟수, cur[1], cur[2] - 1, cur[3]);
					int 다음마차횟수 = cur[3] + 1;
					if (다음마차횟수 <= 마차최대횟수) {
						add(다음횟수, cur[1] + 2, cur[2], 다음마차횟수);
						add(다음횟수, cur[1] - 2, cur[2], 다음마차횟수);
						add(다음횟수, cur[1], cur[2] + 2, 다음마차횟수);
						add(다음횟수, cur[1], cur[2] - 2, 다음마차횟수);
						add(다음횟수, cur[1], cur[2], 다음마차횟수);
						add(다음횟수, cur[1] + 1, cur[2] + 1, 다음마차횟수);
						add(다음횟수, cur[1] - 1, cur[2] + 1, 다음마차횟수);
						add(다음횟수, cur[1] + 1, cur[2] - 1, 다음마차횟수);
						add(다음횟수, cur[1] - 1, cur[2] - 1, 다음마차횟수);
					}
				}
			}
			if (cur[1] == 은신처y && cur[2] == 은신처x) {
				System.out.println("#" + testcase + " " + cur[0]);
			} else {
				System.out.println("#" + testcase + " -1");
			}
		}
		long end_time = System.currentTimeMillis();
		System.out.println("time : " + (end_time - start_time));
	}

	private static void add(int 이동횟수, int y, int x, int 마차횟수) {
		if (y >= 1 && y <= 맵y && x >= 1 && x <= 맵x && 맵[이동횟수][y][x] == 0
				&& 이동횟수 + Math.abs((y - 은신처y)) + Math.abs((x - 은신처x)) - (마차최대횟수 - 마차횟수) <= 최대횟수) {
			맵[이동횟수][y][x] = 1;
			q.add(이동횟수 * 100000 + y * 1000 + x * 10 + 마차횟수);
		}
	}
}