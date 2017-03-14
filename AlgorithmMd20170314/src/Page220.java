import java.util.ArrayList;
import java.util.Scanner;

/**
 * 이 도시에는 두 대의 경찰차가 있으며 두 차를 경찰차1과 경찰차2로 부른다. 
 * 처음에는 항상 경찰차1은 (1, 1)의 위치에 있고 경찰차2는 (n, n)의 위치에 있다.
 * 경찰 본부에서는 처리할 사건이 있으면 그 사건이 발생된 위치를 두 대의 경찰차 중 하나에 알려 주고, 
 * 연락 받은 경찰차는 그 위치로 가장 빠른 길을 통해 이동하여 사건을 처리한다(하나의 사건은 한 대의 경찰차가 처리한다.).
 * 그리고 사건을 처리 한 경찰차는 경찰 본부로부터 다음 연락이 올 때까지 처리한사건이 발생한 위치에서 기다린다. 
 * 경찰 본부에서는 사건이 발생한 순서대로 두 대의 경찰차에 맡기려고 한다.
 * 처리해야 될 사건들은 항상 교차로에서 발생하며 경찰 본부에서는 이러한 사건들을 나누어 두 대의 경찰차에 맡기되, 
 * 두 대의 경찰차들이 이동하는 거리의 합을 최소화 하도록 사건을 맡기려고 한다.
 * 예를 들어 앞의 그림처럼 n=6인 경우, 처리해야 하는 사건들이 3개 있고 
 * 그 사건들이 발생된 위치를 순서대로 (3, 5), (5, 5), (2, 3)이라고 하자.
 * (3, 5)의 사건을 경찰차2에 맡기고 (5, 5)의 사건도 경찰차2에 맡기며, 
 * (2, 3)의 사건을 경찰차1에 맡기면 두 차가 이동한 거리의 합은 4 + 2 + 3 = 9가 되고, 더 이상줄일 수는 없다.
 * 처리해야 할 사건들이 순서대로 주어질 때, 두 대의 경찰차가 이동하는 거리의 합을 최소화 하는 프로그램을 작성하시오.
 * 입력
 * 입력 파일의 첫째 줄에는 동서방향 도로의 개수를 나타내는 정수 n(3≤n≤1,000)이 주어진다.
 * 둘째 줄에는 처리해야 하는 사건의 개수를 나타내는 정수 w(1≤w≤15)가 주어진다. 
 * 셋째 줄부터 (w+2)번째 줄까지 사건이 발생된 위치가 한 줄에 하나씩 주어진다.
 * 경찰차들은 이 사건들을 주어진 순서대로 처리해야 한다.
 * 각 위치는 동서방향 도로 번호를 나타내는 정수와 
 * 남북방향 도로 번호를 나타내는정수로 주어지며 두 정수 사이에는 빈 칸이 하나 있다. 
 * 두 사건이 발생한 위치가 같을 수 있다.
 * 출력
 * 첫째 줄에 두 경찰차가 이동한 총 거리를 출력한다.
 * 
 * @since jdk1.8
 * @author Genie
 */
public class Page220 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, w, SUM = Integer.MAX_VALUE;
	public static ArrayList<Pos> list = new ArrayList<Pos>();
	
	/**
	 * 메인 수행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(new Pos(0,0), new Pos(n-1, n-1), 0, 0);
		output();
	}
	
	public static void output() {
		System.out.println(SUM);
	}
	
	/**
	 * 사건을 처리하는 데 가장 최소의 시간을 찾는 메서드
	 * @param p1
	 * @param p2
	 * @param size
	 */
	public static void solve(Pos p1, Pos p2, int listPos, int sum) {
		if(listPos==w) {
			if(sum<SUM) {
				SUM = sum;
			}
			return;
		}
		Pos a = list.get(listPos);
		int d1 = Math.abs(a.getX()-p1.getX())+Math.abs(a.getY()-p1.getY());
		int d2 = Math.abs(a.getX()-p2.getX())+Math.abs(a.getY()-p2.getY());
		if(d1>d2) {
			solve(p1, a, listPos+1, sum+d2);
		} else {
			solve(a, p2, listPos+1, sum+d1);
		}
	}
	
	/**
	 * 사용자의 입력을 받는 메서드
	 */
	public static void input() {
		n = sc.nextInt();
		w = sc.nextInt();
	
		for(int i=0; i<w; i++) {
			list.add(new Pos(sc.nextInt(), sc.nextInt()));
		}
	}
}

/**
 * 포지션 x, y를 저장하는 형식의 클래스
 * @since jdk1.8
 * @author Genie
 */
class Pos {
	/**
	 * x: 가로의 위치
	 * y: 세로의 위치
	 */
	private int x;
	private int y;
	
	/**
	 * Pos 클래스의 생성자 메서드
	 * @param x
	 * @param y
	 */
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 가로 x의 정보를 반환하는 메서드
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 세로 y의 정보를 반환하는 메서드
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 해당 클래스의 x, y정보를 반환하는 기본 toString() 메서드의 override메서드
	 */
	public String toString() {
		return "x: "+getX()+", y: "+getY();
	}
}

/*
6
3
3 5
5 5 
2 3
결과: 9
*/