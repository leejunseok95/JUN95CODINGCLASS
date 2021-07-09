package leveltest2;

public class Human {
	private String name, gender, job;
	private int age;
	
	public Human(String name, String gender, String job, int age) {
		this.name = name;
		this.gender = gender;
		this.job = job;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "이름 : " + name + " | 성별 : " + gender + " | 직업 : " + job +" | 나이 : " + age;
	}
	
}
