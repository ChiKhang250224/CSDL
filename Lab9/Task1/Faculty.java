package Task1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxCourses = null;
		int maxStu = 0;

		for (Course c : courses) {
			if (c.getType().equals("TH") && c.getStudents().size() > maxStu) {
				maxCourses = c;
				maxStu = c.getStudents().size();
			}
		}
		if (maxCourses != null) {
			System.out.println("Khóa học thực hành có nhiều sinh viên nhất: " + maxCourses.getName());
		} else {
			System.out.println("Không tìm thấy khóa học thực hành nào.");
		}
		return maxCourses;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> re = new HashMap<>();
		for (Course c : courses) {
			for (Map.Entry<Integer, List<Student>> entry : re.entrySet()) {
				List<Student> list = entry.getValue();
				List<Student> stulist = c.groupStudentsByYear();
				for (Student i : stulist) {
					int yearkey = i.getYear();
					if (!list.contains(i) && yearkey == entry.getKey()) {
						re.put(yearkey, list);
					}
				}
			}
		}
		return re;
	}

	public Set<Course> filterCourses(String type) {
		TreeSet<Course> fc = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				return Integer.compare(c1.getStudents().size(), c2.getStudents().size());
			}
		});
		for (Course c : courses) {
			if (c.getType().equals(type)) {
				fc.add(c);
			}
		}
		return fc;
	}
}
