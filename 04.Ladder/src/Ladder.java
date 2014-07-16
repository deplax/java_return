import java.lang.reflect.Array;

class Marker {
	private int x;
	private int y;
	Marker(){
		x = 0;
		//y = line;
	}

	Marker moveLeft() {
		Marker marker = new Marker();
		x--;
		return marker;
	}

	Marker moveRight() {
		Marker marker = new Marker();
		x++;
		return marker;
	}

	Marker moveDown() {
		Marker marker = new Marker();
		y++;
		return marker;
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
	Marker marker = new Marker();
	void checkLadder(int[][] ladder){
		int curX = marker.getXPosition();
		int curY = marker.getYPosition();
		
		//오른쪽인지 왼쪽인지 중앙인지 판단
		//결과에 따라 마커를 이동;
	}
	
	void checkLadderLine(int[][] ladder)
	{
		if(marker.getYPosition() == 0)		//왼쪽벽에 붙었다!!
		{
			//오른쪽만 검사
		}else if(marker.getYPosition() == ladder.length)	//오른쪽벽에 붙었다.
		{
			//아래만 검사
		}else
		{
			//오른쪽, 아래 검사
		}
	}

}

public class Ladder {
	
	int[][] ladder;
	
	Ladder() {
		ladder = new int[4][3];
		ladder[0][0] = 1;
		ladder[1][1] = 1;
		ladder[2][1] = 1;
		ladder[3][1] = 1;
	}

	int rideLadder(int line) {
		Mover mover = new Mover();
		mover.marker.getPosition();
		
		//무버가 사다리를 검사할꺼야
		//그리고 어디로 가야되는지
		//마커한테 알려줄꺼야
		//그리고 마커가 움직일꺼야
		
		
		return 0;
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

}
