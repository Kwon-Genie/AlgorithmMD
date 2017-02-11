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
public class Page146 {
	public static Scanner sc = new Scanner(System.in);
	public static int num;
	public static void main(String[] args) {
		num = sc.nextInt();
		solve();
	}
	
	/**
	 * n�� �ڸ��� ���ڵ��� ������ ���� ���� �Ҽ��ΰ���� ���� 
	 * �Ҽ����� ����ϴ� �޼���
	 */
	public static void solve() {
		int cnt = 0;
		for(int i=(int) Math.pow(10, num-1); i<Math.pow(10, num); i++) {
			if(isPrime(i)) {
				cnt++;
				System.out.println(i);
			}	
		}
		System.out.println(cnt);
	}	
	
	/**
	 * �ش� �� n�� ������ ���� ���� �Ҽ����� Ȯ���ϴ� �޼���
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		while (n > 1) {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
			n = n/10;
		}
		if(n==1)
			return false;
		return true;
	}
}
