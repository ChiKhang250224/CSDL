package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
				Student stu1 = new Student("001", "Nguyen Van A", 2023);
				Student stu2 = new Student("002", "Nguyen Van B", 2023);
				Student stu3 = new Student("003", "Nguyen Van C", 2023);
				Student stu4 = new Student("004", "Nguyen Van D", 2022);
				students.add(stu1);
				students.add(stu2);
				students.add(stu3);
				students.add(stu4);

		List<Course> courses = new ArrayList<>();
				Course c1 = new Course("C1", "Course 1", "TH", students, "Lecturer 1");
				Course c2 = new Course("C2", "Course 2", "LT", students, "Lecturer 2");
				courses.add(c1);
				courses.add(c2);

		Faculty faculty = new Faculty("Khoa CNTT", "TP.HCM", courses);

		Course maxPracticalCourse = faculty.getMaxPracticalCourse();
		System.out.println("Khoa hoc thuc hanh co nhieu sinh vien nhat: " + maxPracticalCourse.getName());

		Map<Integer, List<Student>> groupedStudents = faculty.groupStudentsByYear();
		System.out.println("Sinh vien vao hoc nam: " + groupedStudents);

		Set<Course> filteredCourses = faculty.filterCourses("TH");
		System.out.println("Cac khoa hoc loai 'TH': " + filteredCourses);
	}
}
