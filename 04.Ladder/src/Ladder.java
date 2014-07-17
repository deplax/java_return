import java.util.Scanner;

class Marker {
	private int x;
	private int y;

	Marker(int line) {
		x = -1;
		y = line - 1;
	}

	void moveLeft() {
		y--;
	}

	void moveRight() {
		y++;
	}

	void moveDown() {
		x++;
	}

	int getXPosition() {
		return x;
	}

	int getYPosition() {
		return y;
	}

	boolean check() {

		return true;
	}

}

class Mover {

	Marker marker;

	Mover(int line) {
		marker = new Marker(line);
	}

	int checkLadderLinePos(int[][] ladder) {
		if (marker.getYPosition() == 0) 									// ���� ������ ��
		{
			return 1;
		} else if (marker.getYPosition() == ladder[0].length - 1) // ������ ������ ��
		{
			return -1;
		}
		return 0;
	}

	boolean checkRight(int[][] ladder) {
		if (ladder[marker.getXPosition() + 1][marker.getYPosition()] == 1)
			return true;
		return false;
	}

	boolean checkLeft(int[][] ladder) {
		if (ladder[marker.getXPosition() + 1][marker.getYPosition() - 1] == 1)
			return true;
		return false;
	}

	void moving(int[][] ladder) {
		int linePos = checkLadderLinePos(ladder);
		if (linePos == 1) {
			if (checkRight(ladder))
				marker.moveRight();
		} else if (linePos == -1) {
			if (checkLeft(ladder))
				marker.moveLeft();
		} else {
			if (checkLeft(ladder)) {
				marker.moveLeft();
			} else if (checkRight(ladder)) {
				marker.moveRight();
			}
		}
		marker.moveDown();
	}

}

public class Ladder {

	int[][] ladder;
	int line;
	boolean exitSw;
	
	String str;
	Scanner sc;
	
	Ladder() {
		ladder = new int[4][3];
		ladder[0][0] = 1;
		ladder[1][1] = 1;
		ladder[2][0] = 1;
		ladder[3][1] = 1;
		
		exitSw = false;
	}

	void lineInput() {
		System.out.print(">");
		sc = new Scanner(System.in);
		str = sc.next();
		if(tryConvertToInt(str) && checkBound())
			rideLadder();
	}
	
	boolean tryConvertToInt(String str){
		try{
			line = Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e){
			System.out.println(e.getMessage());
			System.out.println("���α׷��� �����մϴ�.");
			exit();
			return false;
		}
	}
	
	boolean checkBound()
	{
		if(line > 0 && line <= ladder[0].length)
			return true;
		System.out.println("��ٸ� �Է� ������ �ʰ��Ͽ����ϴ�. [�Է¹��� : 0 - " + ladder[0].length + "]");
		return false;
	}

	void rideLadder() {
		Mover mover = new Mover(line);

		for (int i = 0; i < ladder.length; i++) {
			mover.moving(ladder);
		}

		int result = mover.marker.getYPosition() + 1;
		System.out.println(result);
	}
	
	void printLadder(){
		
	}
	
	void exit()
	{
		exitSw = true;
		sc.close();
	}
	
	boolean isExit()
	{
		return exitSw;
	}

	public static void main(String[] args) {

		Ladder ladder = new Ladder();
		while(!ladder.isExit())
		{
			ladder.lineInput();
		}
	}

}
