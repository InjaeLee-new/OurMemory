package contact.dto;

public class QuestionDTO {
	private int question_num;
	private String question_subject;
	private String question_content;
	private String question_logtime;
	public int getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}
	public String getQuestion_subject() {
		return question_subject;
	}
	public void setQuestion_subject(String question_subject) {
		this.question_subject = question_subject;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getQuestion_logtime() {
		return question_logtime;
	}
	public void setQuestion_logtime(String question_logtime) {
		this.question_logtime = question_logtime;
	}
	
	
}
