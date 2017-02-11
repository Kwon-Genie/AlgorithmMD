import java.util.Scanner;

/**
 * �����̴� GSHS���� ����Ȱ�� �������� �Ʒ� A���б��� ������ �Ѵ�. ������� ��
 * ������ �����Ͽ� �����ϴ� ���� n��, �� �������� �ٸ� �������� ���� ����� �� m
 * ���̸� GSHS�� ���� 1�̰� A���б��� ���� n�̶�� �� �� ���б��� �ּ� �����
 * ���Ͻÿ�.
 * ��, n�� 10 ����, m�� 30 ����, �׸��� �� �������� �ٸ� �������� ���� ���� ��
 * ���� ����� ��� 200 ���� ���� �����̸� �� �������� �ٸ� �������� ���� ���
 * ����� �����ϸ� ���� ����� ����� ���� ���������� �� �� �ִ�.
 * ���� �׷����� ���� �����ش�.(��, ����a->����b���� ������ ���� �� ���� �� ����
 * ��, �ڱ� �ڽ����� ���� ������ ���� ���� �ִ�.)
 * �Է�
 * ù ��° �ٿ��� ������ �� n�� ������ �� m�� �������� ���еǾ� �Էµȴ�. ����
 * �ٺ��� m���� �ٿ� ���ļ� �� ������ ��ȣ�� ����ġ�� �Էµȴ�. (�ڱ� ����, ��Ƽ
 * ������ ���� �� �ִ�.)
 * ���
 * ���б��� ���� �� ��� �ּ� ����� ����Ѵ�. ���� �� �� ���ٸ� ��-1���� ���.
 * @since jdk1.8
 * @author Genie
 *
 */
public class Page134 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, m, sol = 0x7fffffff;
	public static int[] chk = new int[11];
	public static int[][] g = new int[11][11];
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int s, e, w;
			s = sc.nextInt();
			e = sc.nextInt();
			w = sc.nextInt();
			g[s][e] = g[e][s] = w;
		}
		solve(1,0);
		System.out.println(sol==0x7fffffff?-1:sol);
	}
	
	/**
	 * ��� ã�Ƽ� ã�� ����� ����ġ�� ������ ã�� ����ġ���� ���� ���
	 * sol�� ��� ����ġ�� �־��ִ� �޼���
	 * @param v
	 * @param w
	 */
	public static void solve(int v, int w) {
		if(v==n) {
			if(w<sol)
				sol = w;
			return;
		}
		for(int i=1; i<=n; i++) {
			if(chk[i]!=1 && g[v][i]!=0) {
				chk[i] = 1;
				solve(i, w+g[v][i]);
				chk[i] = 0;
			}
		}
	}
}
