package study.재연;

import java.io.*;
import java.util.*;
public class multiplication {
	
	static int test_case;
	static int a[]; 	// input1 배열
	static int b[]; 	// input2 배열
	static int gubun=0;
	static boolean flag = true;
	static List dataList = new ArrayList<>();
	static List addDataList = new ArrayList<>();
	static String res = "";
	static String finalRes = "";
	
	// 출력 함수
	public static void print(){
		System.out.println("--- 마지막---");
		
		if(!flag){
			System.out.print("-");
		}
		
		char[] arr = new char[res.length()];
		for(int i=0; i<arr.length; i++){
			arr[i] = res.charAt(i);
		}
		
		// 앞자리에 혹시나 0이 올 수 있어서
		boolean zeroFlag = false;
		for(int i=0; i<arr.length; i++){
			if(arr[i]!='0'){
				zeroFlag = true;
			}
			if(zeroFlag){
				System.out.print(arr[i]);
			}
		}
	}

	public static void addfunc(String data, int no){
		if(no == 0){
			res = res + data;
		}else{
			int arr1[] = new int[data.length()];
			int arr2[] = new int[data.length()];
			int resData [] = new int[data.length()];
			
			for(int i=0; i<arr1.length; i++){
				arr1[i] = res.charAt(i)-48;
				arr2[i] = data.charAt(i)-48;
			}
			
			
			for(int i=arr1.length-1 ; i>=0; i--){
				if(arr1[i]+arr2[i] > 9){
					resData[i] = (arr1[i]+arr2[i])-10;
					arr1[i-1]++;
				}else{
					resData[i] = arr1[i]+arr2[i];
				}
			}
			
			res = "";
			for(int i=0; i<resData.length; i++){
				res = res+resData[i];
			}
			
		}
		
		System.out.println(res);
		
	}
	
	// 더하기 연산
	public static void add(){
		for(int i=0; i<addDataList.size(); i++){
			System.out.println(addDataList.get(i));
			
			String data =(String)addDataList.get(i);
			addfunc(data, i);
		}
		print();
	}
	
	
	// 곱한값들의 자릿수 함수
	public static void jarisu(){
		int max = 0;
		for(int i=0; i<dataList.size(); i++){
			String data = (String) dataList.get(i);
			if(data.length() > max){
				max = data.length();
			}
		}
		
		
		for(int i=0; i<dataList.size(); i++){
			String aa = "";
			String data = (String) dataList.get(i);
			if(data.length() < max){
				String zero = "";
				for(int j=0; j<max-data.length(); j++){
					zero = zero+"0";
					aa = zero+data;
				}
				addDataList.add(aa);
			}else if(data.length() == max){
				addDataList.add(data);
			}
		}
		
		add();
	}
	
	public static void multi(char arr1[],int b, String zero){
		int res = 0;
		int up = 0;
		int mod = 0;
		List list = new ArrayList<>();
		for(int i=arr1.length-1; i>=0; i--){
			int a = arr1[i]-48;
			res = a*b;
			
			if(i == arr1.length-1){
				if(res > 9){
					up = res/10;
					mod = res%10;
				}else{
					up = 0;
					mod = res%10;
				}
				list.add(mod);
			}else{
				int upup=0;
				if(res > 9){
					mod = res%10+up;
					up = res/10;
					
					if(mod > 9){
						mod = mod%10;
						upup = mod / 10;
						up = up+upup;
					}
				}else{
					mod = res%10+up;
					up = 0;
					if(mod > 9){
						upup = mod / 10;
						mod = mod%10;
						up = up+upup;
					}
				}
				list.add(mod);
			}
			
		}
		String listData = "";
		for(int i=list.size()-1; i>=0; i--){
			listData = listData+list.get(i);
		}
		listData = listData+zero;
		dataList.add(listData);
		
	}
	

	public static void func1(String a, String b){
//		System.out.println(a);
//		System.out.println(b);
		
		char arr1[] = new char[a.length()];
		char arr2[] = new char[a.length()];
		
		for(int i=0; i<arr1.length; i++){
			arr1[i] = a.charAt(i);
		}
		
		String zero = "";
		for(int i=a.length()-1; i >=0; i--){
			int bdata = b.charAt(i)-48;
			
			// 곱하기 연산
			multi(arr1, bdata, zero);
			zero = zero+"0";
		}
		
		// 곱한 후 각각의 리시트에 자릿 수 맞춰주기 한번 더
		jarisu();
	}
		
	
	public static void main(String[] args) throws Exception{
		// 1
		// -115 -117
		Scanner sc = new Scanner(new FileInputStream("c://sw//adPlzeFinal//multiplication_20181112.txt"));
		int test_case = sc.nextInt();
		
		//Scanner sc = new Scanner(System.in);
		//int test_case = 1;
		
		for(int T=0; T<test_case; T++){
			String input1 = sc.next();
			String input2 = sc.next();
			
			
			
			// 앞자리 - 부호가 있는지 검사 start
			if(input1.charAt(0)=='-'){
				gubun++;
				input1 = input1.substring(1,input1.length());
				
			}
			if(input2.charAt(0)=='-'){
				gubun++;
				input2 = input2.substring(1,input2.length());
			}
			
			if(gubun==1){
				flag = false;	// 두 수중 하나가- 일경우 flag false값 유지
			}
			
			if(input1 =="0" || input2=="0"){
				System.out.println(0);
			}else{

				// 각 수의 자리수 마춰주기 시작
				if(input1.length() > input2.length()){
					int size = input1.length() - input2.length();
					String bString = "";
					int sizevalue = 0;
					
					for(int i=0; i<size; i++){
						bString = bString+"0";
					}
					input2 =bString+input2;
					
					func1(input1, input2);
				}else{
					int size = input2.length() - input1.length();
					String aString = "";
					int sizevalue = 0;
					
					for(int i=0; i<size; i++){
						aString = aString+"0";
					}
					input1 =aString+input1;
					
					func1(input1, input2);
				}
			}
			
		}
	}
}
