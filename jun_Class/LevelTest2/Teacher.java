package leveltest2;

public class Teacher extends Human {
	public Teacher(String name, String gender) {
		super(name, gender,"선생님",0);
	}

	@Override
	public String toString() {
		return"이름 : "+getName()+" | 성별 : "+getGender()+" | 나이 : "+getAge();
	}
	
}
