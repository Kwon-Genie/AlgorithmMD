import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ũ�Ⱑ h*w�� �̷ΰ� �ִ�.
 * �� �̷δ� ��� ������ �����Ǿ� ������, ���� ".", ���� "#"���� �����Ǿ� ������,
 * ������ġ "S"�� ������ġ "G"�� �����Ѵ�.
 * ������ ������ �� ������ �־��� ��, S��ġ�κ��� G��ġ������ �ִ� �Ÿ��� 
 * ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�
 * ù ��° �ٿ� h�� w�� �������� ���еǾ� �Էµȴ�.
 * (��, h, w�� 5 �̻� 100 ������ �ڿ����̴�.)
 * �� ��° �ٺ��� h�ٿ� ���ļ� w���� �̷���� ���ڿ��� �Էµȴ�.
 * ���ڿ��� ���� ".", ���� "#", ������� "S", �������� "G"�� ǥ�õȴ�. �׸��� S��
 * G�� ��ġ�� ���� �ٸ���
 * ���
 * ������κ��� ������������ �ִܰŸ��� ����Ѵ�.
 * ��, ������ �� ���� �̷��� ��쿡�� -1�� ����Ѵ�.
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
	 * �ʺ� �켱 Ž�� �޼���
	 * ������ ��, �� ��ġ ���� �޾Ƽ�
	 * �ش� ������ �� �Ʒ� ������ �������� �������ִ� ������
	 * 
	 * '.'�̾ ���� ���
	 * ��� �������� �̾����� �ٸ� ������ �ִ��� ã�� ����
	 * ��� ������ Queue�� �־��ش�. �׸���, 
	 * ��� ������ ������ġ S�� ���� ���� �Ÿ��� �ɸ�����
	 * c���� path[��][��]�� �������ش�.
	 * 
	 * 'G'�� ��� �ش� ������ c��+1�� ��� ���� cnt�� �����ϰ� return �Ѵ�.
	 * 
	 * ���� ������ �ƴ� ���
	 * for������ �ƹ��͵� �������� �ʰ�,
	 * Queue�� ���� ������ �ٽ� Queue���� ���� �޾Ƽ�
	 * for���� �ٽ� ������ �ش�.
	 * 
	 * @param i ����ġ
	 * @param j ����ġ
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
	 * BFS�� ���� ������ġ S�� ã�� �޼���
	 * S�� ������ġ�� ã�� BFS�� ȣ���Ѵ�.
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
	 * path ������ �迭�� ���� ����ϴ� �޼���
	 */
	public static void printPath() {
		for(String[] a : path) {
			System.out.println(Arrays.toString(a));
		}
	}
}

/**
 * ���� Ŭ�������� Queue�� Ȱ��Ǵ� ArrayList�� ����� �������� ���·�,
 * ���� ��ġ x
 * ���� ��ġ y
 * ������ġ S�� ���� �󸶳� �������ִ����� ��Ÿ���� c
 * �� �����Ǿ��ִ�.
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
