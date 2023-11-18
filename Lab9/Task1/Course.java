package Task1;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	public Course(String name, String title, String type, List<Student> students, String lecturer) {
		super();
		this.name = name;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public List<Student> groupStudentsByYear(){
		List<Student> list = new ArrayList<Student>();
		for(Student i: students) {
			list.add(i);
		}
		return list;
	}


	@Override
	public String toString() {
		return "Course: Name:" + name + ",  title: " + title + ", type: " + type + ", students: " + students + ", lecturer: "
				+ lecturer;
	}

}
