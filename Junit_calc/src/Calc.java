
public class Calc {
	int add(int i, int j) {
		return i + j;
	}
	int sub(int i, int j) {
		return i - j;
	}
	int mul(int i, int j) {
		return i * j;
	}
	int div(int i, int j) {
		return i / j;
	}

	public static void main(String[] args) {
		Calc cal = new Calc();
		System.out.println(cal.add(1, 2));
		System.out.println(cal.sub(1, 2));
		System.out.println(cal.mul(1, 2));
		System.out.println(cal.div(1, 2));
	}
}
