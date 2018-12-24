package 객체지향설계_예제.Lambda;

// 람다식 테스팅 
public class LambdaFormula {
	
	private int a, b;
	private int result = 0;
	
	public LambdaFormula(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@FunctionalInterface	
	interface Func {
		public void calc(int a, int b);
	}
	
	Func add = (int a, int b) -> { result = a + b; System.out.println(result); };
	Func sub = (int a, int b) -> { result = a - b; System.out.println(result); };
	Func multi = (int a, int b) -> { result = a * b; System.out.println(result); };

//	private 
	
}
