import java.util.Scanner;

/**
 * �����ڵ鿡�� �Ҽ��� �ſ� ��� �ִ� ���� �����̴�. �Ҽ�(prime number)�� ���
 * �� 1�� �ڱ� �ڽŹۿ� ���� 1���� ū �ڿ����� ���Ѵ�. �����ڵ��� �Ҽ��� �����ϸ�
 * �� Ư���� �Ҽ����� �߰��Ͽ� �̸��� ����Ͽ���. �޸��� �Ҽ�, �丣�� �Ҽ�, �ֵ���
 * �Ҽ� ���� �� ���̴�.
 * �츮���Դ� ���������� ������ ���� ���� �Ҽ��� �ִ�. �� �Ҽ��� �����ʺ��� ��
 * ���� �����ص� ��� �Ҽ��� �Ǵ� �Ҽ��̴�.
 * ũ�Ⱑ �� �ڸ��� 7193�� ���� ����. 7193�� �Ҽ��̰�, 7193�� ������ ���� 3
 * �� �����Ͽ� ���� 719�� �Ҽ��̴�. 719�� ������ ���� 9�� �����Ͽ� ���� 71�� �Ҽ�
 * �̴�. 71�� ������ ���� 1�� �����Ͽ� ���� 7�� �Ҽ��̴�. ���� 7193�� ������ ��
 * �� ���� �Ҽ��̴�.
 * �Է�
 * �ڸ��� n�� ������ �Էµȴ�.(1 <= n <= 10)
 * ���
 * 1. n�ڸ��� �̷���� ������ ���� ���� �Ҽ����� �� �ٿ� �ϳ��� ������������ ��
 * ���Ѵ�.
 * 2. ������ �ٿ� ��µ� ������ ���� ���� �Ҽ����� ������ ����Ѵ�.
 * @since jdk1.8
 * @author Genie
 *
 */
public class Page146DFS {
	public static Scanner sc = new Scanner(System.in);
	public static int num, cnt;
	public static void main(String[] args) {
		num = sc.nextInt();
		solve(2, 1);
		solve(3, 1);
		solve(5, 1);
		solve(7, 1);
		System.out.println(cnt);
	}
	
	/**
	 * n�� �ڸ��� ���ڵ��� ������ ���� ���� �Ҽ��϶� �ش� ���� ����ϴ� �޼���
	 */
	public static void solve(int n, int len) {
		if(len==num) {
			if(isPrime(n)) {
				cnt++;
				System.out.println(n);
			}
			return;
			
		} else {
			if(isPrime(n)) {
				solve(n*10+1, len+1);
				solve(n*10+3, len+1);
				solve(n*10+7, len+1);
				solve(n*10+9, len+1);
			}
		}
	}	
	
	/**
	 * n�� �Ҽ����� Ȯ���ϴ� �޼���
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		if(n<2)
			return false;
		for (int i=2; i<=Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
