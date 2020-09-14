package models;

import comparators.ComparatorByCourse;
import comparators.ComparatorByStudent;
import comparators.ComparatorBySubject;
import comparators.ComparatorByTeacher;
import comparators.ComparatorByUsers;
import enums.TypeUser;
import structures.AVLTree;

public class Manager {
	
	private AVLTree<User> users;
	private AVLTree<Subject> subjects;
	private AVLTree<Teacher> teachers;
	private AVLTree<Student> students;
	private AVLTree<Course> courses;
	
	public Manager() {
		users = new AVLTree<User>(new ComparatorByUsers());
		subjects = new AVLTree<Subject>(new ComparatorBySubject());
		teachers = new AVLTree<Teacher>(new ComparatorByTeacher());
		students = new AVLTree<Student>(new ComparatorByStudent());
		courses  = new AVLTree<Course>(new ComparatorByCourse());
		createAdmin();
	}
	
	private void createAdmin() {
		users.insert(new User(new Person(), TypeUser.ADMIN));
	}
	
	public void addStudent(Student student) {
		students.insert(student);
		users.insert(new User(student, TypeUser.STUDENT));
	}
	
	public void removeStudent(Student student) {
		students.delete(student);
		users.delete(new User(student, TypeUser.STUDENT));

	}
	
	public Student askStudent(Student student) {
		return students.ask(student, students.getRoot()).getData();
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.insert(teacher);
		users.insert(new User(teacher, TypeUser.TEACHER));
	}
	
	public void removeTeacher(Teacher teacher) {
		teachers.delete(teacher);
		users.delete(new User(teacher, TypeUser.TEACHER));
	}
	
	public boolean verifyUser(String nickName , String password) {	
		return users.exist(new User(nickName, password), users.getRoot());
	}
	
	public Teacher askTeacher(Teacher teacher) {
		return teachers.ask(teacher, teachers.getRoot()).getData();
	}
	
	public void addSubject(Subject subject) {
		subjects.insert(subject);
	}
	
	public void removeSubject(Subject subject) {
		subjects.delete(subject);
	}
	
	public Subject askSubject(Subject subject) {
		return subjects.ask(subject, subjects.getRoot()).getData();
	}
	
	public void assingTeacherToCourse(Teacher teacher , Course course) {
		course.setCourseDirector(teacher);
	}
	
	public void assingTeacherToSubject(Teacher teacher , Subject subject) {
		subject.setTeacher(teacher);
	}
	
	public void addPartialNote(PartialNote partialNote , Student student , String subjectName) {
		student.addPartialNote(partialNote, subjectName);
	}
	
	public void modifyPartialNote(String subjectName, String topic, double value, String notation,Student student) {
		Student studentAux=  students.ask(student, students.getRoot()).getData();
		FinalNote auxiliar = studentAux.askFinalNote(subjectName);
		auxiliar.modifyPartialNote(topic, value, notation);
	}

	public PartialNote askPartialNote(String topic, String subjectName,Student student) {
		Student studentAux=  students.ask(student, students.getRoot()).getData();
		FinalNote auxiliar = studentAux.askFinalNote(subjectName);
		return auxiliar.askPartialNote(topic);
	}

	public void addComment(String topic, String comment, String subjectName,Student student) {
		Student studentAux=  students.ask(student, students.getRoot()).getData();
		FinalNote auxiliar = studentAux.askFinalNote(subjectName);
		PartialNote note = auxiliar.askPartialNote(topic);
		note.setComment(comment);
	}

	public FinalNote askFinalNote(String subjectName, Student student) {
		Student studentAux=  students.ask(student, students.getRoot()).getData();
		return studentAux.askFinalNote(subjectName);
	}
	
	public AVLTree<User> getUsers() {
		return users;
	}

	public void setUsers(AVLTree<User> users) {
		this.users = users;
	}

	public AVLTree<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(AVLTree<Subject> subjects) {
		this.subjects = subjects;
	}

	public AVLTree<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(AVLTree<Teacher> teachers) {
		this.teachers = teachers;
	}

	public AVLTree<Student> getStudents() {
		return students;
	}

	public void setStudents(AVLTree<Student> students) {
		this.students = students;
	}

	public AVLTree<Course> getCourses() {
		return courses;
	}

	public void setCourses(AVLTree<Course> courses) {
		this.courses = courses;
	}
	
	
	

	

}
