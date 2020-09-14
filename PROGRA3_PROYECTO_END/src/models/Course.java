package models;

import comparators.ComparatorByStudent;
import enums.TypeId;
import structures.AVLTree;

public class Course {
	
	private String nameCourse;
	private AVLTree<Student> students ;
	private Teacher courseDirector;
	
	public Course(String nameCourse, Teacher courseDirector) {
		super();
		this.nameCourse = nameCourse;
		this.courseDirector = courseDirector;
		students =  new AVLTree<>(new ComparatorByStudent());
	}
	
	public void remoteCourseDirector() {
		courseDirector = null;
	}
	
	public void reeplaceCourseDirector(Teacher courseDirector) {
		this.courseDirector = courseDirector;
	}
	
	public void addStudent(Student student) {
		students.insert(student);
	}
	
	public Student askStudent(int numberId) {
		return students.ask(new Student("", "", TypeId.CC,numberId), students.getRoot()).getData();
	}
	
	public void removeStudent(int numberId) {
		students.delete(new Student("", "", TypeId.CC, numberId));
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public AVLTree<Student> getStudents() {
		return students;
	}

	public void setStudents(AVLTree<Student> students) {
		this.students = students;
	}

	public Teacher getCourseDirector() {
		return courseDirector;
	}

	public void setCourseDirector(Teacher courseDirector) {
		this.courseDirector = courseDirector;
	}
	
	
	
	

}
