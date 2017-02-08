import java.util.Scanner;

/**
 * 3의 배수는 X로 나오게 하는 클래스 
 * @since jdk1.8
 * @author Genie
 */
public class Page49 {
	
	public static void main(String[] args) {
		/**
		 * sc: 사용자의 입력을 받을 수 있는 변수
		 * n: 1부터 n까지의 수를 나열 하며 검사할 n을 입력받을 변수
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
