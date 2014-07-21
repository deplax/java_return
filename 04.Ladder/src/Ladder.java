import java.util.Scanner;

class Marker {
	private int x;
	private int y;
	boolean move = false;

	Marker(int line) {
		x = -1;
		y = line - 1;
	}

	void moveLeft() {
		if (!move) {
			y--;
			move = true;
		}
	}

	void moveRight() {
		if (!move) {
			y++;
			move = true;
		}
	}

	void moveDown() {
		x++;
		move = false;
	}

	int getXPosition() {
		return x;
	}

	int getYPosition() {
		return y;
	}

	boolean isMove() {
		return move;
	}

}

class Mover {

	Marker marker;

	Mover(int line) {
		marker = new Marker(line);
	}

	int checkLadderLinePos(int[][] ladder) {
		if (marker.getYPosition() == 0) // 왼쪽 라인일 때
			return 1;
		if (marker.getYPosition() == ladder[0].length - 1) // 오른쪽 라인일 때
			return -1;
		return 0;
	}

	void checkRight(int[][] ladder) {
		if (ladder[marker.getXPosition() + 1][marker.getYPosition()] == 1)
			marker.moveRight();
	}

	void checkLeft(int[][] ladder) {
		if (ladder[marker.getXPosition() + 1][marker.getYPosition() - 1] == 1)
			marker.moveLeft();
	}

	void moving(int[][] ladder) {
		int linePos = checkLadderLinePos(ladder);
		if (linePos == 1)
			checkRight(ladder);
		if (linePos == -1)
			checkLeft(ladder);
		if (linePos == 0) {
			checkRight(ladder);
			checkLeft(ladder);
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
		if (tryConvertToInt(str) && checkBound())
			rideLadder();
	}

	boolean tryConvertToInt(String str) {
		try {
			line = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			System.out.println("프로그램을 종료합니다.");
			exit();
			return false;
		}
	}

	boolean checkBound() {
		if (line > 0 && line <= ladder[0].length)
			return true;
		System.out.println("사다리 입력 범위를 초과하였습니다. [입력범위 : 0 - "
				+ ladder[0].length + "]");
		return false;
	}

	void rideLadder() {
		Mover mover = new Mover(line);

		for (int i = 0; i < ladder.length; i++)
			mover.moving(ladder);

		int result = mover.marker.getYPosition() + 1;
		System.out.println(result);
	}

	void printLadder() {

	}

	void exit() {
		exitSw = true;
		sc.close();
	}

	boolean isExit() {
		return exitSw;
	}

	public static void main(String[] args) {

		Ladder ladder = new Ladder();
		while (!ladder.isExit()) {
			ladder.lineInput();
		}
	}
}