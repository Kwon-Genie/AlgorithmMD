import java.util.Scanner;

/**
 * â���� �˰��� P204 ����
 * @since jdk1.8
 * @author Genie
 */
public class Page204 {
	/**
	 * sc: ������� �Է��� ���� ����
	 * d: �浿 ������ ���� �� - ��� ������ ���� ��
	 * g1: �浿 ���� ���� ��
	 * g2: ��� ���� ���� ��
	 * g3: ��� ���� ���� ��
	 * W: ��ü ���� ���� ��
	 * w: ���� ���� ����Ʈ
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int G1, G2, G3, n, d = Integer.MAX_VALUE;
	public static int[] w;
	
	/**
	 * ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		input();
		solve(0, 0, 0, 0);
		output();
	}
	
	/**
	 * ������ �����ϴ� ���� �����ϴ� ���θ� ��ȯ�ϴ� �޼���
	 * @param g1
	 * @param g2
	 * @param g3
	 * @return
	 */
	public static boolean isRightRule(int g1, int g2, int g3) {
		return (g1>=g2)&&(g2>=g3)?true:false;
	}
	
	/**
	 * ������ �����ϴ� ������� ã�� �޼���
	 * @param g1
	 * @param g2
	 * @param g3
	 * @param pos
	 */
	public static void solve(int g1, int g2, int g3, int pos) {
		if(pos==n) {
			if(isRightRule(g1,g2,g3)) {
				if(d>g1-g3) {
					d = g1-g3;
					G1 = g1;
					G2 = g2;
					G3 = g3;
				}
			}
			return;
		}
		solve(g1+w[pos], g2, g3, pos+1);
		solve(g1, g2+w[pos], g3, pos+1);
		solve(g1, g2, g3+w[pos], pos+1);
	}
	
	/**
	 * ����� ����ϴ� �޼���
	 */
	public static void output() {
		System.out.println(G1+" "+G2+" "+G3);
	}
	
	/**
	 * ������� �Է��� �޴� �޼���
	 */
	public static void input() {
		n = sc.nextInt();
		w = new int[n];
		for(int i=0; i<n; i++) {
			w[i] = sc.nextInt();
		}
	}
}
