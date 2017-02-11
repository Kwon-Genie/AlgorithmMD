import java.util.Scanner;

/**
 * ��ǻ�ͽǿ��� ���� ���� ���� �������� �ó������ �µ��� �����Ϸ��� �Ѵ�.
 * �ó���Ⱑ �ָ� �־ ���������� �����Ϸ��� �ϴµ�, �������� �µ� ���� ��ư
 * �� ������ ����.
 * 1) �µ��� 1�� �ø��� ��ư
 * 2) �µ��� 1�� ������ ��ư
 * 3) �µ��� 5�� �ø��� ��ư
 * 4) �µ��� 5�� ������ ��ư
 * 5) �µ��� 10�� �ø��� ��ư
 * 6) �µ��� 10�� ������ ��ư
 * �̿� ���� �� 6���� ��ư���� ��ǥ �µ��� �����ؾ� �Ѵ�.
 * ���� ���� �µ��� �����ϰ��� �ϴ� ��ǥ �µ��� �־����� �� ��ư���� �̿��Ͽ�
 * ��ǥ �µ��� �����ϰ��� �Ѵ�.
 * �� �� ��ư ������ �ּ� Ƚ���� ���Ͻÿ�. ���� ���, 7������ 34���� �����ϴ� ���,
 * 7 �� 17 �� 27 �� 32 �� 33 �� 34
 * �̷��� �� 5�� ������ �ȴ�.
 * �Է�
 * ���� �µ� a�� ��ǥ �µ� b�� �Էµȴ�(0 <= a, b <= 40).
 * ���
 * �ּ����� ��ư ������� ��ǥ �µ��� �Ǵ� ��ư ������ Ƚ���� ����Ѵ�.
 * 
 * @since jdk1.8 
 * @author Genie
 */
public class Page140 {
	public static Scanner sc = new Scanner(System.in);
	public static int result  = 40;
	public static int a, b;
	
	public static void main(String[] args) {
		a = sc.nextInt();
		b = sc.nextInt();
		temp(a, 0);
		System.out.println(result);
	}
	
	/**
	 * ��ǥ �µ������� �ּ�Ƚ���� ã�� DFS �޼���
	 * @param temp
	 * @param cnt
	 */
	public static void temp(int temp, int cnt) {
		if(cnt>result)
			return;
		if(temp==b && cnt<result) {
			result = cnt;
			return;
		}
		temp(temp+1, cnt+1);
		temp(temp+5, cnt+1);
		temp(temp+10, cnt+1);
		temp(temp-1, cnt+1);
		temp(temp-5, cnt+1);
		temp(temp-10, cnt+1);
	}
}
