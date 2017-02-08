package sort;

import java.util.Scanner;

/**
 * �������� ���� �ҽ��ڵ�
 * @since jdk 1.8
 * @author Genie
 */
public class SelectionSort {
	public static void main(String[] args) {
		/**
		 * sc Scanner Ŭ������ �̿��Ͽ� ������� �Է��� ���� ��ü ����
		 * testCaseNum ������ �迭�� ũ�⸦ �Է¹��� ����
		 * arr ������ �迭�� ������ ����� �迭 ���� 
		 */
		Scanner sc = new Scanner(System.in);
		int testCaseNum = 0;
		
		System.out.print("�迭�� ���̸� �Է��ϼ���: ");
		testCaseNum = sc.nextInt();
		int[] arr = new int[testCaseNum];
		System.out.print("�迭�� ���� �Է����ּ���: ");
		for(int index=0; index<testCaseNum; index++) {
			arr[index] = sc.nextInt();
		}
		selectionSort(arr);
		printArray(arr);
	}
	
	/**
	 * �Ķ���ͷ� ���� int �迭 ���������ϴ� �Լ� 
	 * @param arr
	 */
	public static void selectionSort(int[] arr) {
		for(int index=0; index<arr.length; index++) {
			for(int jIndex=index+1; jIndex<arr.length; jIndex++) {
				if(arr[index]>arr[jIndex]) {
					arr[index] = arr[index]+arr[jIndex];
					arr[jIndex] = arr[index]-arr[jIndex];
					arr[index] = arr[index]-arr[jIndex];
				}
			}
		}
	}
	
	/**
	 * �Ķ���ͷ� ���� int �迭 arr ����ϱ�
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
}