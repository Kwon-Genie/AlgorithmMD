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
public class Page117 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		System.out.println(solve());
	}
	
	/**
	 * �ﰢ�� ������ ���� a, b, c�� �ΰ�
	 * ���̸� a<=b<=c�� �����ϴ� ���鸸 �˻��Ͽ�
	 * �ﰢ���� ������ �����ϸ� cnt�� �ش� ����� ����ŭ ��������
	 * cnt�� ��ȯ�Ѵ�.
	 * @return
	 */
	public static int solve() {
		int cnt = 0;
		for(int a=1; a<=n; a++) {
			for(int b=a; b<=n; b++) {
				for(int c=b; c<=n; c++) {
					if(a+b+c==n && a+b>c)
						cnt++;
				}
			}
		}
		return cnt;
	}
}
