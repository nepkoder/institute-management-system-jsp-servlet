package model;

public class StudentModel {

	private int id;
	private String name;
	private String country;
	private String gender;
	private String[] hobbies;
	private String hobby;

	public StudentModel() {
		// super();
	}

	public StudentModel(int id, String name, String country, String gender, String[] hobbies) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.hobbies = hobbies;
	}

	public StudentModel(String name, String country, String gender, String[] hobbies) {
		super();
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.hobbies = hobbies;
	}
	
	

	public StudentModel(int id, String name, String country, String gender, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	

}
