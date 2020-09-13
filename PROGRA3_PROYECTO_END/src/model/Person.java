package model;

public class Person {
	private String name;
	private String lastName;
	private TypeId tipeId;
	private int numberId;
	
	
	public Person(String name, String lastName, TypeId tipeId, int numberId) {
		this.name = name;
		this.lastName = lastName;
		this.tipeId = tipeId;
		this.numberId = numberId;
	}
	
	public Person() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public TypeId getTipeId() {
		return tipeId;
	}


	public void setTipeId(TypeId tipeId) {
		this.tipeId = tipeId;
	}


	public int getNumberId() {
		return numberId;
	}


	public void setNumberId(int numberId) {
		this.numberId = numberId;
	}
	
	
	
	
	
}
