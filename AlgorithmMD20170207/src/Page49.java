import java.util.Scanner;

/**
 * 3�� ����� X�� ������ �ϴ� Ŭ���� 
 * @since jdk1.8
 * @author Genie
 */
public class Page49 {
	
	public static void main(String[] args) {
		/**
		 * sc: ������� �Է��� ���� �� �ִ� ����
		 * n: 1���� n������ ���� ���� �ϸ� �˻��� n�� �Է¹��� ����
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			if(i%3==0)
				System.out.print("X ");
			else
				System.out.print(i+" ");
		}
	}

}
