import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Page108�� �ִ� ����1
 * �� ���� n�� �Է¹޾Ƽ� n�� ��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
 * @author Genie
 *
 */
public class Page108 {
	/**
	 * sc ������� �Է��� ���� �� �ִ� ��������
	 * n ����ڿ��� �Է¹޴� ���� ���� ������ ��������
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		System.out.println(solve());
	}
	
	/**
	 * ����� ã�� �޼���
	 * 
	 * i�� 1���� n���� �ݺ��ϸ�
	 * n�� i�� ������ ������ �������� i�� n�� ����̹Ƿ�
	 * sum������ �ش� i�� ���� ���Ѵ�.
	 * @return
	 */
	public static int solve() {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(n%i==0)
				sum += i;
		}
		return sum;
	}
}
