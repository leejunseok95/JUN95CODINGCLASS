package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 별명 중에
 * 별명의 길이가 가장 긴 별명을 출력하시오.
 * (단, 각 별명의 길이는 모두 다르게 입력한다.)
 */

public class ArrayListTest03 {
	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> nameList2 = new ArrayList<String>();
		ArrayList<String> sameLengthList = new ArrayList<String>();
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("문제 1번");
		System.out.println("5명의 별명을 입력하세요(단, 별명의 길이는 다르게)");
		for (int i = 0; i < 5; i++) {
			System.out.print("별명 : ");
			String inputName = scanner.next();
			nameList.add(inputName);
		}
		System.out.println();
		
		String tmpArrayName = nameList.get(0);
		for (int i = 0; i < nameList.size(); i++) {
			if (tmpArrayName.length() >= nameList.get(i).length()) {
				tmpArrayName = nameList.get(i);
			}
		}
		System.out.println("가장 긴 별명 : " + tmpArrayName);

		System.out.println("--------------------------------------------------");

		System.out.println("문제 2번");
		System.out.println("5명의 별명을 입력하세요");
		for (int i = 0; i < 5; i++) {
			System.out.print("별명 : ");
			String inputName = scanner.next();
			//입력한 문자의 길이가 같으면 다시 돌아가기를 하여 같은 길이의 문자를 입력하지 못하게 한다.
//			for (int j = 0; j < nameList2.size(); j++) {
//				if (inputName.length() == nameList2.get(j).length()) {
//					System.out.println("별명의 길이가 같습니다. 다시 입력해주세요");
//					i--;
//					break;
//				} 
//			}
			nameList2.add(inputName);
		}
		System.out.println();

		String tmpArrayName2 = null;
		int tmpArrayListSize2 = nameList2.get(0).length();
		for (int i = 0; i < nameList2.size(); i++) {
			for (int j = 0; j < nameList2.size(); j++) {
				if (nameList2.get(i).length() > tmpArrayListSize2) {
					tmpArrayListSize2 = nameList2.get(i).length();
					tmpArrayName2 = nameList2.get(i);
				}
				if (nameList2.get(i).length() == nameList2.get(j).length() && !(nameList2.get(i).equals(nameList2.get(j)))) {
					sameLengthList.add(nameList2.get(i));
				}
			}
		}
		System.out.println("가장 긴 별명 : " + tmpArrayName2 + "\n");
		for (int i = 0; i < sameLengthList.size(); i++) {
			System.out.println("길이가 중복되는 이름: " + sameLengthList.get(i));
		}
		scanner.close();
	}
}
