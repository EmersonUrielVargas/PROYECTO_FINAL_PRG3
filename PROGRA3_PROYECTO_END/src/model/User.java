package model;

public class User {
	
	private String nickName;
	private String password;
	private Person client;
	private TypeUser typeUser;
	
	
	public User(String nickName, String password, Person client, TypeUser typeUser) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.client = client;
		this.typeUser = typeUser;
	}
	
	public User() {
		
	}


	public String getNickName() {
		return nickName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public Boolean VerifyPassword(String password) {
		boolean isEquals = false;
		if (this.password.compareTo(password) == 0) {
			isEquals = true;
		}
		return isEquals;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Person getClient() {
		return client;
	}


	public void setClient(Person client) {
		this.client = client;
	}


	public TypeUser getTypeUser() {
		return typeUser;
	}


	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	
	
	
	

}
