package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {
	public static void main(String[] args) {
		// sort 정렬 방법은 오름차순 (10 -> 1), 내림차순(1 -> 10) 방법이 있다.
		ArrayList<String> list = new ArrayList<String>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성푼향");
		list.add("변학동");
		list.add("이순신");

		System.out.println("정렬전 : " + list);
		
		// 정렬은 Collections.sort(); 메소드를 이용하여 정렬한다.
		// collections.sort() 메소드는 기본적으로 내부 정렬 기준으로 정렬한다.
		// 자바의 기본 데이터들은 오름차순 정렬이 되도록 내부 정렬 기준이 만들어져 있다.
		Collections.sort(list);
		System.out.println("정렬후 : " + list);
		
		Collections.shuffle(list); //자료 섞기
		System.out.println("자료 섞기 후 : " + list);
		System.out.println("----------------------------------");
		
		//--------------------------------------------------
		//외부 정렬 기준을 사용해서 정렬하기
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 : " + list);
		System.out.println();
	}
}

/*
*정렬과 관련된 interface는 Comparable, Comparator 이렇게 두가지가 있다.
*Comparable은 Collection에 추가되는 데이터 자체의 정렬 기준을 넣고 싶을 때
*구현하는 인터페이스이다. ==> 내부 정렬 기준
*
*Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을때 사용한다.
*    ==> 외부 정렬 기준
*    
*Comparable에서는 compareTo()메서드를 재정의하고, 
*Comparator에서는 compare() 메서드르 재정의해서 정렬 기준을 정한다.
*
*String 클래스, Wrapper 클래스, Date 클래스, File 클래스에는 내부 정렬 기준이 
*구현되어 있다.(내부 정렬 기준은 기본적으로 오름차순으로 처리되도록 구현되어 있다.)
*/


// 외부 정렬 기준을 정해주는 클래스 작성하기
class Desc implements Comparator<String> {
	/*
	 * compare() 메서드의 반환값의 역할
	 * - 반환값이 0 	==> 두 값이 같다.(순서는 안 변한다.)
	 * - 반환값이 양수 ==> 두 값의 순서가 바뀐다.
	 * - 반환값이 음수 ==> 두 값의 순서가 바뀌지 않는다.
	 * 
	 * 예) 오름차순의 경우 ==> 앞의 값이 크면 양수, 같으면 0, 
	 * 					   앞의 값이 작으면 음수를 반환하도록 구현하면 된다.
	 */
	
	@Override
	public int compare(String str1, String str2) {
//		if (str1.compareTo(str2) > 0) {
//			return -1;
//		} else if (str1.compareTo(str2) < 0) {
//			return 1;
//		} else {
//			return 0;
//		}
		
		//내부 정렬 기준은 기본적으로 오름차순으로 정렬되기에
		//이때 반환되는 값의 양수와 음수를 바꾸어 주면 내림차순으로 다시 설정할 수 있다.
		return str1.compareTo(str2) * -1;
	}
	
}













