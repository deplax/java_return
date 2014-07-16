//import java.util.*;
//
//public class Calc {
//
//	public String[] input()
//	{
//		
//		return null;
//	}
//	
//	public static void main(String[] args) {
//
//		Scanner input = new Scanner(System.in);
//		System.out.println("input : ");
//		String str = input.next();
//		
//		//System.out.println(str);
//		
//		//String str = "45\n32,44";
//		
//		String[] s =  str.split(",|:");
//		
//		int result = 0;
//		for(int i = 0; i < s.length; i++)
//		{
//			result += Integer.parseInt(s[i]);
//		}
//		
//		System.out.println(result);
//	}
//
//}
///////////////////////////////////////////////////////////////////

//public class Calc {
//
//	int add(String text){
//		
//		if (text.isEmpty() == true){
//			return 0;
//		}
//		
//		String[] numbers = text.split(",|\n");		
//		int[] values = toInt(numbers);
//		return sum(values);
//	}
//	
//	int[] toInt(String[] numbers){
//		int[] values = new int[numbers.length];
//		for (int i = 0; i < numbers.length; i++){
//			values[i] = Integer.parseInt((numbers[i]));
//		}
//		return values;
//	}
//	
//	int sum(int[] numbers){
//		int sum = 0;
//		for (int i = 0; i < numbers.length; i++){
//			sum += numbers[i];
//		}
//		return sum;
//	}
//	
//	public static void main(String[] args) {
//		Calc cal = new Calc();
//		System.out.println("value is empty : " + cal.add(""));
//		System.out.println("value is number on  : " + cal.add("1"));
//		System.out.println("value is number two  : " + cal.add("1,2"));
//		System.out.println("value is number three  : " + cal.add("1,2,3"));
//		System.out.println("value is number four  : " + cal.add("1,2,3,4"));
//		System.out.println("value is number four  : " + cal.add("1\n2,3,4"));
//		System.out.println("value is number four  : " + cal.add("1\n2\n3"));
//	}
//
//}
///////////////////////////////////////////////////////////////////

public class Calc{
	static int add(String text){
		if (text.isEmpty()){
			return 0;
		}
		
		String[] values = split(text);
		int[] numbers = toInt(values);
		return sum(numbers);
	}
	
	static int sum(int[] numbers){
		int sum = 0;
		for (int i = 0; i < numbers.length; i++){
			sum += numbers[i];
		}
		return sum;
	}
	static int[] toInt(String[] values){
		int[] numbers = new int[values.length];
		for (int i = 0; i < values.length; i++){
			numbers[i] = Integer.parseInt(values[i]);
		}
		return numbers;
	}
	static String[] split(String text){
		return text.split(",|\n");
	}
	public static void main(String[] args){
		String[] values = split("1,3");
		for (int i = 0; i < values.length; i++){
			System.out.println(values[i]);
		}
		int[] numbers = toInt(values);
		for (int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
		}
		int total = sum(numbers);
		System.out.println("tatal : " + total);
		
		System.out.println("sum : " + add("1,2\n3"));
	}
}
