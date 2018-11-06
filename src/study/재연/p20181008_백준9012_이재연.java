package study.재연;

import java.io.FileInputStream;
import java.util.Scanner;

public class p20181008_백준9012_이재연
{
	static int n;
	public static void main(String[] args)  throws Exception{
		Scanner sc = new Scanner(new FileInputStream("c://sw//baejoon//test_9012.txt"));
		
		 /* ?��?��?�� ?��?��?��*/
	    n = sc.nextInt();
	    String arr[] = new String [n];    
	    

	    
	    for(int i=0; i<n; i++){
	    	arr[i] = sc.next();
	    }	    
	    
	    for(int i=0; i< n; i++){
	    	int cnt1 = 0;
		    int cnt2 = 0;
		    
	    	if(arr[i].length() % 2 == 0){
	    		for(int j=0; j< arr[i].length(); j++){	    			
	    			if(arr[i].charAt(j) == '('){
	    				cnt1++;
	    			}
	    			if(arr[i].charAt(j) == ')'){
	    				cnt2++;
	    			}
	    		}
	    		if(cnt1 == cnt2){
    				System.out.println("YES");
    			}else{
    				System.out.println("NO");
    			}
	    	}else{
	    		System.out.println("NO");
	    	}
	    }	 
	}
}
