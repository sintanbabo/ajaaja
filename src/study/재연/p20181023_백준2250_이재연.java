package study.재연;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class p20181023_백준2250_이재연 {

	
/*
����
https://pasudo123.tistory.com/233
����뵵 �����...�Ф�

 */

	
	static int n;		// ����
	static Node tree[];
	static int top[];		// ��
	static int left[];	// ��
	static int right[];	// ��
	static int root = 0;
	static int nodeIndex = 1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("c://sw//20181031//bj_input2550.txt"));
		
		n = sc.nextInt();
		tree = new Node[n+1];
		top = new int[n+1];
		left = new int[n+1];
		right = new int[n+1];
		
		for(int i=0; i<=n; i++){
			tree[i] = new Node();
		}
		
		for(int i=0; i<n; i++){
			int root = sc.nextInt();
			int rootLeft = sc.nextInt();
			int rootRight = sc.nextInt();
			
			// ��Ʈ�� ã������ ���̴� �迭
			top[root] = top[root]+1;	
			if(rootLeft != -1){
				top[rootLeft] = top[rootLeft]+1;
			}
			
			if(rootRight != -1){
				top[rootRight] = top[rootRight]+1;
			}
			
			tree[root].left = rootLeft;
			tree[root].right = rootRight;
		}
		
		// ��Ʈ �˻�(��尡 �ѹ� ��Ÿ�� ���� ����)
		for(int i=1; i<=n; i++){
			if(top[i]==1){
				root = i;
			}
		}
		
		
		Arrays.fill(left, Integer.MAX_VALUE);
		Arrays.fill(right, Integer.MIN_VALUE);
		
		// ��Ʈ Ž��
		dfs(root, 1);
		
		// �ִ� ����
		int res = right[1]-left[1]+1;
		int level = 1;
		for(int i=2; i<=n; i++){
			int temp = right[i]-left[i]+1;
			
			if(temp>res){
				res = temp;
				level = i;
			}
		}
		System.out.println(level+" "+res);
	}
	
	public static void dfs(int s, int height){
		// ���� ���� Ʈ��
		if(tree[s].left != -1){
			dfs(tree[s].left, height+1);
		}
		
		// �ش� ���̿��� ���� ���� ���, ���� ����� x�� �� ������Ʈ
		left[height] = Math.min(left[height], nodeIndex);
		right[height] = Math.max(right[height], nodeIndex);
		
		// ���� ȸ�� x�� �� +1
		nodeIndex = nodeIndex+1;
		
		if(tree[s].right != -1){
			dfs(tree[s].right, height+1);
		}
	}
}

class Node{
	int left;
	int right;
}
