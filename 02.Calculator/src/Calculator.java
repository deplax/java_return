//
//public class Calculator {
//	static int add(int a, int b)
//	{
//		return a + b;
//	}
//	static int odd(int a, int b)
//	{
//		return a - b;
//	}
//	static int mul(int a, int b)
//	{
//		return a * b;
//	}
//	static double div(int a, int b)
//	{
//		return (double)a / b;
//	}
//	
//	public static void main(String[] args)
//	{
//		System.out.println("덧셈 : " + Calculator.add(1, 2));
//		System.out.println("뺄셈 : " + Calculator.odd(1, 2));
//		System.out.println("곱셈 : " + Calculator.mul(1, 2));
//		System.out.println("나눗셈 : " + Calculator.div(1, 2));
//	}
//}

/////////////////////////////////////////////////////////////////////

//class Calculator{
//	int add(int a, int b)
//	{
//		return a + b;
//	}
//	int odd(int a, int b)
//	{
//		return a - b;
//	}
//	int mul(int a, int b)
//	{
//		return a * b;
//	}
//	double div(int a, int b)
//	{
//		return (double)a / b;
//	}
//	
//	public static void main(String[] args)
//	{
//		Calculator cal = new Calculator();
//		System.out.println("덧셈 : " + cal.add(1, 2));
//		System.out.println("뺄셈 : " + cal.odd(1, 2));
//		System.out.println("곱셈 : " + cal.mul(1, 2));
//		System.out.println("나눗셈 : " + cal.div(1, 2));
//	}
//}

/////////////////////////////////////////////////////////////////////

//class Calculator{
//	int num;
//	
//	Calculator(int num){
//		this.num = num;
//	}
//	
//	int add(int operand){
//		return num + operand;
//	}
//	int odd(int operand){
//		return num - operand;
//	}
//	int mul(int operand){
//		return num * operand;
//	}
//	double div(int operand){
//		return (double)num / operand;
//	}
//	
//	public static void main(String[] args)
//	{
//		Calculator cal = new Calculator(3);
//		System.out.println("덧셈 : " + cal.add(4));
//		System.out.println("뺄셈 : " + cal.odd(4));
//		System.out.println("곱셈 : " + cal.mul(4));
//		System.out.println("나눗 셈 : " + cal.div(4));
//	}
//}

class Calculator{
	int num;
	
	Calculator(int num){
		this.num = num;
	}
	
	Calculator add(int operand){
		Calculator cal = new Calculator(num + operand);
		return cal;
	}
	Calculator odd(int operand){
		Calculator cal = new Calculator(num - operand);
		return cal;
	}
	int mul(int operand){
		return num * operand;
	}
	double div(int operand){
		return (double)num / operand;
	}
	
	void print()
	{
		System.out.println(num);
	}
	
	public static void main(String[] args)
	{
		Calculator cal = new Calculator(3);
		//System.out.println("덧셈 : " + cal.add(4));
		//System.out.println("뺄셈 : " + cal.odd(4));
		System.out.println("곱셈 : " + cal.mul(4));
		System.out.println("나눗 셈 : " + cal.div(4));
		cal.add(3).print();
		cal.add(4).odd(2).print();
	}
}

//Calculator add(int operand){
//	Calculator cal = new Calculator(num);
//	cal.num += operand;
//	return cal;
//}