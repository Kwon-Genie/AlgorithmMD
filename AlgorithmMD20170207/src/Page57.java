import java.util.Scanner;

/**
 * n개로 이루어진 정수 집합에서 원하는 수 k 이상인 수가 
 * 처음으로 등장하는 위치를 찾는 클래스
 * @author Genie
 *
 */
public class Page57 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0; i<list.length; i++) {
			list[i] = sc.nextInt();
		}
		int searchNum = sc.nextInt();
		System.out.println(findBig(list, searchNum));
	}
	
	/**
	 * 큰 위치를 찾아 반환하는 메서드
	 * @param list
	 * @param searchNum
	 * @return
	 */
	public static int findBig(int[] list, int searchNum) {
		for(int i=0; i<list.length; i++) {
			if(list[i]>=searchNum)
				return i+1;
		}
		return list.length+1;
	}
}
