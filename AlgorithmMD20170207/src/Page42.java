import java.util.Scanner;

/**
 * 주어진 배열의 최대값과 해당 위치를 출력하는 클래스
 * @since jdk1.8
 * @author Genie
 */
public class Page42 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력받을 배열의 크기 입력: ");
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
