package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		//ArrayList의 기본 사용법은 Vector과 같다.
		//Vector는 동기화가 가능하지만, ArrayList는 동기화가 없다.
		
		ArrayList list1 = new ArrayList();
		
		//add()메서드로 데이터를 추가한다.
		list1.add("aaaa");
		list1.add("bbbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list1 ==> " + list1);
		System.out.println("size ==> " + list1.size());
		
		//get() 메서드로 데이터를 꺼내온다.
		System.out.println("1번째 데이터 : " + list1.get(1));
		
		//데이터 끼워넣기
		list1.add(3, "zzzz");
		System.out.println("list1 : " + list1);
		
		//데이터 변경하기
		String temp = (String)list1.set(3, "YYYY");
		System.out.println("temp = " + temp);
		System.out.println("list1 = " + list1);
		
		//제네릭 사용
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		
		System.out.println("----------------------------------------");
		//contains(비교객체) ==> list에 '비교객체'가 있으면 true
		//					   없으면 false를 반환한다.
		System.out.println("DDDD값 존재 여부 : " + list2.contains("DDDD"));
		System.out.println("ZZZZ값 존재 여부 : " + list2.contains("ZZZZ"));
		
		//indexOf(비교객체)
		//  ==> List에 '비교객체'가 있으면 '비교객체'가 있는 index값을 반환하고
		//		없으면 -1을 반환하다.
		System.out.println("DDDD값의 위치 : " + list2.indexOf("DDDD"));
		System.out.println("----------------------------------------");
		
		//toArray() ==> List 안의 데이터를 배열로 변환하여 반환한다.
		//			==> 기본적으로 Object형 배열로 반환한다.
		Object[] strArr = list2.toArray();
		System.out.println("배열의 개수 : " + strArr.length);
	}
}


















