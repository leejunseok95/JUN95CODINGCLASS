package leveltest2;

public class Student extends Human{
	public Student(String name, String gender, int age) {
		super(name, gender,"학생",age);
	}

	@Override
	public String toString() {
		return "이름 : "+getName()+" | 성별 : "+getGender()+" | 나이 : "+getAge();
	}
}
