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

	void makeLadder() {
		// 사람수만큼 기둥을 세운다.
		Post post1 = new Post();
		Post post2 = new Post();
		linkBridge(post1, post2);
	}
	void linkBridge(Post post1, Post post2)
	{
		Bridge bridge = new Bridge();
		bridge.setLeftRing(post1);
		bridge.setRightRing(post2);
		post1.setRing(bridge);
		post2.setRing(bridge);
	}

	public static void main(String[] args) {

	}
}