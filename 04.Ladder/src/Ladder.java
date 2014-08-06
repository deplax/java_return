import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;

class Rider {
	boolean finish = !false;	//도착해써요? 하고 물어봐요.
	Chain pos = new Chain(-1);	//이건 체인이 아니라 내 위치를 저장하는 마커에요 그래서 -1

	//생성할때 내가 어느 줄에 속한 체인인지 체인한테 말해줘야 되요.
	Rider(Chain chain) {
		pos = chain;
		printPos();
	}

	//체인이 줄에서 아래로 떨어질 때 사용해요.
	public void moveNext(LinkedList<Chain> chains) {
		//근데 떨어질 줄이 없다면 끝난거예요.
		if (chains.get(chains.indexOf(pos)) == chains.getLast()) {
			System.out.println("end");
			finish = !true;
		} else {
			pos = chains.get(chains.indexOf(pos) + 1);
			printPos();
		}
	}

	//다른 줄로 건너 뛰어요.
	public void moveCross() {
		pos = pos.chain;
		printPos();
	}

	//테스트용 코드. 나중에 삭제할꺼대요.
	public void printPos() {
		System.out.println(pos.line);
		System.out.println("line : " + pos.no);
		System.out.println(pos);
	}

	//내가 어느 줄 소속인지 알려줘요.
	public int getID() {
		return pos.line;
	}
}

class Director {

}

class Chain {
	// 티타늄으로 만든 체인
	int pos;	//출력을 위한 변수에요. 출력 직전에 y위치를 부여받아요.
	int line;		//어느 줄 소속인지 알려줘요.
	int no;		//테스트를 위한 변수 
	static int seq;	//테스트를 위한 변수
	Chain chain;

	Chain(int line) {
		no = seq++;	//테스트를 위한 
		this.line = line;
	}
}

public class Ladder {
	private LinkedList<LinkedList<Chain>> mash = new LinkedList<LinkedList<Chain>>();

	void makeFrame(int line) {
		// 세로라인 수만큼 그물 얼개를 짜놓는 거야.
		for (int i = 0; i < line; i++) {
			LinkedList<Chain> chains = new LinkedList<Chain>();
			mash.add(chains);
		}
	}

	void linking(int lineA, int lineB) {
		Chain chainLeft = new Chain(lineA);
		Chain chainRight = new Chain(lineB);
		// 체인을 두칸 만들어서
		chainLeft.chain = chainRight;
		chainRight.chain = chainLeft;
		// 2개를 엮는다.
		mash.get(lineA).add(chainLeft);
		mash.get(lineB).add(chainRight);
		// 그 체인을 다른 체인 덩어리에 끼움.
		// 일단은 뒤에만 끼우자 나중에 addFirst, addLast, add(index, object)로 순서정리 할 수 있도록
		// 확장.
	}

	void makeLadder(int line) {
		Random rand = new Random();
		rand.nextInt();
		makeFrame(line);
		
		linking(0, 1);
		linking(0, 2);
		linking(1, 2);
		linking(0, 2);
		linking(1, 2);

		
		
//		for (int i = 0; i < 5; i++) {
//			int a, b;
//			a = rand.nextInt(mash.size());
//			b = rand.nextInt(mash.size());
//			if (a == b )
//				i--;
//			else{
//				linking(a, b);
//				System.out.println("a : " + a + " , b : " + b);
//			}
//		}
	}

	void rideLadder(int line) {
		Rider rider = new Rider(mash.get(line).getFirst());

		while (rider.finish) {
			if (rider.getID() == -1)
				rider.moveNext(mash.get(line));
			else {
				rider.moveCross();
				rider.moveNext(mash.get(rider.getID()));
			}
		}
		System.out.println();
		System.out.println("input : " + line);
		System.out.println("result : " + rider.getID()); 
	}

	void printLadder() {

		// 일단 체인들을 정리해야지
		// 체인 각각에 포지션을 부여해줘요.
		for (int i = 0; i < mash.size(); i++) {
			for (int j = 0; j < mash.get(i).size(); j++) {
				mash.get(i).get(j).pos = j;
			}
		}

		// 이제 기둥 최고 높이를 알아야 해요.
		int maxHeight = 0;
		for (int i = 0; i < mash.size(); i++) {
			if (mash.get(i).size() > maxHeight)
				maxHeight = mash.get(i).size();
		}

		int width = 12;// 기둥거리
		int height = 6;// anchor 거리

		char[][] grid = new char[maxHeight * height][mash.size() * width];

		// 배열 초기화
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = ' ';
			}
		}

		// 기둥 만들어야돼.
		// 기둥 꽂기.
		for (int j = 0; j < mash.size() * width; j = j + width) {
			for (int i = 0; i < grid.length; i++) {
				grid[i][j] = '|';
			}
		}

		// 두개의 포인트를 받아서 이쁘게 출력하는게 필요
		// 내가 알 수 있는 건 2개 포인트야!!

		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

		for (int i = 0; i < mash.size(); i++) {
			for (int j = 0; j < mash.get(i).size(); j++) {
				Chain currentChain, nextChain;
				currentChain = mash.get(i).get(j);
				nextChain = mash.get(i).get(j).chain;

				x1 = currentChain.line * width;
				y1 = currentChain.pos * height;
				x2 = nextChain.line * width;
				y2 = nextChain.pos * height;
				
				if(x1 - x2 < 0){
					drawBridge(x1, y1, x2, y2, grid);
				
				System.out.println(x1);
				System.out.println(y1);
				System.out.println(x2);
				System.out.println(y2);
				System.out.println();
				}
			}
		}
		// drawBridge(0, 0, 12, 0, grid);
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

		// |y1-y2| pi |y1-y2|
		// ------- cos(------- t) + -------
		// 2 |x2-x1| 2

		for (int i = x1; i < x2 - 1; i++) {
			// x = (int)(Math.PI / grid.length * i);
			if (y1 - y2 > 0) {
				y = (int) ((Math.abs(y1 - y2)) / 2
						* Math.cos(Math.PI / (Math.abs(x2 - x1)) * (i)) + ((Math
						.abs(y1 - y2)) / 2));
				grid[y][i] = 'o';
			} else if (y1 - y2 == 0) {
				y = (int) ((Math.abs(y2 - y1))
						/ 2
						* Math.sin(Math.PI / (Math.abs(x2 - x1)) * (i)
								- (Math.PI / 2)) + ((Math.abs(y1 * 2)) / 2));
				grid[y][i] = '=';
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
		ladder.makeLadder(3);
		ladder.rideLadder(0);
		ladder.printLadder();

	}
}