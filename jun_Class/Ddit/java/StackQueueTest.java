package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueueTest {
	/*
	 * Stack ==> 후입선출(LIFO)의 자료구조. ex) 홈페이지 뒤로가기
	 * 
	 * Queue ==> 선입선출(FIFO)의 자료구조 ex) 프린터기 출력
	 * 
	 * Stack과 Queue는 
	 */
	public static void main(String[] args) {
		/*
		 * Stack의 명령
		 * 1. 자료 입력: push(입력할값);
		 * 2. 자료 출력: pop() ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 * 			   peek() ==> 삭제없이 자료를 꺼내온다.
		 */
//		Stack<String> stack = new Stack<String>();
		LinkedList<String> stack = new LinkedList<String>();
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("면학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack값 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 stack값 : " + stack);
		
		stack.push("성충향");
		System.out.println("새로 추가 후 Stack값 : " + stack);		
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 stack값 : " + stack);
		
		System.out.println("삭제없이 꺼내온 값: " + stack.peek());
		System.out.println("현재 stack값 : " + stack);
		System.out.println("===========================================");
		System.out.println("스택은 위 3가지 명령어만 있으면 해결할 수 있다.");		
		System.out.println("===========================================");
		System.out.println();
		
		/*
		 * Queue의 명령
		 * 1. 자료 입력: offer(입력값)
		 * 2. 자료 출력: poll() ==> 자료를 꺼내온 후 꺼내온 자료를 삭제한다.
		 * 			   peek() ==> 삭제없이 자료를 꺼내온다.
		 */
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer("이준석");
		queue.offer("이명석");
		queue.offer("이인환");
		queue.offer("안대근");
		
		System.out.println("현재 queue의 값: " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값: " + temp);
		System.out.println("꺼내온 값: " + queue.poll());
		System.out.println("현재 queue의 값: " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue의 값: " + queue);
		System.out.println("꺼내온 값: " + queue.poll());
		
		System.out.println("삭제없이 꺼내온 값: " + queue.peek());		
		System.out.println("현재 queue의 값: " + queue);
		System.out.println("===========================================");
		System.out.println("큐은 위 3가지 명령어만 있으면 해결할 수 있다.");		
		System.out.println("===========================================");
	}
}












