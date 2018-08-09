package lambda;

public class LambdaImp {

	public static void main(String[] args) {
		MyLambda mylambadaFuntion = () -> System.out.println("Hello World!");
		MyAdd  addFunction =  (int a, int b) -> a + b; 
		StringLengthLambda stringlen = s -> s.length();
		StringLengthLambda opration = (p) -> p.charAt(0);
		/*System.out.println(stringlen.getLength("HelloLambda!"));
		System.out.println(opration.getLength("aelloLamba!"));
		System.out.println("helloLemda".charAt(0));*/
		System.out.print(getLength(s-> s.length()));
	}

	interface MyLambda {
		void foo();
	}
	interface MyAdd {
		int foo(int x, int y);
	}
	public static int getLength(StringLengthLambda s) {
		return s.getLength("helloWorld");
		
	}
}
