import java.util.Scanner;
/**
 * �־��� ȭ�� �ѷ��� ���̸� �̿��Ͽ� �ﰢ�� ����� ȭ���� ������� �Ѵ�. �� ��
 * ������� �ﰢ�� ȭ�� �ѷ��� ���̴� �ݵ�� �־��� ȭ�� �ѷ��� ���̿� ���ƾ� �Ѵ�.
 * ����, ȭ�� �ѷ��� ���̿� �� ���� ���̴� �ڿ����̴�. ���� ���, ������� �ϴ�
 * ȭ�� �ѷ��� ���̰� 9m��� �ϸ�,
 * -�� ���� ���̰� 1m, �� ���� ���̰� 4m�� ȭ��
 * -�� ���� ���̰� 2m, �ٸ� ���� ���̰� 3m, ������ ���� ���̰� 4m�� ȭ��
 * -�� ���� ���̰� ��� 3m�� 3���� ����� ȭ���� ���� �� �ִ�.
 * @since jdk1.8 
 * @author Genie
 *
 */
public class Page119 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][][] chk = new int[21][21][21];
	public static int cnt = 0;
	public static void main(String[] args) {
		int n = sc.nextInt();
		solve(n, 1, 1, 1);
		System.out.println(cnt);
	}
	
	/**
	 * �ﰢ�� ������ ���� a, b, c�� �ΰ�
	 * ���̸� a<=b<=c�� �����ϴ� ���鸸 �˻��Ͽ�
	 * �ﰢ���� ������ �����ϸ� cnt�� �ش� ����� ����ŭ ��������
	 * cnt�� ��ȯ�Ѵ�.
	 * @return
	 */
	public static void solve(int n, int a, int b, int c) {
		if(a+b+c==n) {
			if(a<=b && b<=c && a+b>c && chk[a][b][c]==0) {
				cnt++;
				chk[a][b][c] = 1;
			}
			return;
		}
		solve(n, a+1, b, c);
		solve(n, a, b+1, c);
		solve(n, a, b, c+1);
	}
}
