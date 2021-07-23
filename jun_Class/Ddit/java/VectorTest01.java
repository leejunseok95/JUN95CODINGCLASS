package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		// 자바 고급 담당 : 이성엽 선생님
		// 객체 생성
		Vector v1 = new Vector();
		System.out.println("처음 크기 : " + v1.size());

		// 데이터 추가 : add(추가할 데이터) -> 추가할 데이터는 항상 객체여야한다.
		// 컬랙션에는 객체만을 담을 수 있다.
		// 반환값 : 성공(true), 실패(false)

		v1.add("aaaa");
		// 111은 일반 데이터지만 new Integer(Wrapper class)로 감싸서 객체화를 한다.
		v1.add(new Integer(111));
		// auto-boxing을 통해 123데이터를 감싸서 객체화를 진행함
		v1.add(123);
		v1.add('a');
		v1.add(3.14);
		boolean r = v1.add(true);

		System.out.println("현재 크기 : " + v1.size());
		System.out.println("현재 크기 : " + r);
		System.out.println("v1 =>" + v1);
		System.out.println();

		// 데이터 추가2 : addElement(추가할 데이터)
		// ==> 이전 버전부터 지원하는 메서드
		// ==> 이전 버전으로 작성된 프로그램을 위해서 남겨놓은 메서드
		v1.addElement("CCCC");
		System.out.println("v1 => " + v1);

		// 데이터 추가2 : add(index, 데이터);
		// ==> 'index'번째 '데이터'를 끼워 넣는다.
		// ==> 'index'는 0번부터 시작한다.
		// ==> 반환값은 없다.
		v1.add(1, "kkk");
		System.out.println("v1 => " + v1);

		// 데이터 꺼내오기 : get(index);
		// ==> 'index'번째 데이터를 반환한다.
		int data = (int) v1.get(3);

		// 데이터를 삽입할때는 Object형으로 오토박싱하여들어가지기에 괜찮지만
		// 이를 get으로 꺼내올때는 Object형으로 꺼내지기에 오토 언박싱이 필요하다.
		System.out.println("3번째 데이터 : " + data);

		// 데이터 변경하기 : set(index, 새로운 데이터)
		// ==> 'index'번째의 데이터를 '새로운데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터
		String temp = (String) v1.set(0, "zzzzz");
		System.out.println("v1 =>" + v1);
		System.out.println("반환값 : " + temp);

		/*
		 * 데이터 삭제하기 : remove(index) ==>'index'번째의 데이터를 삭제한다. ==> 반환값 : 삭제된 데이터
		 */
		temp = (String) v1.remove(0);
		System.out.println("v1 =>" + v1);
		System.out.println("삭제된 데이터 : " + temp);

		/*
		 * 데이터 삭제하기 : remove(삭제할 데이터) 
		 * ==>'index'번째의 데이터를 삭제한다. 
		 * ==> 삭제할 데이터가 여러개이면 앞에서부터
		 * 삭제된다. --> 반환값 : 삭제성공(true), 삭제실패(false)
		 */
		v1.remove("CCCC");
		System.out.println("삭제후 : " + v1);
		
		//아래의 코드는 에러가 발생하는 코드, 123번째 배열을 제거한다는 뜻이기에 박싱을 해줘야한다.
		v1.remove(new Integer(123)); // new Integer(123)으로 박싱하면 해결
		System.out.println("삭제후 : " + v1);
		
		v1.remove(new Character('a'));
		System.out.println("삭제후 : " + v1);
		v1.remove(true);
		v1.remove(3.1);
		System.out.println("삭제후 : " + v1);
		
		//전체 데이터 삭제 : clear();
		v1.clear();
		System.out.println("전체 삭제 후 : " + v1);
		
		/*
		 * 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 외부에서 지정하는 기법
		 * ==> 객체를 선언할 때 <> 안에 그 객체가 사용할 타입을 정해주는
		 * 것을 말한다.
		 * ==> 이런식으로 객체를 선언하게 되면 다른 종류의 데이터를 저장할 수 없다.
		 * ==> 이 때 제네릭으로 선언될 수 있는 데이터 타입을 클래스형이어야 한다.
		 * (int - Integer, boolean - Boolean, char - Character 등으로 대체해서 사용해야한다.)
		 * ==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형 변환이 필요없다.
		 */
		
		Vector<String> v2 = new Vector<String>();
		v2.add("Hello");
//		v2.add(123); 오류 : 다른 종류의 데이터를 저장할 수 없다.
		
		String temp2 = v2.get(0); //형변환 없이 자료를 꺼내올 수 있다.
		System.out.println(temp2);
		
		//이차원 배열처럼 vecotr안에 또 vector을 넣어서 사용할 수 있다.
		Vector<Vector> vv = new Vector<Vector>();
		
		System.out.println("-------------------------------------------------------------");
		
		v2.clear();
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v3 = new Vector<String>();
		v3.add("BBB");
		v3.add("EEE");
		
		System.out.println("v2 = " + v2);
		System.out.println("v3 = " + v3);
		
		//데이터 삭제하기 : removeAll(Collection 객체)
		// ==> 'Collection 객체'가가지고 있는 데이터를 찾아서 모두 삭제한다.
		// ==> 반환값 : 삭제성공(true), 삭제실패(false)
		v2.removeAll(v3);
		System.out.println("v2 => " + v2);
		
		System.out.println("-------------------------------------------------------------");
		v2.clear();
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		//벡터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.
		//(주로 for문을 사용)
		System.out.println("일반적인 for문");
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료" + v2.get(i));
		}
		System.out.println("-------------------------------------------------------------");
		
		//향산된 for문
		System.out.println("향상된 for문");
		for (String s : v2) {
			System.out.println(s);
		}
		System.out.println("-------------------------------------------------------------");
	}
}


















