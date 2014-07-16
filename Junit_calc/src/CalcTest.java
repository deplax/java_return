import junit.framework.TestCase;


public class CalcTest extends TestCase {
	Calc cal;
	@Override
	protected void setUp() throws Exception {
		cal = new Calc();
		System.out.println("setup");
	}
	public void testAdd() {
		System.out.println("add");
		int result = cal.add(2, 5);
		assertEquals(7, result);
	}
	public void testSub() throws Exception {
		System.out.println("sub");
		int result = cal.sub(2, 5);
		assertEquals(-3, result);
	}
	@Override
	protected void tearDown() throws Exception {
		System.out.println("teardown");
		
	}
}
