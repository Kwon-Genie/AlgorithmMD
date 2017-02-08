import java.util.Scanner;

/**
 * n개로 이루어진 정수 집합에서 원하는 수 k 이상인 수가 
 * 처음으로 등장하는 위치를 찾는 클래스
 * 책에 나와 있는 코드 실습
 * @author Genie
 *
 */
public class Page57Book {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0; i<list.length; i++)
			list[i] = sc.nextInt();
		int searchNum = sc.nextInt();
		System.out.println(lowerBound(list, 0, list.length, searchNum));
		
 	}
	
	/**
	 * lower bound를 찾는 메서드
	 * @param list
	 * @param start
	 * @param end
	 * @param searchNum
	 * @return 해당 위치
	 */
	public static int lowerBound(int[] list, int start, int end, int searchNum) {
		int middle;
		while(end-start>0) {
			middle=(start+end)/2;
			if(list[middle]<searchNum)
				start = middle+1;
			else
				end = middle;
		}
		return end+1;
	}
}
