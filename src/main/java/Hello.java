package main.java;

import java.util.Scanner;

public class Hello {
	 
	static int totalSpaces =  29;
	public static void main(String[] args) {
		
		int x;
		
		Scanner scanner = new Scanner(System. in);
		//x= scanner.nextInt();
		//String hello = x>1 ? "i am greater than one ": "i am less the one";
		//System.out.println(hello);

		System.out.println(addSpaces("sourabh")+" : ");
		System.out.println(addSpaces("run")+" : ");
	}
	
	public static String addSpaces(String str){
		
		
		int stringLength = str.isEmpty() || str == null ? 0 : str.length();
		int spaces = 17 - stringLength;
		if(stringLength > 0 && spaces > 0){
			str+=" ";
			return addSpaces(str);
		}
		return str;
	}

}

