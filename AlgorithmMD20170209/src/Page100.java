import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 크기가 h*w인 미로가 있다.
 * 이 미로는 길과 벽으로 구성되어 있으며, 길은 ".", 벽은 "#"으로 구성되어 있으며,
 * 시작위치 "S"와 도착위치 "G"가 존재한다.
 * 위에서 제시한 각 정보가 주어질 때, S위치로부터 G위치까지의 최단 거리를 
 * 구하는 프로그램을 작성하시오.
 * 입력
 * 첫 번째 줄에 h와 w가 공백으로 구분되어 입력된다.
 * (단, h, w는 5 이상 100 이하의 자연수이다.)
 * 두 번째 줄부터 h줄에 걸쳐서 w개로 이루어진 문자열이 입력된다.
 * 문자열은 길은 ".", 벽은 "#", 출발점은 "S", 도착점은 "G"로 표시된다. 그리고 S와
 * G의 위치는 서로 다르다
 * 출력
 * 출발지로부터 도착지까지의 최단거리를 출력한다.
 * 단, 도달할 수 없는 미로일 경우에는 -1을 출력한다.
 * @author Genie
 *
 */
public class Page100 {
	public static Scanner sc = new Scanner(System.in);
	public static int h, w;
	public static String[][] path;
	public static boolean check = false;
	public static boolean findResult = false;
	public static int cnt=-1;
	public static int[] dx = new int[] {1, 0, -1, 0};
	public static int[] dy = new int[] {0, 1, -0, -1};
	public static void main(String[] args) {
		h = sc.nextInt();
		w = sc.nextInt();
		path = new String[h][w];
		for(int i=0; i<h; i++) {
			path[i] = sc.next().split("");
		}
		printPath();
		solve();
		System.out.println(cnt);

		printPath();
		
	}
	
	public static boolean safe(int x, int y) {
		return (0<=x && x<h) && (0<=y && y<w);
	}
	
	/**
	 * 너비 우선 탐색 메서드
	 * 정점의 행, 열 위치 값을 받아서
	 * 해당 정점의 위 아래 오른쪽 왼쪽으로 인접해있는 정점이
	 * 
	 * '.'이어서 길인 경우
	 * 대상 정점에서 이어지는 다른 정점이 있는지 찾기 위해
	 * 대상 정점을 Queue에 넣어준다. 그리고, 
	 * 대상 정점에 시작위치 S로 부터 얼마의 거리가 걸리는지
	 * c값을 path[행][열]에 저장해준다.
	 * 
	 * 'G'인 경우 해당 정점의 c값+1을 결과 값을 cnt에 저장하고 return 한다.
	 * 
	 * 위의 경우들이 아닌 경우
	 * for문에서 아무것도 수행하지 않고,
	 * Queue에 값이 남으면 다시 Queue에서 값을 받아서
	 * for문을 다시 수행해 준다.
	 * 
	 * @param i 행위치
	 * @param j 열위치
	 */
	public static void bfs(int i, int j) {
		ArrayList<Vertex> q = new ArrayList<Vertex>();
		q.add(new Vertex(i, j, 0));
		while(q.size()>0) {
			Vertex v = q.remove(0);
			check = false;
			for(int k=0; k<4; k++) {
				if(safe(v.x+dx[k], v.y+dy[k]) && path[v.x+dx[k]][v.y+dy[k]].equals("G")) {
					cnt = v.c+1;
					return;
				}	
				if(safe(v.x+dx[k], v.y+dy[k]) && path[v.x+dx[k]][v.y+dy[k]].equals(".")) {
					path[v.x+dx[k]][v.y+dy[k]] = ""+(v.c+1);
					q.add(new Vertex(v.x+dx[k], v.y+dy[k], v.c+1));
					check = true;
				}
			}
		}
		
	}
	
	/**
	 * BFS를 위해 시작위치 S를 찾는 메서드
	 * S의 시작위치를 찾아 BFS를 호출한다.
	 */
	public static void solve() {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(path[i][j].equals("S")) {
					bfs(i, j);
					return;
				}
			}
		}
 	}
	
	/**
	 * path 이차원 배열의 값을 출력하는 메서드
	 */
	public static void printPath() {
		for(String[] a : path) {
			System.out.println(Arrays.toString(a));
		}
	}
}

/**
 * 위의 클래스에서 Queue로 활용되는 ArrayList에 저장될 데이터의 형태로,
 * 행의 위치 x
 * 열의 위치 y
 * 시작위치 S로 부터 얼마나 떨어져있는지를 나타내는 c
 * 로 구성되어있다.
 * @author Genie
 *
 */
class Vertex {
	public int x;
	public int y;
	public int c;
	
	public Vertex(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
