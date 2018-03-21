package model;

public class CourseStudent {

	private int id;
	private int cid;
	private String title;
	private int sid;
	private String name;

	public CourseStudent() {
//		super();
	}

	public CourseStudent(int id, int cid, String title, int sid, String name) {
//		super();
		this.id = id;
		this.cid = cid;
		this.title = title;
		this.sid = sid;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
