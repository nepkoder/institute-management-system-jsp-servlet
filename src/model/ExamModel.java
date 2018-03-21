package model;

public class ExamModel {
	
	private int eid;
	private String question;
	private Answer answer;
	
	public ExamModel(int eid, String question, Answer answer) {
//		super();
		this.eid = eid;
		this.question = question;
		this.answer = answer;
	}

	public ExamModel(String question, Answer answer) {
//		super();
		this.question = question;
		this.answer = answer;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	

}
