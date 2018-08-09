
/*
 * Created by wxn
 * 2018/7/25 17:14
 */


public class Student {

	private String name;
	private int score;

	public Student(String studentName , int studentScore){
		name = studentName;
		score = studentScore;
	}

	@Override
	public String toString(){
		return String.format("Student(name: %s, score: %d)" , name , score);
	}

	public static void main(String args[]) {
		Array<Student> arr = new Array<Student>();
		arr.addLast(new Student("yubeichuan" , 100));
		arr.addLast(new Student("yanghao" , 98));
		arr.addLast(new Student("xuzhenlei", 60));

		System.out.println(arr);
	}

}
