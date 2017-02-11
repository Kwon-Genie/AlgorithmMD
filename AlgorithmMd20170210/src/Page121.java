import java.util.Scanner;
/**
 * �츮���� �ְ��� ��� �����̰� �̹��� �׸�׸� �� �������� ��ȸ�� �����Ѵ�.
 * �� ��ȸ���� 3���� ���尡 �ִµ�, ù ��° ����� 1���� ���·� ǥ���� ��
 * �ִ� ���� �������� ������ �׹��� ������ �ִ��� ���� ���⸦ ��� ���� �����̴�.
 * 1������ ���� ��� ������ ũ�Ⱑ 1*6�̰� �������� ��ġ�� ��ġ�� ������ ����
 * �� ����.
 * 1 0 2 0 4 3
 * ���⼭ �׹��� ũ��� 1*3�̶�� �� ��, ���� �� �ִ� ����� (1 0 2), (0 2 0), (2
 * 0 4), (0 4 3)�� 4���� ����� �ִ�.
 * �� �� ���� �̵��� ���� ����� ������ ��� 0 + 4 + 3 = 7�̴�. ���� �־���
 * ����� �ִ� �̵��� 7�� �ȴ�. �����̴� �ִ��� ��ġ�� ū �����⸦ ��Ƽ� �����
 * �� �;� �Ѵ�.
 * ������ ���� �� ĭ�� �ִ� �������� ��ġ, �׹��� ������ ���̿� ������ ���̰�
 * �־��� ��, ���� �� �ִ� �������� �ִ��̵��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�
 * ù ��° �ٿ� ������ �� N�� �Էµȴ�. ( N <= 100 �� �ڿ��� )
 * �� ��° �ٿ� �׹��� �� W�� �Էµȴ�. ( W <= N �� �ڿ��� )
 * �� ��° �� W���� �������� ��ġ�� �������� ���еǾ� �־�����. �� �������� ��
 * ġ�� 7������ �ڿ����̴�. 0�� ��쿡�� �����Ⱑ ���ٴ� �ǹ��̴�.
 * ���
 * ���� �� �ִ� �������� �ִ� ��ġ�� ����Ѵ�.
 * @since jdk1.8
 * @author Genie
 */
public class Page121 {
	/**
	 * sc: ������� �Է��� �޴µ� ���� ����
	 * n: ������ �� n <=100
	 * w: �׹��� �� w <= n
	 * worth: �������� ��ġ
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n, w;
	public static int[] worth;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		w = sc.nextInt();
		worth = new int[n];
		for(int i=0; i<n; i++) {
			worth[i] = sc.nextInt();
		}
		System.out.println(solve());
	}
	
	/**
	 * �׹� ���� ���� �� ���� �����Ⱑ ���� ���� ã�� ��ȯ�ϴ� �޼���
	 * @return
	 */
	public static int solve() {
		int result = 0;
		for(int i=0; i<n-w+1; i++)
			if(sum(i)>result)
				result = sum(i);
		return result;
	}
	
	/**
	 * Ư�� ��ġ���� �׹��� ������ ��
	 * �׹������� ������ �������� ��
	 * @param col
	 * @return
	 */
	public static int sum(int col) {
		int sum = 0;
		for(int i=col; i<col+w; i++) 
			sum += worth[i];
		return sum;
	}
}