import java.util.Scanner;

/**
 * �־��� �迭�� �ִ밪�� �ش� ��ġ�� ����ϴ� Ŭ����
 * @since jdk1.8
 * @author Genie
 */
public class Page42 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է¹��� �迭�� ũ�� �Է�: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = arr[0];
		int pos = 0;
		for(int i=1; i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
				pos = i;
			}
		}
		System.out.println(max);
		System.out.println(pos+1);
	}
}
