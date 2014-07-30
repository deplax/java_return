import java.util.Scanner;
import java.util.LinkedList;

class Ring {
	// 티타늄으로 만든 고리
	Bridge bridge;
	Post post;
}

class Post {
	// 오동나무로 만든 나무기둥
	private LinkedList<Ring> rings = new LinkedList<Ring>();

	Post() {
		rings = new LinkedList<Ring>();
	}

	void setRing(Bridge bridge) {
		Ring ring = new Ring();
		ring.post = this;
		ring.bridge = bridge;
		rings.add(ring);
		// add를 시켜주면 구멍을 뚫고 링을 끼워줘
	}

	int getRingCnt() {
		return rings.size();
	}
}

class Bridge {
	// 오동나무로 만든 브릿지
	private Ring leftRing;
	private Ring rightRing;

	Bridge() {
		leftRing.bridge = this;
		rightRing.bridge = this;
	}

	void setLeftRing(Post post) {
		leftRing.post = post;
	}

	void setRightRing(Post post) {
		rightRing.post = post;
	}
}

public class Ladder {

	private LinkedList<Post> posts;
	private LinkedList<Bridge> bridges;

	void makeLadder(int line) {
		// 사람수만큼 기둥을 세운다.
		posts = new LinkedList<Post>();
		for (int i = 0; i < line; i++) {
			Post p = new Post();
			posts.add(p);
		}
		linkBridge(posts.get(0), posts.get(1));
	}

	void linkBridge(Post postA, Post postB) {
		Bridge bridge = new Bridge();
		bridge.setLeftRing(postA);
		bridge.setRightRing(postB);
		postA.setRing(bridge);
		postB.setRing(bridge);
		bridges.add(bridge);
	}

	void printLadder() {

		int width = 12;
		int height = 3;
		// char[][] grid = new char[posts.size() * width][bridges.size() * 10];
		char[][] grid = new char[10 * height][3 * width];

		// 배열 초기화
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = ' ';
			}
		}

		// 기둥 만들어야돼.
		// 기둥 꽂기.
		for (int j = 0; j < 3 * width; j = j + width) {
			for (int i = 0; i < grid.length; i++) {
				grid[i][j] = '|';
			}
		}

		// 두개의 포인트를 받아서 이쁘게 출력하는게 필요
		// 내가 알 수 있는 건 2개 포인트야!!
		drawBridge(0, 7, 12, 0, grid);
		drawBridge(0, 10, 24, 0, grid);
		drawBridge(0, 0, 12, 5, grid);

		// 전체를 그려요.
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	void drawBridge(int x1, int y1, int x2, int y2, char[][] grid) {
		x1++;
		x2++;
		// ++이 필요한 이유는 post와 겹치지 않게 하기 위함.

		int y;

		// (|y1-y2|)/2 * cos(pi/(|x2-x1|)t) + ((|y1-y2|)/2)
		// t 구간이 0 ~ pi

		// |y1-y2|        pi        |y1-y2|
		// ------- cos(------- t) + -------
		//    2        |x2-x1|         2

		for (int i = x1; i < x2 - 1; i++) {
			// x = (int)(Math.PI / grid.length * i);
			if (y1 - y2 > 0) {
				y = (int) ((Math.abs(y1 - y2)) / 2
						* Math.cos(Math.PI / (Math.abs(x2 - x1)) * (i)) + ((Math
						.abs(y1 - y2)) / 2));
				grid[y][i] = 'o';
			} else {
				y = (int) ((Math.abs(y1 - y2))
						/ 2
						* Math.sin(Math.PI / (Math.abs(x2 - x1)) * (i)
								- (Math.PI / 2)) + ((Math.abs(y1 - y2)) / 2));
				grid[y][i] = '*';
			}
			// System.out.println( i + " x : " + i);
			// System.out.println( i + " y : " + y);
		}
	}

	public static void main(String[] args) {
		Ladder ladder = new Ladder();
		// ladder.makeLadder(3);
		ladder.printLadder();

	}
}