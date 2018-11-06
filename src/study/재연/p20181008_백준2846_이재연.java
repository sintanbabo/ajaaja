package study.재연;

import java.io.FileInputStream;
import java.util.Scanner;

public class p20181008_백준2846_이재연
{
	static int n;
	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//baejoon//test_2846.txt"));
		
		 /* ?��?��?�� ?��?��?��*/
	    n = sc.nextInt();
	    int arr[] = new int [n];    
	    
	    for(int i=0; i<n; i++){
	    	arr[i] = sc.nextInt();
	    }
	    
	    int max = 0; // 최�?�?
	    
	    for(int i=0; i<n; i++){
		    boolean flag = true;	// ?��?�� ?���? 차순?�� ???�� 구분?��

	    	for(int j=i+1; j<n-1; j++){
	    		if(flag){
		    		if(arr[i] <  arr[j]){
		    			/*
		    			System.out.println("arr["+i+"]>"+arr[i]);
	    				System.out.println("arr["+j+"]>"+arr[j]);
	    				System.out.println(arr[j]-arr[i]);
		    			*/
	    				
	    				max = Math.max(max, arr[j]-arr[i]);			
	    				if(arr[j+1] <= arr[j]){
	    					break;
	    				}
		    		}else{
		    			flag = false;
		    		}
	    		}
	    	}
	    }
	    
	    System.out.println("max > " + max);
	}
}
