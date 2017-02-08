import java.util.Scanner;

/**
 * n���� �̷���� ���� ���տ��� ���ϴ� ���� ��ġ�� ã�� Ŭ����
 * @since jdk1.8
 * @author Genie
 */
public class Page53 {
	public static void main(String[] args) {
		/**
		 * sc ������� �Է��� �ޱ� ���� ����
		 * n �迭�� ũ�⸦ �����ϱ� ���� ����
		 * list nũ�� ��ŭ�� int�� �迭 ����
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0; i<list.length; i++) {
			list[i] = sc.nextInt();
		}
		int searchNum = sc.nextInt();
		System.out.println(search(list, 0, list.length-1, searchNum));
	}
	
	/**
	 * ���ĵ� �迭�� �־����� ������ binary search�� ����
	 * @param list
	 * @param start ������ġ
	 * @param end �� ��ġ
	 * @param searchNum ã���� �ϴ� ��
	 * @return
	 */
	public static int search(int[] list, int start, int end, int searchNum) {
		while(start<=end) {
			int m = (start+end)/2;
			if(list[m]==searchNum)
				return m+1;
			else if(list[m]>searchNum)
				end = m-1;
			else if(list[m]<searchNum)
				start = m+1;
		}
		return -1;
	}

}
