import java.util.ArrayList;
import java.util.Scanner;

/**
 * �� ���ÿ��� �� ���� �������� ������ �� ���� ������1�� ������2�� �θ���. 
 * ó������ �׻� ������1�� (1, 1)�� ��ġ�� �ְ� ������2�� (n, n)�� ��ġ�� �ִ�.
 * ���� ���ο����� ó���� ����� ������ �� ����� �߻��� ��ġ�� �� ���� ������ �� �ϳ��� �˷� �ְ�, 
 * ���� ���� �������� �� ��ġ�� ���� ���� ���� ���� �̵��Ͽ� ����� ó���Ѵ�(�ϳ��� ����� �� ���� �������� ó���Ѵ�.).
 * �׸��� ����� ó�� �� �������� ���� ���ηκ��� ���� ������ �� ������ ó���ѻ���� �߻��� ��ġ���� ��ٸ���. 
 * ���� ���ο����� ����� �߻��� ������� �� ���� �������� �ñ���� �Ѵ�.
 * ó���ؾ� �� ��ǵ��� �׻� �����ο��� �߻��ϸ� ���� ���ο����� �̷��� ��ǵ��� ������ �� ���� �������� �ñ��, 
 * �� ���� ���������� �̵��ϴ� �Ÿ��� ���� �ּ�ȭ �ϵ��� ����� �ñ���� �Ѵ�.
 * ���� ��� ���� �׸�ó�� n=6�� ���, ó���ؾ� �ϴ� ��ǵ��� 3�� �ְ� 
 * �� ��ǵ��� �߻��� ��ġ�� ������� (3, 5), (5, 5), (2, 3)�̶�� ����.
 * (3, 5)�� ����� ������2�� �ñ�� (5, 5)�� ��ǵ� ������2�� �ñ��, 
 * (2, 3)�� ����� ������1�� �ñ�� �� ���� �̵��� �Ÿ��� ���� 4 + 2 + 3 = 9�� �ǰ�, �� �̻����� ���� ����.
 * ó���ؾ� �� ��ǵ��� ������� �־��� ��, �� ���� �������� �̵��ϴ� �Ÿ��� ���� �ּ�ȭ �ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�
 * �Է� ������ ù° �ٿ��� �������� ������ ������ ��Ÿ���� ���� n(3��n��1,000)�� �־�����.
 * ��° �ٿ��� ó���ؾ� �ϴ� ����� ������ ��Ÿ���� ���� w(1��w��15)�� �־�����. 
 * ��° �ٺ��� (w+2)��° �ٱ��� ����� �߻��� ��ġ�� �� �ٿ� �ϳ��� �־�����.
 * ���������� �� ��ǵ��� �־��� ������� ó���ؾ� �Ѵ�.
 * �� ��ġ�� �������� ���� ��ȣ�� ��Ÿ���� ������ 
 * ���Ϲ��� ���� ��ȣ�� ��Ÿ���������� �־����� �� ���� ���̿��� �� ĭ�� �ϳ� �ִ�. 
 * �� ����� �߻��� ��ġ�� ���� �� �ִ�.
 * ���
 * ù° �ٿ� �� �������� �̵��� �� �Ÿ��� ����Ѵ�.
 * 
 * @since jdk1.8
 * @author Genie
 */
public class Page220 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, w, SUM = Integer.MAX_VALUE;
	public static ArrayList<Pos> list = new ArrayList<Pos>();
	
	/**
	 * ���� ���� �޼���
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
	 * ����� ó���ϴ� �� ���� �ּ��� �ð��� ã�� �޼���
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
	 * ������� �Է��� �޴� �޼���
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
 * ������ x, y�� �����ϴ� ������ Ŭ����
 * @since jdk1.8
 * @author Genie
 */
class Pos {
	/**
	 * x: ������ ��ġ
	 * y: ������ ��ġ
	 */
	private int x;
	private int y;
	
	/**
	 * Pos Ŭ������ ������ �޼���
	 * @param x
	 * @param y
	 */
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * ���� x�� ������ ��ȯ�ϴ� �޼���
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * ���� y�� ������ ��ȯ�ϴ� �޼���
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * �ش� Ŭ������ x, y������ ��ȯ�ϴ� �⺻ toString() �޼����� override�޼���
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
���: 9
*/