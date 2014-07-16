import junit.framework.TestCase;


public class CalcTest extends TestCase {

	Calc cal;
	public void setUp() throws Exception {
		cal = new Calc();
	}
	
	public void testAddWhenEmpty() {
		assertEquals(0, cal.add(""));
	}
	public void testAddWhenOneNumber() {
		assertEquals(3, cal.add("3"));
	}
	public void testAddWhenTwoNumber() {
		assertEquals(3, cal.add("1,2"));
	}
	public void testAddWhenThreeNumber() {
		assertEquals(6, cal.add("1,2,3"));
	}
	public void testAddWhenThreeNumberNNewLine() {
		assertEquals(6, cal.add("1\n2\n3"));
	}
}

