package main.java;

public class Pattern {

	public static void main(String[] args) {
	
		callMe("******");

	}
	
	
	static void callMe(String pattern){
		for(int i = 0; i < pattern.length(); i++ )
		{System.out.println(pattern.substring(0,pattern.length()-i));
		System.out.println(pattern.substring(pattern.length()-i));}
		
	}

}
