package models;

public class Subject {
	
	private int subjectCode;
	private String subjectName;
	private Teacher teacher;
	public Subject(int subjectCode, String subjectName, Teacher teacher) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.teacher = teacher;
	}
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	

}
